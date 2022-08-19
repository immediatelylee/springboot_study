package dev.be.modulecommon.service;

import org.springframework.stereotype.Service;

// bean 을통하여 모듈간 참조가 되는지 확인하기 위한 간단한 bean생성
@Service
public class CommonDemoService {

    public String commonService(){
        return "commonService";
    }
}
