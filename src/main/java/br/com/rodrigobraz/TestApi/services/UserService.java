package br.com.rodrigobraz.TestApi.services;

import br.com.rodrigobraz.TestApi.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();
}
