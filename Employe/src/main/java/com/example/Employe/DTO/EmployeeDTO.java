package com.example.Employe.DTO;

import javax.validation.constraints.*;

public class EmployeeDTO {
    @NotNull(message = "ID is required")
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name cannot be longer than 50 characters")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age cannot be more than 60")
    private Integer age;

    public EmployeeDTO() {

    }


    public EmployeeDTO(Long id, String name, Integer age, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public EmployeeDTO(String name, Integer age, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
    }

    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
