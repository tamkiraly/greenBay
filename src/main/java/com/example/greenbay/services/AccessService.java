package com.example.greenbay.services;

import com.example.greenbay.dtos.AuthenticationRequestDTO;

public interface AccessService {

  boolean authenticateUser(AuthenticationRequestDTO requestDTO);

  String generateJwtToken(AuthenticationRequestDTO requestDTO);
}
