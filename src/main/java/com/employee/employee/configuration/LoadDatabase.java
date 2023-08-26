package com.employee.employee.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.employee.employee.models.Employee;
import com.employee.employee.repositories.EmployeeRepository;

@Configuration
public class LoadDatabase {

    @Bean
    public CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee("Rui", "01/01/1900", "Software Engineer", "Columbus"));
            repository.save(new Employee("Denise", "01/01/2000", "Software Engineer II", "Wilmington"));
            repository.save(new Employee("Camme", "01/01/1900", "Scrum Master", "Dallas"));
        };
    }
    
}
