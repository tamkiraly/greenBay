package com.example.greenbay.services;

import com.example.greenbay.dtos.AuthenticationRequestDTO;
import com.example.greenbay.dtos.AuthenticationResponseDTO;
import com.example.greenbay.exceptions.InvalidPasswordException;
import com.example.greenbay.exceptions.InvalidUsernameException;
import com.example.greenbay.exceptions.UsernameOrPasswordInvalidException;
import com.example.greenbay.models.User;
import com.example.greenbay.security.JwtUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccessServiceImpl implements AccessService {

  private final UserService userService;
  private final PasswordEncoder encoder = new BCryptPasswordEncoder();
  private final JwtUtil jwtUtil;
  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;

  @Autowired
  public AccessServiceImpl(UserService userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager,
      UserDetailsService userDetailsService) {
    this.userService = userService;
    this.userDetailsService = userDetailsService;
    this.jwtUtil = jwtUtil;
    this.authenticationManager = authenticationManager;
  }

  @Override
  public boolean authenticateUser(AuthenticationRequestDTO requestDTO) {
    String username = requestDTO.getUsername();
    String password = requestDTO.getPassword();

    if (username == null || username.isBlank() || username.isEmpty()) {
      throw new InvalidUsernameException("Please provide a username");
    } else if (password == null || password.isBlank() || password.isEmpty()) {
      throw new InvalidPasswordException("Please provide a password");
    } else if (!checkUsernameAndPassword(requestDTO)) {
      throw new UsernameOrPasswordInvalidException("Invalid username or password");
    } else {
      return true;
    }
  }

  private boolean checkUsernameAndPassword(AuthenticationRequestDTO requestDTO) {
    Optional<User> user = userService.findByUsername(requestDTO.getUsername());
    if (user.isPresent()) {
      String storedPassword = user.get().getPassword();
      return encoder.matches(requestDTO.getPassword(), storedPassword);
    } else {
      return false;
    }
  }

  @Override
  public String generateJwtToken(AuthenticationRequestDTO requestDTO) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(requestDTO.getUsername(), requestDTO.getPassword()));
    final UserDetails userDetails = userDetailsService.loadUserByUsername(requestDTO.getUsername());
    return jwtUtil.generateToken(userDetails);
  }
}
