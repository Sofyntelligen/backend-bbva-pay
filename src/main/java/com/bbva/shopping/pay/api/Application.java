package com.bbva.shopping.pay.api;

import com.bbva.shopping.pay.api.model.entity.UserAccess;
import com.bbva.shopping.pay.api.repositories.UserAccessRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Autowired
    private UserAccessRepository userAccessRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            this.userAccessRepository.save(new UserAccess("Omar", "87654321"));
            this.userAccessRepository.save(new UserAccess("Daniel", "asdfghjk"));
            this.userAccessRepository.save(new UserAccess("Gabriela", "19283746"));
            this.userAccessRepository.save(new UserAccess("Humberto", "aksjdhfg"));
            this.userAccessRepository.save(new UserAccess("Pablo", "wsxedcrf"));
        };
    }
    
}
