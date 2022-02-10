<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.suning.framework.dal.client.DalClient" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    hello wolrd
    <%--test jndi<br/>
    <%
        Context ctx=new InitialContext();
        String tJnadi=(String)ctx.lookup("java:comp/env/tjndi");
    %>
    tjndi=<%=tJnadi%>--%>

    <%
//        Context ctx=new InitialContext();
//        DataSource tJnadi=(DataSource)ctx.lookup("java:comp/env/jdbc/TestDB");
//        Connection con=tJnadi.getConnection();
//        if (con!=null){
//            out.println("MySQL Connection pool connected !!");
//        }

//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/conf/spring/spring-dal-shard.xml");
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("name","NEW_OMS_ORDERID_SEQ");
//        DalClient dalClient = context.getBean("dalClient",DalClient.class);
//        Long test=dalClient.execute4PrimaryKey("sequence.get_sys_sequence",paramMap).longValue();
//        out.println(test);
    %>
</body>
</html>
