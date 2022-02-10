var flowConfig = {
	defaultConfig: {
		resizableFlag: false, //是否可以缩放
		smallMovePX: 1,
		testPwd: "root"
	},
	defaultStyle: {
		selectedBoxShadow: "rgb(0, 0, 0) 0px 0px 20px 0px",
		noSelectedBoxShadow: "",
		dragOpacity: 0.8
	},
	conn: {
        /**
		 * Bezier: 贝塞尔曲线
		 * : 具有90度转折点的流程线
		 * StateMachine: 状态机
		 * Straight: 直线
         */
		connectionType: "StateMachine",
		connectionGap: 8,
		connectionCornerRadius: 5,
		connectionAlwaysRespectStubs: true,
		connectionStub: 30,
		isDetachable: false
	},
	arrow: {
		arrowWidth: 12,
		arrowLength: 12,
		arrowLocation: 1

	},
	endPonit: {
		endPointStrokeWidth: 3,
		endPointRadius: 3,
		hoverEndPointStroke: "blue"
	},
	anchors: {
		defaultAnchors: ["Bottom", "Right", "Top", "Left"],  //默认锚点
		sourceAnchors: [],   //源锚点
		targetAnchors: [],  //目的锚点
		sameAnchorsFlag: true  //目标节点是否采用与源节点同样的配置
	},
	alignParam: {
		levelDistance: 100,
		verticalDistance: 100,
		alignDuration: 500
	},
	keyboardParam: {
		multipleSelectedKey: 17,
		deleteKey: 46,
		upKey: 38,
		downKey: 40,
		leftKey: 37,
		rightKey: 39,
		undoKey: 90,
		redoKey: 89,
		selectedAllKey: 65,
		saveKey: 83,
		save2PhotoKey: 80,
		clearKey: 68,
		showGridKey: 81,
		mouseToolKey: 81,
		connectionToolKey: 82,
		settingKey: 70
	},
	msg: {
        noNode: "保存失败，流程图不存在任何节点",
		noConn: "保存失败，流程图存在未连接的节点",
		repeatStepNum: "保存失败，流程图中存在重复步骤号",
		hasAcyclic: "保存失败，流程图中存在循环路径",
		noNodeBySave2Photo: "图中无节点，无法保存为图片",
		deleteConn: "确定要删除连接吗？",
		deleteLane: "删除成功",
		deleteNode: "删除成功",
		chooseNodeObjErr: "节点类型选择错误！",
		saveSuccess: "流程保存成功",
		saveObjErr: "发送未知错误，保存失败，请联系管理员",
		clearConfirm: "确定要清空当前画布吗？",
		noFrontRoute: "无前继路径",
		noBehindRoute: "无后续路径",
		alignWayCheck: "请选择两个或两个以上的节点对齐",
		repeatRouter: "重复路由",
        moreThenTwoRouter: "存在两条以上路由",
        endWithSOPNode: "目的节点不允许为开始节点(SOP)",
        startWithEndNode: "起始节点不允许为结束节点",
		closeFrame: "当前流程图还未保存，确认退出吗？",
		repeatSOPNode: "重复的开始节点(SOP)",
        repeatEOPNode: "重复的结束节点(EOP)",
        repeatEOPFNode: "重复的结束节点(EOPF)",
		currentProgress: "当前进度",
		noFrontNode: "无前继节点",
		noBehindNode: "无后续节点",
        noStartNode: "无开始节点",
        noEndNode: "无结束节点",
		noBndAndCnd: "无基础节点或者组合节点",
		illegalBranch: "流程图中部分节点缺少Y或者N出口",
		frontNode: "前继节点",
		behindNode: "后续节点",
		flowNodeItem3Li1: "- 无 -",
		flowNodeItem5: "显示前导节点",
		flowNodeItem6: "显示后续节点"
	}
}

/**
 resizableFlag                   节点是否可以被缩放，默认为false
 smallMovePX                     微移幅度
 testPwd							打开测试窗口的校验密码

 selectedBoxShadow               被选中的节点阴影样式
 noSelectedBoxShadow             非选中的节点阴影样式
 dragOpacity                     可拖拽列表中克隆对象视觉效果的透明度

 connectionType                  连线类型
 connectionGap                   连线到端点的距离
 connectionCornerRadius
 connectionAlwaysRespectStubs
 connectionStub                  连线第一个转角距离
 isDetachable                    连线是否允许拖拽断开

 arrowWidth                      箭头宽度
 arrowLength                     箭头长度
 arrowLocation                   箭头位置

 endPointStrokeWidth             端点宽度
 endPointRadius                  端点圆角
 hoverEndPointStroke             端点鼠标悬浮样式

 defaultAnchors                  默认锚点
 sourceAnchors                   源节点锚点
 targetAnchors                   目标节点锚点
 sameAnchorsFlag                 目标节点是否采用与源节点同样的配置

 levelDistance                   水平间距
 verticalDistance                垂直间距
 alignDuration                   对齐动画持续时间

 keyboardParam中配置的是快捷键的key值

 msg中配置的是提示等相关的中文信息
 */

  