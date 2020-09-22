package com.bloom.dao;

import com.bloom.models.Employee;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;
import java.util.List;


@RegisterMapperFactory(BeanMapperFactory.class)
public interface EmployeeDao {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS Employees (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, phoneNumber VARCHAR(255) NOT NULL, acronym VARCHAR(255) NOT NULL, primary key(name, acronym))")
    void createEmployeeTable();

    @SqlUpdate("INSERT INTO Employees (NAME,PHONENUMBER,ACRONYM) VALUES(:name, :phoneNumber, :acronym)")
    @GetGeneratedKeys
    int addEmployee(@BindBean Employee employee);

    @SqlQuery("SELECT * FROM Employees")
    List<Employee> getAll();

    @SqlUpdate("DELETE FROM EMPLOYEES WHERE id = :id")
    int removeEmployeeById(@Bind("id") int id);
}