package com.example.SoapExample.Endpoints;


import com.example.SoapExample.Model.Employees;
import com.example.SoapExample.Service.EmployeesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soapexample.example.com.allapis.*;

@Endpoint
public class EmployeeEndPoint {

    private static final String NAMESPACE_URL="http://com.example.SoapExample/allapis";

    @Autowired
    EmployeesService employeesService;


    @PayloadRoot(namespace = NAMESPACE_URL,localPart = "addEmployeeRequest")
    @ResponsePayload
    public AddEmployeeResponse addEmployeeResponse(@RequestPayload AddEmployeeRequest request)
    {
        AddEmployeeResponse response=new AddEmployeeResponse();
         ServiceStatus status=new ServiceStatus();

        Employees employees=new Employees();

        BeanUtils.copyProperties(request.getEmployees(),employees);

        employeesService.addEmployees(employees);

        status.setStatus("SUCCESS");
        status.setMessage("Employee added");
        response.setStatus(status);
      return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URL,localPart = "getEmployeeByIdRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployees(@RequestPayload GetEmployeesRequest request)
    {
        GetEmployeeResponse response=new GetEmployeeResponse();
        soapexample.example.com.allapis.Employees employees=new soapexample.example.com.allapis.Employees();
        BeanUtils.copyProperties(employeesService.getEmployees(request.getEmployeeId()),employees);
        response.setEmployees(employees);
        return response;
    }
}
