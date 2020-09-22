package com.bloom;

import org.skife.jdbi.v2.DBI;

import com.bloom.dao.EmployeeDao;
import com.bloom.dao.MovieDao;
import com.bloom.resources.EmployeeResource;
import com.bloom.resources.MovieResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BloomApplication
    extends Application<BloomConfiguration> {

    public static void main(String[] args) throws Exception {
        new BloomApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-hibernate";
    }

    @Override
    public void initialize(Bootstrap<BloomConfiguration> bootstrap) {

    }

    @Override
    public void run(BloomConfiguration conf, Environment env) throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(env, conf.getDataSourceFactory(),"h2");
        
        final EmployeeDao employeeDao = jdbi.onDemand(EmployeeDao.class);
        employeeDao.createEmployeeTable();
        
        final MovieDao movieDao = jdbi.onDemand(MovieDao.class);
        movieDao.createMovieTable();
        
        env.jersey().register(new EmployeeResource(employeeDao));
        env.jersey().register(new MovieResource(movieDao));
        
    }



}