package br.com.rodrigobraz.TestApi.config;

import br.com.rodrigobraz.TestApi.domain.User;
import br.com.rodrigobraz.TestApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class TestConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void startDB() {

        User u1 = new User(null, "Rodrigo", "rodrigo@email.com", "123");
        User u2 = new User(null, "Joao", "joao@email.com", "123");
        User u3 = new User(null, "Marcos", "marcos@email.com", "123");
        User u4 = new User(null, "Maria", "maria@email.com", "123");
        User u5 = new User(null, "Pedro", "pedro@email.com", "123");
        User u6 = new User(null, "Mateus", "mateus@email.com", "123");

        userRepository.saveAll(List.of(u1, u2, u3, u4, u5, u6));

    }

}
