package it.heima.main;

import com.suning.framework.dal.client.DalClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/conf/spring/spring-dal-shard.xml");

//        Map<String, Object> paramMap = new HashMap<>();
////        paramMap.put("shardId", "sequence");
//        paramMap.put("name","NEW_OMS_ORDERID_SEQ");
//        DalClient dalClient = context.getBean("dalClient1",DalClient.class);
//        Long test=dalClient.execute4PrimaryKey("sequence.get_sys_sequence",paramMap).longValue();
//        System.out.println(test);
//        System.exit(0);
        Object e=context.getBean("main5");
        System.out.println(e.getClass());
        util1.sout();
        while(true){
            System.out.println("he");
        }
    }
}
