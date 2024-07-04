package com.example.SoapExample.Service;

import com.example.SoapExample.Model.Employees;

import java.util.Optional;

public interface EmployeesDemo {

    public void addEmployees(Employees employees);

    public Optional<Employees> getEmployees(int id);

    public void updateEmployees(Employees employees);

    public void deleteEmployees(int id);
}
