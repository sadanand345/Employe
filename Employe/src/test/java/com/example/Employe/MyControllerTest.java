package com.example.Employe;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.example.Employe.DTO.EmployeeDTO;
import com.example.Employe.controller.ExampleController;
import com.example.Employe.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class MyControllerTest {
    @Mock
    private EmployeeService myService;

    @InjectMocks
    private ExampleController myController;

    private MockMvc mockMvc;

    @Test
    public void testEndpoint() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
       // employeeDTO.setId(111L);
        employeeDTO.setName("Naruto");
        employeeDTO.setAge(27);
        employeeDTO.setRole("Hokage");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(employeeDTO);

        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());

    }
}
