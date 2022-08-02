package com.example.greenbay.controllers;

import com.example.greenbay.dtos.AuthenticationRequestDTO;
import com.example.greenbay.dtos.AuthenticationResponseDTO;
import com.example.greenbay.services.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

  private final AccessService accessService;

  @Autowired
  public AccessController(AccessService accessService) {
    this.accessService = accessService;
  }

  @PostMapping("/user/login")
  public ResponseEntity<AuthenticationResponseDTO> loginUser(@RequestBody AuthenticationRequestDTO requestDTO) {
    accessService.authenticateUser(requestDTO);
    return ResponseEntity.ok().body(new AuthenticationResponseDTO(accessService.generateJwtToken(requestDTO)));
  }
}
