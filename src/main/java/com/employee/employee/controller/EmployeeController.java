package com.employee.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.employee.models.Employee;
import com.employee.employee.repositories.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("http://localhost:3000/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;
    

    @GetMapping("/welcome")
    public String welcome() {
        return "<h1>Welcome to the Employee Page</h1>";
    }

    /*\
     * GET - return data
     * PUT - Update existing data
     * POST - Adding new data
     * DELETE - delete data
     * 
     * CRUD - Create, Retrieve, Update, Delete
     */

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getOneEmployee(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/new")
    public Employee addNewEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee updateEmployee) {
        return repository.save(updateEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }


    /*
     * weather {
     *      temperature: 70
     *      humidity: 80
     *      UV: 59
     *      Wind: ...
     *      direction: ....
     *      AQI: ....
     * }
     * 
     * JSON - Javascript Object Notation
     */

}
