package br.com.rodrigobraz.TestApi.services.impl;

import br.com.rodrigobraz.TestApi.domain.User;
import br.com.rodrigobraz.TestApi.domain.dto.UserDTO;
import br.com.rodrigobraz.TestApi.repositories.UserRepository;
import br.com.rodrigobraz.TestApi.services.UserService;
import br.com.rodrigobraz.TestApi.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {

        Optional<User> possibleUser = repository.findById(id);
        return possibleUser.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO dto) {
        return repository.save(mapper.map(dto, User.class));
    }
}
