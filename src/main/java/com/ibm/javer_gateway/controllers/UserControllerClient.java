package com.ibm.javer_gateway.controllers;

import com.ibm.javer_gateway.dtos.ResponseDTO;
import com.ibm.javer_gateway.dtos.UserAllDataResponseDTO;
import com.ibm.javer_gateway.dtos.UserRequestDTO;
import com.ibm.javer_gateway.dtos.UserResponseDTO;
import com.ibm.javer_gateway.services.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserControllerClient {
    @Autowired
    private UserServiceClient userServiceClient;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<UserResponseDTO>>> getAllUsers(){
        return userServiceClient.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<UserAllDataResponseDTO>> createUser(@RequestBody UserRequestDTO data){
        return userServiceClient.createUser(data);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<UserAllDataResponseDTO>> getUserById(@PathVariable String id){
        return userServiceClient.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<UserAllDataResponseDTO>> deleteUser(@PathVariable String id){
        return userServiceClient.deleteUser(id);
    }

    @PutMapping
    public ResponseEntity<ResponseDTO<UserAllDataResponseDTO>> updateUser(@RequestBody UserRequestDTO data){
        return userServiceClient.updateUser(data);
    }

    @PatchMapping("/{cpf}/score-credito")
    public ResponseEntity<ResponseDTO<Double>> updateScore(@PathVariable String cpf){
        return userServiceClient.updateScore(cpf);
    }
}

