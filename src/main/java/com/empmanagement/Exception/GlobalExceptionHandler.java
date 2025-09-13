package com.empmanagement.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeFoundException.class)
    public ResponseEntity<?>  EmployeeFoundExceptionHandler(EmployeeFoundException ex){

        Map<String ,String > map = new HashMap<>();

        map.put("errorcode","5240");
        map.put("errormessage", ex.getMessage());

        return new ResponseEntity<Map<String ,String >>(map, HttpStatus.FOUND);

    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> EmployeeNotFoundException(EmployeeNotFoundException ex)
    {
        ErrorMapper errorMapper = new ErrorMapper();
        errorMapper.setErrorcode(404);
        errorMapper.setErrormessage(ex.getMessage());
        errorMapper.setDeveloper("Aishwarya");

        return new ResponseEntity<ErrorMapper>(errorMapper, HttpStatus.NOT_FOUND);



//        String message= ex.getMessage();
//
//        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);


    }


}
