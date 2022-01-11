package objectmapper.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException{
        System.out.println("-------");
        // Text Json -> Object
        // Object -> Text Json

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper(); // (1) ObjectMapper생성
        // object -> text
        // object mapper get method를 활용한다.

        var user = new User("steve",10); //(3) 실습을 위한 Object 생성

        var text = objectMapper.writeValueAsString(user); // (4) writeValueAsString메소드 이용,예외처리하기
        System.out.println(text);

        //text -> object
//        var objectUser = objectMapper.readValue(text,User.class);
//        System.out.println(objectUser);

    }

}
