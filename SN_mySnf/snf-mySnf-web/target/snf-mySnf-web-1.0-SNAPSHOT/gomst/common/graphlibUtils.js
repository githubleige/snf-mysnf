/**
 * 重置全局图对象
 * @param {Graph} graph
 */
function resetGraphObj() {
	graph = null;
	graph = new graphlib.Graph();
}

/**
 * 连接两个节点
 * @param {String} id1 源节点id
 * @param {String} id2 目标节点id
 * @param {String} routerId 连接线id
 */
function connectTwoNode(id1, id2, routerId, sourceAnchors, targetAnchors) {
	//新增端点，一条连接线两个端点
	var sourceEndPointId = addEndPointById(id1, sourceAnchors);
	var targetEndPointId = addEndPointById(id2, targetAnchors);
	
	//连接线段
	INSTANCE_JSPLUMB.connect({
		//通过编码连接endPoint，连线不会混乱
		uuids: [sourceEndPointId, targetEndPointId]
		//源节点
		//source: id1,
		//目标节点
		//target: id2,
		//端点
		//endpoint: 'Rectangle'
	}, common)
	
	//将线段添加到图对象中
	var connId = routerId;
	graph.setEdge(id1, id2, {
		id: connId,
		sourceEndPointId: sourceEndPointId,
		targetEndPointId: targetEndPointId,
		sourceAnchors: sourceAnchors,
		targetAnchors: targetAnchors
	});
}

/**
 * 根据id移除节点以及关于节点的所有连线，返回删除的路由线id数组
 * @param {String} id
 */
function removeNodeAndEdgesById(id) {
	var deleteRouterIdArr = [];
	$.each(graph.nodeEdges(id), function() {
		var v = $(this)[0].v;
		var w = $(this)[0].w;
		var e = graph.edge(v, w);
		deleteRouterIdArr.push(e.id);
		if (e.sourceEndPointId != undefined) {
			INSTANCE_JSPLUMB.deleteEndpoint(e.sourceEndPointId);
			INSTANCE_JSPLUMB.deleteEndpoint(e.targetEndPointId);
		}
		graph.removeEdge($(this)[0].v, $(this)[0].w);
	});
	graph.removeNode(id);
	return deleteRouterIdArr;
}

/**
 * 检查图像是否合法
 */
function checkGraph() {
	//克隆graph对象
	var copyGraph = $.extend(true, {}, graph);
	var msg = '0';
	var componentLen = graphlib.alg.components(copyGraph).length;
	
	if (componentLen == 0) {
		//检查是否无节点
		msg = CONFIG.msg.noNode;
        return msg;
	} else if (componentLen > 1) {
		//检查是否存在孤儿节点
		msg = CONFIG.msg.noConn;
        return msg;
	} else if (!graphlib.alg.isAcyclic(copyGraph)) {
		//检查是否存在死循环
		msg = CONFIG.msg.hasAcyclic;
        return msg;
	}
	
	//检查是否存在重复的步骤号
	var nodes = copyGraph.nodes(), i, ndMap = new Map(),ndArr = [],ndKeyArr=[];

	for (i = 0; i < nodes.length; i++) {
		var node = copyGraph.node(nodes[i]);
		var sn = node.stepNum;
        ndArr.push(node.nodeCode);
        ndKeyArr.push(node.key);
		if(!ndMap.has(sn)){
			ndMap.set(sn,node.nodeCode);
		}
		else{
			var nd1 = ndMap.get(sn), nd2 = node.nodeCode;
            msg = CONFIG.msg.repeatStepNum+',重复步骤号：'+ sn +', 重复的节点编码:'+nd1+','+nd2;
		}
	}
	if(msg != '0'){
		return msg;
	}
	//检查是否有开始节点
	if(!ndArr.includes('SOP')){
        msg = CONFIG.msg.noStartNode;
        return msg;
	}

	//检查是否有结束节点
    if(!ndArr.includes('EOP')&&!ndArr.includes('EOPF')){
        msg = CONFIG.msg.noEndNode;
        return msg;
    }

    //检查是否存在基础节点或者组合节点
    var hasBndOrCnd = false;
    ndKeyArr.forEach(function (value, index, array) {
        if(value.startsWith('T')){
            hasBndOrCnd = true;
            return;
        }
    });
    if(!hasBndOrCnd){
        msg = CONFIG.msg.noBndAndCnd;
        return msg;
    }
    //检查是否存在非法分支
    var checkMsg = checkIllegalBranch();
    if(checkMsg.length > 0){
        msg = CONFIG.msg.illegalBranch+"<br/>非法节点："+checkMsg.join(', ');
    }
    
	return msg;
}

