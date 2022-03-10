package br.com.rodrigobraz.TestApi.services;

import br.com.rodrigobraz.TestApi.domain.User;

public interface UserService {

    User findById(Integer id);
}
