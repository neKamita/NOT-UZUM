package uz.pdp.notuzum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = "uz.pdp.notuzum")
public class NotUzumApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotUzumApplication.class, args);
    }

}