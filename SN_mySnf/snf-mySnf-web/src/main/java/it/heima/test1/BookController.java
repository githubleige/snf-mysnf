package it.heima.test1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suning.framework.dal.client.DalClient;
import it.heima.it.heima.bean.DeductFeeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.*;


//@Controller
@RequestMapping("/json")
public class BookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private DalClient dalClient;

    @RequestMapping(value="/testRequestBody")
    public void setJson(@RequestBody Book book, HttpServletResponse response) throws Exception{
        Context ctx=new InitialContext();
        DataSource tJnadi=(DataSource)ctx.lookup("java:comp/env/jdbc/TestDB");
        Connection con=tJnadi.getConnection();
        if (con!=null){
            System.out.println("MySQL Connection pool connected !!");
        }
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("name","NEW_OMS_ORDERID_SEQ");
//        Long test=dalClient.execute4PrimaryKey("sequence.get_sys_sequence",paramMap).longValue();
//        System.out.println(test);
        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(book));
        book.setAuthor("gelei");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(mapper.writeValueAsString(book));
    }

    @RequestMapping(value="/testRequestBody2")
    public void setJson2(@RequestBody Book book, HttpServletResponse response) throws Exception{
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("deductType", "00");
        List<DeductFeeBean> orderProcessList = dalClient.queryForList("sequence.query_deductFee_info", paramMap,
                DeductFeeBean.class);
        System.out.println(orderProcessList);
        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(book));
        book.setAuthor("gelei");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(mapper.writeValueAsString(orderProcessList.get(0)));
    }
}
