 package com.example.Employe.controller;

 import com.example.Employe.DTO.EmployeeDTO;
 import com.example.Employe.customException.InternalServerErrorException;
 import com.example.Employe.service.EmployeeService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.validation.BindingResult;
 import org.springframework.validation.FieldError;
 import org.springframework.web.bind.MethodArgumentNotValidException;
 import org.springframework.web.bind.annotation.*;

 import javax.validation.Valid;
 import java.util.List;

 @RestController
 @RequestMapping("/api")
 public class ExampleController {
     @Autowired
     EmployeeService employeeService;

     @GetMapping("/hello")
     public String hello() {

         // test
         return "Hello, World!";
     }

     @GetMapping("/get-employees")
     public List<EmployeeDTO> getAllEmployees() {

         return employeeService.getAllEmployees();
     }

     @PostMapping("/employees")
     public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws InternalServerErrorException {
         EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO);
         return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
     }

     @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
         BindingResult bindingResult = ex.getBindingResult();
         StringBuilder sb = new StringBuilder();

         for (FieldError fieldError : bindingResult.getFieldErrors()) {
             sb.append(fieldError.getField())
                     .append(": ")
                     .append(fieldError.getDefaultMessage())
                     .append("\n");
         }

         return ResponseEntity.badRequest().body(sb.toString());
     }

 }

