package com.example.Employe.service;

import com.example.Employe.DTO.EmployeeDTO;
import com.example.Employe.customException.InternalServerErrorException;
import com.example.Employe.entity.Employee;
import com.example.Employe.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee>  allEmployees =employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS =  allEmployees.stream().map(emp ->this.convertEntityTODTO(emp)).collect(Collectors.toList());
        return employeeDTOS;
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) throws InternalServerErrorException {
        try {
            Employee employee = convertDTOToEntity(employeeDTO);
            Employee savedEmployee = employeeRepository.save(employee);
            return convertEntityTODTO(savedEmployee);
        } catch (Exception ex) {
            throw new InternalServerErrorException("Error while creating employee");
        }
    }

    private Employee convertDTOToEntity(EmployeeDTO employeeDTO)
    {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setAge(employeeDTO.getAge());
        employee.setRole(employeeDTO.getRole());
        employee.setName(employeeDTO.getName());
        return  employee;

    }

    private  EmployeeDTO convertEntityTODTO(Employee employee)
    {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setAge(employee.getAge());
        employeeDTO.setRole(employee.getRole());
        employeeDTO.setName(employee.getName());
        return  employeeDTO;

    }

}
