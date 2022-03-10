package br.com.rodrigobraz.TestApi.services.impl;

import br.com.rodrigobraz.TestApi.domain.User;
import br.com.rodrigobraz.TestApi.repositories.UserRepository;
import br.com.rodrigobraz.TestApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {

        User possibleUser = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Object not found!"));
        return possibleUser;
    }
}
