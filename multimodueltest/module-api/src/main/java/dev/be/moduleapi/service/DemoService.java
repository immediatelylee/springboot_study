package dev.be.moduleapi.service;

import dev.be.modulecommon.enums.CodeEnum;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String save(){
        System.out.println(CodeEnum.SUCESS.getCode());
        return "save";
    }

    public String find(){
        System.out.println(CodeEnum.UNKNOWN_ERROR.getCode());
     return "find";
    }
}
