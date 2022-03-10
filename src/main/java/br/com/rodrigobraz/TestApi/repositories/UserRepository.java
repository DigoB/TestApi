package br.com.rodrigobraz.TestApi.repositories;

import br.com.rodrigobraz.TestApi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
