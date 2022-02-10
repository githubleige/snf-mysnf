/*
* Author:   12061253
* Description: //apm系统提供给第三方系统的菜单js，用于生成菜单dom树，支持无限层级，根据第三方系统的需求找前端定制修改
*/
(function($) {
    var wihteMenu;
    var menuHtml,
        crumbsHtml,
        openPath = [],
        nodeIconClasses={"收藏夹":"shoucangjia","财务管理":"caiwuguanli","系统管理":"xitongguanli","招商管理":"zhaoshangguanli","供应链管理":"gongyinglianguanli","服务市场":"fuwushichang","商家考核":"shangjiakaohe","店铺管理":"dianpuguanli","营销管理":"yingxiaoguanli","数据管理":"shujuguanli","公共服务":"gonggongfuwu","云管理":"yunguanli","商品管理":"shangpinguanli","移动sop":"yidongsop","交易管理":"jiaoyiguanli","售后管理":"shouhouguanli","物流管理":"wuliuguanli"},
        tmpMap = [],
        root = [],
        urlMapping=[],
        pathName = window.location.pathname,
        origin = window.location.protocol+"//"+ window.location.host,
        key = "code",
        parentKey = "parent",
        childKey = "children",
        openKey ="open",
        activeKey="active",
        urlkey = "url",
        currentKey = "current",
        currentNodeId,
        buildDataStructure = function(sNodes) {
            var i, l,NodeId;
            if (sNodes.length == 0)
                return sNodes;
            for (i = 0, l = sNodes.length; i < l; i++) {
                NodeId=sNodes[i][key];
                tmpMap[NodeId] = sNodes[i];
                urlMapping[sNodes[i][urlkey]] = NodeId;
            }
            for (i = 0, l = sNodes.length; i < l; i++) {
                if (tmpMap[sNodes[i][parentKey]]&& sNodes[i][key] != sNodes[i][parentKey]) {
                    if (!tmpMap[sNodes[i][parentKey]][childKey]){
                        tmpMap[sNodes[i][parentKey]][childKey] = [];
                    }
                    tmpMap[sNodes[i][parentKey]][childKey].push(sNodes[i]);
                } else {
                    root.push(sNodes[i]);// 根节点
                }
            }
            currentNodeId= getCurrentNodeId();
            setCurrentOpenPath(currentNodeId);
            setOpenPath(currentNodeId);//设置默认展开节点

            return root;
        },buildTreeHtml = function(node, level,isBuildOneLevel) {
            var childrenNode, currentNode, isActiveCss, childrenHtml = [], html = [];
            for (var i = 0; i < node.length; i++) {
                currentNode = node[i];
                childrenNode = currentNode[childKey];
                if (childrenNode || level == 1) {
                    //if (childrenNode) {
                    buildParentTreeHtml(currentNode,childrenNode,html,childrenHtml,level,isBuildOneLevel);
                } else {// 叶子节点
                    buildSubTreeHtml(currentNode,html,level);
                }
            }
            return html;
        },buildParentTreeHtml=function(currentNode,childrenNode,html,childrenHtml,level,isBuildOneLevel){
            html.push("<li id='",currentNode[key], "' class='parent level",level," ",setActiveCss(currentNode),"' level='",level,"'>", "<a><em>",setIcon(level, currentNode),"</em><span>",currentNode.name,"</span><i class='arrow'></i>","</a>");
            if(!isBuildOneLevel&&currentNode[openKey]){
                childrenHtml = buildTreeHtml(childrenNode, level+1,isBuildOneLevel);
                html.push("<ul>", childrenHtml.join(''), "</ul></li>");
            }else{
                html.push("</li>");
            }
        },buildSubTreeHtml=function(currentNode,html,level){
            html.push("<li id='",currentNode[key],"' level='",level,"' class='",setCurrentCss(currentNode), " " ,setActiveCss(currentNode),"'><a title='"+currentNode["name"]+"' href='",currentNode["url"],"' ",getOpenType(currentNode["new"]),">","<span>", currentNode["name"],"</span>","</a></li>");
        },bindEvent = function(object) {
            object.find('a').live('click', function(e) {
                var _this = $(this),
                    curentNode = _this.parent();
                if (curentNode.hasClass("active")) {
                    curentNode.parent().find(".active").removeClass("active").find('>ul').slideUp(200);
                    return;
                }
                curentNode.parent().find(".active").removeClass("active").find('>ul').slideUp(200);
                if(curentNode.hasClass("parent")&&curentNode.find('>ul').length==0){
                    var html= buildTreeHtml(tmpMap[curentNode.attr('id')][childKey],parseInt(curentNode.attr('level'))+1,true).join('');
                    curentNode.append("<ul style='display:none'>"+html+"</ul>");
                }
                curentNode.addClass("active").find('>ul').slideDown(200, sideBarHeight);
                if(!curentNode.hasClass("level1")){
                    object.find('a').removeClass('sel');
                    _this.addClass('sel');
                }
            });
        },getCurrentNodeId= function(){
            //用于订单门户系统非menu页面的子页面的菜单定位问题 只局限.action的后缀
            var path = pathName.substring(pathName.length-7,pathName.length);
            if(path == '.action'){
                pathName = document.referrer;
                pathName = pathName.replace(origin,'');
            }

            if(typeof (pageNode)=='string'){
                if(pageNode.indexOf(',')>0||pageNode=="null"){
                    return urlMapping[origin+pathName];
                } else {
                    return pageNode;
                }
            }else {
                if(pageNode==null){
                    return urlMapping[origin+pathName];
                }else {
                    return pageNode.parent;
                }
            }
        },setOpenPath = function(nodeId) {// 设置展开节点
            var node = tmpMap[nodeId];
            if (node) {
                var parentNodeId=node[parentKey];
                node[openKey] = true;
                node[activeKey]=true;
                if (tmpMap[parentNodeId]) {
                    setOpenPath(parentNodeId);
                }
            } else {
                root[0][openKey] = true;
                root[0][activeKey] = true;
            }
        },setCurrentOpenPath = function(nodeId) {// 设置当前展开节点
            var node = tmpMap[nodeId];
            if (node) {
                node[currentKey] = true;
            }
        },setActiveCss=function(node){//判断是否选中
            if(node[activeKey]){
                return activeKey;
            }

        },setCurrentCss=function(node){//判断是否选中
            if(node[currentKey]){
                return currentKey;
            }

        },setIcon = function(level, currentNode) {//设置菜单图标
            if (level == 1) {
                return "<i class='"+ getIconClass(currentNode.name)+ "'></i>";
            }
            return "";
        }, getIconClass = function(menuName) {
            if (nodeIconClasses[menuName]) {
                return "icon "+nodeIconClasses[menuName];
            }
            return "icon "+nodeIconClasses["收藏夹"];
        }, getOpenType=function(flag){
            return flag=="1" ? "target='_blank'":"";
        },initMenu = function() {
            if(menuNodes==undefined||menuNodes==null){
                menuNodes=[];
            }
            if(wihteMenu!=undefined&&wihteMenu!=null){//拼接白名单
                var length=wihteMenu.length;
                for (var i=0; i < length; i++) {
                    menuNodes.push(wihteMenu[i]);
                }
            }
            var dataStructure = buildDataStructure(menuNodes);
            menuHtml = buildTreeHtml(dataStructure, 1,false).join('');
        };
    initMenu();
    $.fn.snMenu = function() {
        this.append(menuHtml);
        bindEvent(this);
        sideBarHeight();
    };
    $.fn.getCurrentNodeId=function(){
        return currentNodeId;
    };
})(jQuery);