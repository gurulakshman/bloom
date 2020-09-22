package com.bloom.resources;


import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bloom.dao.EmployeeDao;
import com.bloom.models.Employee;


@Path("/Employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private EmployeeDao employeeDao;

    public EmployeeResource(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @GET
    @Path("/getAll")
    public List<Employee> getAllEmployees() { return this.employeeDao.getAll(); }

    @POST
    public Employee addEmployee(@Valid Employee employee) {
        int employeeID = this.employeeDao.addEmployee(employee);
        employee.setId(employeeID);
        return employee;
    }

    @DELETE
    @Path("/remove/{id}")
    public int removeEmployee(@PathParam("id") int id) {
        this.employeeDao.removeEmployeeById(id);
        return id;
    }



}
