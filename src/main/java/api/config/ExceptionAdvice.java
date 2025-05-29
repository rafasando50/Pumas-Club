package api.config;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import api.dto.ErrorDTO;

@RestControllerAdvice
public class ExceptionAdvice {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validationErrors() {
        return new ErrorDTO("ERR_VALID","Hubo un error al validar los datos de entrada" , null);
    }

    
}
