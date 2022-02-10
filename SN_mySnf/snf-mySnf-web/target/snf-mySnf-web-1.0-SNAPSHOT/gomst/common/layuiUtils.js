/**
 * 关闭窗口
 */
function closeLayerFrame() {
	//获取窗口索引
    var index = parent.layer.getFrameIndex(window.name);
    //关闭弹出的子页面窗口
    parent.layer.close(index);
}

/**
 * 时间格式化处理
 * @param fmt 日期格式
 * @param dateLong 时间戳
 * @returns {*}
 */
function dateFtt(fmt,dateLong){ //author: meizz
    if (null == dateLong || "" == dateLong){
        return "";
    }
    var date = new Date(dateLong);
    var o = {
        "M+" : date.getMonth()+1,     //月份
        "d+" : date.getDate(),     //日
        "h+" : date.getHours(),     //小时
        "m+" : date.getMinutes(),     //分
        "s+" : date.getSeconds(),     //秒
        "q+" : Math.floor((date.getMonth()+3)/3), //季度
        "S" : date.getMilliseconds()    //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}

/**
 * 比较相等
 * @param str1
 * @param str2
 * @returns {*}
 */
function getDiffEqualsContent(str1,str2){
    if("" == str2 || null == str2){
        return "";
    }

    if("" == str1 || null == str1){
        return str2;
    }

    //内容根据逗号拆分排序再比较
    str1 = spiltSortContent(str1);
    str2 = spiltSortContent(str2);

    if(str1 == str2){
        return str2;
    }else {
        return '<span style="color:red;">' + str2 + '</span>';
    }
}

/**
 * 若是带逗号的数据，拆分重新排序
 * @param str
 * @returns {*}
 */
function spiltSortContent(str) {
    if (str.indexOf(",") != -1) {
        var array = str.split(",");
        array.sort();
        return array.join(",");
    } else {
        return str;
    }
}


/**
 *
 * @param original
 * @param changed
 * @returns {*}
 */
function getDiffHtml(original,changed){
    if("" == changed || null == changed){
        return "";
    }

    if("" == original || null == original){
        return changed;
    }

    if(original == changed){
        return changed;
    }

    var dmp=new diff_match_patch();
    var  diffs = dmp.diff_main(original, changed);
    var diff_as_html = $.map(diffs, function(diff) {
        return $.fn.prettyTextDiff.createHTML(diff);
    });
    return diff_as_html.join('');
}

/**
 * 组合节点带版本号比较
 * @param original
 * @param changed
 * @returns {*}
 */
function getCndDiffEqualsContent(original,changed){
    if("" == changed || null == changed){
        return "";
    }

    if("" == original || null == original){
        return changed;
    }

    if(original == changed){
        return changed;
    }

    var k = changed.lastIndexOf("-");
    var ensStr = changed.substr(k+1);

    var startStr = getDiffEqualsContent(cutStr(original),changed.substr(0,k));

    return startStr+"-"+ensStr;
};

/**
 * 数据截取
 * @param str
 * @returns {string}
 */
function cutStr(str) {
    var k = str.lastIndexOf("-");
    return str.substr(0,k);
}