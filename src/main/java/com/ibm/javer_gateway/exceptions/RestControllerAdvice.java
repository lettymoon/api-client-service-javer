package ibm.javer.javer.exceptions;

import ibm.javer.javer.dtos.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<T>> handleException(Exception ex) {
        // TODO: Obter a message
        String message;
        // TODO: Obter o data (que eu nao sei o tipo)
        T data;
        // TODO: Obter o status da request
        HttpStatus status;
        return ResponseEntity.status(status).body(new ResponseDTO<>(message, data));
    }
    
}