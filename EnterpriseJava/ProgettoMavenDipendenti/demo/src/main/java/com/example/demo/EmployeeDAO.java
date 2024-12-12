package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeDAO {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> listAll() {
        return repo.findAll();
    }

    public void addEmployee(Employee employee) {
        repo.save(employee);
    }

    public Employee getEmployee(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
}
