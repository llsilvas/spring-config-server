package br.dev.leandro.spring.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(exclude = RabbitAutoConfiguration.class)
class SpringConfigServerApplicationTests {

    @Test
    void contextLoads() {
    }

}
