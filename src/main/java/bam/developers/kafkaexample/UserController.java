package bam.developers.kafkaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserController {
    private static final String TOPIC = "KafkaExample";
//    @Autowired
//    private KafkaTemplate<String, String> stringKafkaTemplate;
    @Autowired
    private KafkaTemplate<String, User> userKafkaTemplate;
/*
    @GetMapping(path = "/publish/{message}")
    public String publishMessage(@PathVariable(value = "message") String message) {
        stringKafkaTemplate.send(TOPIC, message);
        return "Published Successfully";
    }
*/
    @GetMapping(path = "/publish/user/{id}/{name}/{salary}")
    public String publishUser(@PathVariable(value = "id") String id,
                              @PathVariable(value = "name") String name,
                              @PathVariable(value = "salary") Double salary) {
        userKafkaTemplate.send(TOPIC, new User(id,name,salary));
        return "Published Successfully";
    }
}
