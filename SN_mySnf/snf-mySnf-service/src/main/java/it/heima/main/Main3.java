package it.heima.main;

import com.suning.framework.dal.client.DalClient;
import it.heima.it.heima.bean.DeductFeeBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/conf/spring/spring-dal-shard.xml");

        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("shardId", "sequence");
//        paramMap.put("deductType", "79");
        paramMap.put("omsCategoryID","00");
       DalClient dalClient = context.getBean("shardingDalClient",DalClient.class);
//        Long test=dalClient.execute4PrimaryKey("sequence.get_sys_sequence",paramMap).longValue();
//        System.out.println(test);
        List<DeductFeeBean> orderProcessList = dalClient.queryForList("sequence.query_deductFee_info", paramMap,
                DeductFeeBean.class);
//        DeductFeeBean a=dalClient.queryForObject("sequence.query_deductFee_info", paramMap, DeductFeeBean.class);
        System.out.println(orderProcessList.size());
//        for(DeductFeeBean e : orderProcessList){
//            System.out.println(e);
//        }

        System.out.println(orderProcessList.get(0));
//        System.out.println(a);
    }
}
