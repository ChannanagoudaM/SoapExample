package com.example.SoapExample.Repo;

import com.example.SoapExample.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends  JpaRepository<Employees,Integer> {

}
