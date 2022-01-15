package com.company;

import java.util.Base64;

public class Encoder {
    // 감추기 시작
    private IEncoder iEncoder;


    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }


    public String encode(String message){
        return iEncoder.encode(message);
    }
}
