package com.bluewhitecat.servlet;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DownloadServletTest {

    @Test
    public void test1() {
        String content = "这是需要进行base64编码的内容";
        byte[] encode = Base64.getEncoder().encode(content.getBytes(StandardCharsets.UTF_8));
        byte[] decode = Base64.getDecoder().decode(encode);
        System.out.println(encode.toString());
        System.out.println(decode.toString());
    }

}