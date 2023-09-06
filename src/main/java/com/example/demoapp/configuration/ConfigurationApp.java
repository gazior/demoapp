package com.example.demoapp.configuration;

import com.example.demoapp.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationApp {

    private final UserRepository userRepository;

    public ConfigurationApp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    void addNewUser(){
//        userRepository.save(new CustomUser(1L,"Mateusz","{bcrypt}$2a$10$h/AJueu7Xt9yh3qYuAXtk.WZJ544Uc2kdOKlHu2qQzCh/A3rq46qm",true,true,true,true,null));
//    }


}
