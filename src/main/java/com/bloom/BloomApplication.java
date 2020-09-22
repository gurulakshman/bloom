package com.bloom;

import org.skife.jdbi.v2.DBI;

import com.bloom.dao.MovieDao;
import com.bloom.resources.MovieResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
/**
 * The main entry point into a Drop wizard application. 
 * All the setup and classes will be loaded here. 
 * @author Guru
 *
 */
public class BloomApplication
    extends Application<BloomConfiguration> {

    public static void main(String[] args) throws Exception {
        new BloomApplication().run(args);
    }
    @Override
    public String getName() {
        return "Movie-restApi";
    }
    /**
     * This is method initialize method for application.
     */
    @Override
    public void initialize(Bootstrap<BloomConfiguration> bootstrap) {

    }
    /**
     * This is method will start all the services.
     */
    @Override
    public void run(BloomConfiguration conf, Environment env) throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(env, conf.getDataSourceFactory(),"h2");
        
        final MovieDao movieDao = jdbi.onDemand(MovieDao.class);
        movieDao.createMovieTable();
        env.jersey().register(new MovieResource(movieDao));
        
    }



}