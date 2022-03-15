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
    private UserRepository repository;

    @Bean
    public void startDB() {
        User u1 = new User(null, "Rodrigo", "rodrigo@email.com", "123");
        User u2 = new User(null, "Pedro", "pedro@mail.com", "123");

        repository.saveAll(List.of(u1, u2));
    }
}