/**
 * 检查流程是否存在非法分支
 * 1、节点存在双Y、或者双N出口
 * 2、节点存在ALL+Y或者ALL+N
 * 3、节点仅存在一个非ALL出口
 */
function checkIllegalBranch() {
    var msgArr=[];
    var obj = getCurrentFlowDoc();
    var nodeArr = obj.nodeDataArray;
    var linkArr = obj.linkDataArray;
    var ndMap1 = new Map();
    var ndMap2 = new Map();
    nodeArr.forEach(function (value, index, array) {
        if(!ndMap1.has(value.stepNum+'->'+value.nodeCode)){
            ndMap1.set(value.key,value.stepNum+'->'+value.nodeCode)
        }
    });
    linkArr.forEach(function (value, index, array) {
        if(ndMap2.has(value.from)){
            ndMap2.set(value.from, ndMap2.get(value.from)+'##'+value.label)
        }
        else{
            ndMap2.set(value.from, value.label)
        }
    });
    ndMap2.forEach(function (value, key, map) {
        var ndlabelArr = value.split('##');
        if(ndlabelArr.length===1){
            if(ndlabelArr[0]!= 'ALL'){
                msgArr.push(ndMap1.get(key));
            }
        }
        else{
            var label1 = ndlabelArr[0];
            var label2 = ndlabelArr[1];
            if(label1==='ALL'||label2==='ALL'){
                msgArr.push(ndMap1.get(key));
            }
        }
    });
    return msgArr;
}


/**
 * 放置、粘贴新节点时检查图对象
 * @param nodeType 节点类型
 */
function checkCurrentGraph(nodeType) {
	var msg = '0';
	if (nodeType == 'sop'||nodeType == 'eop'||nodeType == 'eopf') {
		var nodes = graph.nodes(), i;
		for (i = 0; i < nodes.length; i++) {
			if (nodeType=='sop'&&graph.node(nodes[i]).nodeType == nodeType) {
				msg = CONFIG.msg.repeatSOPNode;
				return msg;
			}
            if (nodeType=='eop'&&graph.node(nodes[i]).nodeType == nodeType) {
                msg = CONFIG.msg.repeatEOPNode;
                return msg;
            }
            if (nodeType=='eopf'&&graph.node(nodes[i]).nodeType == nodeType) {
                msg = CONFIG.msg.repeatEOPFNode;
                return msg;
            }
		}
	}
	return msg;
}

/**
 * 保存为图片之前检查是否合法
 */
function checkGraphBySave2Photo() {
	var nodeArr = graph.nodes(), msg = '0';
	if (nodeArr.length <= 0) {
		msg = CONFIG.msg.noNodeBySave2Photo;
	}
	return msg;
}

/**
 * 在图对象中获取被选中的节点 id 列表
 */
function getSelectedNodeIdArr() {
	var selectedNodeIdArr = [];
	var nodeIds = graph.nodes();
	$.each(graph.nodes(), function(index) {
		if (graph.node(nodeIds[index]).isSelected) {
			selectedNodeIdArr.push(nodeIds[index]);
		}
	});
	return selectedNodeIdArr;
}

/**
 * 在图对象中获取被选中的节点 id 列表添加到被选中节点列表中
 */
function getSelectedNodeIdArr2SelectedNodeList() {
	var nodeIds = graph.nodes();
	$.each(graph.nodes(), function(index) {
		if (graph.node(nodeIds[index]).isSelected) {
			SELECTED_NODE_LIST.push(nodeIds[index]);
		}
	});
}

/**
 * 对齐方式检查
 */
function alignWayCheck() {
	//获取所有被选中的节点 id
	var selectedNodeIdArr = SELECTED_NODE_LIST;
	if (selectedNodeIdArr.length < 2) {
		layer.msg(CONFIG.msg.alignWayCheck, { icon: 5 });
		return null;
	}
	return selectedNodeIdArr;
}

/**
 * 更新图对象中的node
 */
