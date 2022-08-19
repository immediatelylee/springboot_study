package dev.be.moduleapi.contorller;

import dev.be.moduleapi.service.DemoTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoTestController {

    private final DemoTestService demoTestService;

    @GetMapping("/save")
    public String save(){
        return demoTestService.save();
    }

    @GetMapping("/find")
    public String find(){
        return demoTestService.find();
    }
}
