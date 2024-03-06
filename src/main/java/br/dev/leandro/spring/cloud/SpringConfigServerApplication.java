package br.dev.leandro.spring.cloud;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.util.Date;
import java.util.TimeZone;

@Log
@EnableConfigServer
@SpringBootApplication
public class SpringConfigServerApplication {

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC-3"));
    }

    public static void main(String[] args) {
        log.info(":: Iniciando Spring-Config-Server ::");
        SpringApplication.run(SpringConfigServerApplication.class, args);
        log.info(":: Spring-Config-Server iniciado com sucesso ::" + new Date());
    }

}
