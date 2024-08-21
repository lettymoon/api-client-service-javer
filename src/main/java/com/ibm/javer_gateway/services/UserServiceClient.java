package com.ibm.javer_gateway.services;

import com.ibm.javer_gateway.dtos.ResponseDTO;
import com.ibm.javer_gateway.dtos.UserAllDataResponseDTO;
import com.ibm.javer_gateway.dtos.UserRequestDTO;
import com.ibm.javer_gateway.dtos.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "banco-javer-crud", url = "http://localhost:8081/api")
public interface UserServiceClient {
    @GetMapping
    ResponseEntity<ResponseDTO<List<UserResponseDTO>>> getAllUsers();

    @PostMapping
    ResponseEntity<ResponseDTO<UserAllDataResponseDTO>> createUser(@RequestBody UserRequestDTO data);

    @GetMapping("/{id}")
    ResponseEntity<ResponseDTO<UserAllDataResponseDTO>> getUserById(@PathVariable("id") String id);

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseDTO<UserAllDataResponseDTO>> deleteUser(@PathVariable("id") String id);

    @PutMapping
    ResponseEntity<ResponseDTO<UserAllDataResponseDTO>> updateUser(@RequestBody UserRequestDTO data);

    @PatchMapping("/{cpf}/score-credito")
    ResponseEntity<ResponseDTO<Double>> updateScore(@PathVariable("cpf") String cpf);
}


