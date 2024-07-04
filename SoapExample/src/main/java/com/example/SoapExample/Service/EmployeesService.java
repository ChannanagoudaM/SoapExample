package com.example.SoapExample.Service;

import com.example.SoapExample.Model.Employees;
import com.example.SoapExample.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeesService implements EmployeesDemo{

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public void addEmployees(Employees employees) {
        employeeRepo.save(employees);
    }

    @Override
    public Optional<Employees> getEmployees(int id) {
        Optional<Employees> employees=employeeRepo.findById(id);
        return employees;
    }

    @Override
    public void updateEmployees(Employees employees) {
employeeRepo.save(employees);
    }

    @Override
    public void deleteEmployees(int id) {
        employeeRepo.deleteById(id);
    }
}
