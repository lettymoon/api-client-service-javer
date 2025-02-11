package com.ibm.javer_gateway.exceptions;

import com.ibm.javer_gateway.dtos.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestControllerAdvice
public class RestExceptionHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<Object>> handleException(Exception ex) {
        String message = "Erro interno no servidor";
        Object data = null;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        String errorMessage = ex.getMessage();

        if (errorMessage != null && errorMessage.contains("message")) {
            try {
                JsonNode errorJson = objectMapper.readTree(errorMessage.substring(errorMessage.indexOf("[{"), errorMessage.lastIndexOf("}]") + 2));
                message = errorJson.get(0).get("message").asText();
                data = errorJson.get(0).get("data").isNull() ? null : errorJson.get(0).get("data");

                if (errorJson.get(0).has("statusCode")) {
                    int statusCode = errorJson.get(0).get("statusCode").asInt();
                    status = HttpStatus.resolve(statusCode);
                    if (status == null) {
                        status = HttpStatus.INTERNAL_SERVER_ERROR;
                    }
                }
            } catch (Exception e) {
                message = "Erro ao processar a resposta do servidor";
            }
        }

        return ResponseEntity.status(status).body(new ResponseDTO<>(message, data));
    }
}
