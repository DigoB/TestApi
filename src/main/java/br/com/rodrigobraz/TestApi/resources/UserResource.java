package br.com.rodrigobraz.TestApi.resources;

import br.com.rodrigobraz.TestApi.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {


        return ResponseEntity.ok().body(new User(1, "Rodrigo", "email@email.com.br", "123"));
    }
}
