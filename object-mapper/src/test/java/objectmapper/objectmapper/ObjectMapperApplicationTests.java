package objectmapper.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {
//오브젝트 메퍼란? text형태인 json을 object로
//    object를 text형태인 json으로 바꿔준다.


    @Test
    void contextLoads() {
        System.out.println("-------");
        // Text Json -> Object
        // Object -> Text Json

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();
        // object -> text
        // object mapper get method를 활용한다.

        var user = new User("steve",10,"010-1111-2222"); // User 클래스 무엇으로
        // 변환할 때 예외가 발생할 수 있기 때문에 alt enter로 첫번째 출력 뭔소리지?
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        //text -> object
        var objectUser = objectMapper.readValue(text,User.class);
        System.out.println(objectUser);

    }

}
