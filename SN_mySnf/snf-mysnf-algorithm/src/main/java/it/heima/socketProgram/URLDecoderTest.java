package it.heima.socketProgram;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String urlStr= URLEncoder.encode("我是戈磊","utf-8");
        System.out.println(urlStr);
        urlStr=URLDecoder.decode(urlStr,"utf-8");
        System.out.println(urlStr);
    }
}
