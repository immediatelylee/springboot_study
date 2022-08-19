package dev.be.moduleapi.service;

import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor  // 모듈쪽에 있는 bean을 주입받기 위해서 코드 수정
public class DemoService {

    private final CommonDemoService commonDemoService; // 코드 수정   bean주입이 되었다. 라고 생각

    public String save(){
        System.out.println(CodeEnum.SUCESS.getCode());
        System.out.println(commonDemoService.commonService());  // 똑같이 출력
        return "save";
    }

    public String find(){
        System.out.println(CodeEnum.UNKNOWN_ERROR.getCode());
     return "find";
    }
}
