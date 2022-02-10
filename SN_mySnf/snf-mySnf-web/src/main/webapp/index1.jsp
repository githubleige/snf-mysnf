<%@ page  contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="gomst/js/jquery-1.8.2.min.js"> </script>
    <script type="text/javascript" src="gomst/js/json2.js"> </script>
    <script type="text/javascript">
        $(document).ready(function(){
            testRequestBody();
        });
        function testRequestBody() {
            $.ajax("${pageContext.request.contextPath}/json/testRequestBody",
                {
                datatype:"json",

                type : "post",

                contentType:"application/json",

                // url : "/gomso-web/dataArchiving/queryDataArchiving.htm",

                data : JSON.stringify({id:1,name:"suanfa"}),

                async : true,

                success : function(Data) {
                    alert(Data);
                    var json1=$.parseJSON( Data );
                    console.log(Data);
                    $("#id").html(json1.id);
                    $("#name").html(json1.name);
                    $("#author").html(json1.author);
                },
                    error:  function(){
                    alert("数据发送失败")
                    }

            });
        }
    </script>
</head>
<body>
编号：<span id="id"></span><br>
书名：<span id="name"></span><br>
作者：<span id="author"></span><br>
</body>
</html>
