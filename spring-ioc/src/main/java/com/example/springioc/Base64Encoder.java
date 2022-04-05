package com.example.springioc;



import org.springframework.stereotype.Component;

import java.util.Base64;

// base64 인코더 사이에 객체로 관리되어야 하기 때문에
// spring에게 요청하는 방법 ioc 컨테이너의 관리를 받게

@Component("base74Encoder")
public class Base64Encoder implements IEncoder {
    public String encode(String message){

        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}

