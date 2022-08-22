package dev.be.moduleapi.service;

import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repositories.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor  // 모듈쪽에 있는 bean을 주입받기 위해서 코드 수정
public class DemoService {

    private final CommonDemoService commonDemoService; // 코드 수정   bean주입이 되었다. 라고 생각

    private final MemberRepository memberRepository;

    public String save(){
        memberRepository.save(Member.builder()
                                    .name(Thread.currentThread().getName())
                                    .build());
//        System.out.println(CodeEnum.SUCCESS.getCode());
//        System.out.println(commonDemoService.commonService());  // 똑같이 출력
        return "save";
    }

    public String find(){
        int size = memberRepository.findAll().size();
        System.out.println("DB size : " + size);
        System.out.println(CodeEnum.UNKNOWN_ERROR.getCode());
     return "find";
    }

    public String exception(){
        if(true){
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);

        }
        return "exception";
    }
}
