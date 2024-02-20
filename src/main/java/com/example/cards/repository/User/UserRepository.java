package com.example.cards.repository.User;

import com.example.cards.modle.User.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
    UserModel findByEmail(String email);
    UserModel findByUsername(String username);
}