package com.ibm.javer_gateway.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public record ResponseDTO<L>(String message, L data) {
}
