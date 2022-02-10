package it.heima.socketProgram;

public class test1 {
    public static void main(String[] args) {
        byte a=(byte)192;
        System.out.println(a);
        //a & 0xff运算后会自动升级为int类型
//        byte b=a & 0xff;
        System.out.println(a & 0xff);

        byte c=(byte)( a & 0xff);
        System.out.println(c);

        int aa=448;
        System.out.println(aa&0xff);
    }
}
