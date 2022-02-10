package it.heima.socketProgram;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;

public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        InetAddress ip=InetAddress.getByName("www.baidu.com");
        System.out.println("www.baidu.com是否可达："+ip.isReachable(2000));
        System.out.println(ip.getHostAddress());

        InetAddress local=InetAddress.getByAddress(new byte[]{(byte)192,(byte)168,0,105});
        System.out.println("本机是否可达："+local.isReachable(2000));
        System.out.println(local.getCanonicalHostName());

//        byte a=(byte)192;
//        int b=a;
//        System.out.println(a);
//        System.out.println(b);
//        //注意(byte)192如果打印出来会是个负数（原因就是：-64的补码和192转换成原码的二进制占8位，是相同的，都是：
//        // 1100 0000），byte类型占用一个一个字节（8个比特位）
//        byte[] c=new byte[]{(byte)192,(byte)168,0,105};
//        Byte[] D=new Byte[]{1,2};
//        for(Byte E: c){
//            System.out.println(E);
//        }
    }
}
