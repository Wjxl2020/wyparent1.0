package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.App;
import com.neuedu.pojo.MailVo;
import com.neuedu.util.JwtUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class MyTest {
    public static void main(String[] args) {
        System.out.println(RandomStringUtils.random(8,true,true));
    }
    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    RabbitTemplate rabbitTemplate;
    @Resource
    ObjectMapper objectMapper;
    @Test
    public void handler() throws JsonProcessingException, UnsupportedEncodingException {
        rabbitTemplate.convertAndSend("testqueue","222222222222222222222222");
        System.out.println("发送完成");
    }
}
