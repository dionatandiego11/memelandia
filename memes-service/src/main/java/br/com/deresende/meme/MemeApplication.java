package br.com.deresende.meme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MemeApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemeApplication.class, args);
    }
}