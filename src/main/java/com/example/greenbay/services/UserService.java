package com.example.greenbay.services;

import com.example.greenbay.models.User;
import java.util.Optional;

public interface UserService {

  Optional<User> findByUsername(String username);
}