function updateGraphNode(id) {
	var $this = $(getJquerySelectorPrefix(id));
	var graphNode = graph.node(getRemovePrefixId(id));
	
	//由于超过五个字节点上不再显示，所有这里不能用节点的text去更新图对象
	graphNode.text = $this.children(':first-child').text();
	
	graphNode.locTop = $this.offset().top;
	graphNode.locLeft = $this.offset().left;
	graphNode.nodeHeight = $this.css('height');
	graphNode.nodeWidth = $this.css('width');
	graphNode.bgColor = $this.attr('bgColor-gradient');
}

/**
 * 更新所有图对象中的node
 */
function updateAllGraphNode() {
	var nodeArr = graph.nodes();
	var index;
	for (index = 0; index < nodeArr.length; index++) {
		updateGraphNode(nodeArr[index]);
	}
}

/**
 * 更新泳道对象
 * @param {String} id 泳道id
 */
function updateLaneObjs(id) {
	var $this = $(getJquerySelectorPrefix(id));
	var laneObj = LANEOBJS[getRemovePrefixId(id)];
	
	laneObj.locTop = $this.offset().top;
	laneObj.locLeft = $this.offset().left;
	laneObj.nodeHeight = $this.css('height');
	laneObj.nodeWidth = $this.css('width');
	laneObj.bgColor = $this.attr('bgColor-gradient');
}

/**
 * 通过id复制节点属性到变量
 * @param {String} id
 * @param {Object} p
 */
function copyNodeAttrById(id, p) {
	var nodeObj = {};
	var n = graph.node(id);
	
	nodeObj.text = n.text;
	nodeObj.nodeType = n.nodeType;
	nodeObj.locTop = p.top;
	nodeObj.locLeft = p.left;
	nodeObj.nodeHeight = n.nodeHeight;
	nodeObj.nodeWidth = n.nodeWidth;
	nodeObj.bgColor = n.bgColor;
	
	//为不同类型的节点选择不同的样式
	var v = chooseNodeObjFromType(n.nodeType);
	nodeObj.newId = v.newId;
	nodeObj.cla = v.cla;
	nodeObj.nodeType = v.nodeType;
	nodeObj.icon = v.icon;
	
	return nodeObj;
}

/**
 * 根据画布中的节点获取canvas的尺寸
 */
function getCanvasSizeByNode() {
	var nodeArr = graph.nodes();
	var firstNodeTop = graph.node(nodeArr[0]).locTop;
	var firstNodeLeft = graph.node(nodeArr[0]).locLeft;
	var maxTop = firstNodeTop;
	var minTop = firstNodeTop;
	var maxLeft = firstNodeLeft;
	var minLeft = firstNodeLeft;
	var i;
	
	for (i = 0; i < nodeArr.length; i++) {
		var t = graph.node(nodeArr[i]).locTop;
		var l = graph.node(nodeArr[i]).locLeft;
		
		if (t > maxTop) {
			maxTop = t;
		}
		if (t < minTop) {
			minTop = t;
		}
		if (l > maxLeft) {
			maxLeft = l;
		}
		if (l < minLeft) {
			minLeft = l;
		}
	}
	
	return {
		canvasTop: maxTop + minTop,
		canvasLeft: maxLeft + minLeft
	};
}

/**
 * 获取节点的四个点坐标
 * @param {String} nodeId 节点id
 */
function getNodeCoordinate(nodeId) {
	nodeId = getJquerySelectorPrefix(nodeId);
	var x11 = $(nodeId).offset().left;
	var y11 = $(nodeId).offset().top;
	var x22 = x11 + parseInt($(nodeId).css('width'));
	var y22 = y11;
	var x33 = x11 + parseInt($(nodeId).css('width'));
	var y33 = y11 + parseInt($(nodeId).css('height'));
	var x44 = x11;
	var y44 = y11 + parseInt($(nodeId).css('height'));
	
	return {
		x11: x11,
		y11: y11,
		x22: x22,
		y22: y22,
		x33: x33,
		y33: y33,
		x44: x44,
		y44: y44
	};
}

/**
 * 获取所有路由id
 */
function getAllRouterId() {
	var res = [];
	var edges = graph.edges(), i;
	for (i = 0; i < edges.length; i++) {
		var routerId = graph.edge(edges[i].v, edges[i].w).id;
		if (routerId != undefined) {
			res.push(routerId);
		}
	}
	return res;
}
