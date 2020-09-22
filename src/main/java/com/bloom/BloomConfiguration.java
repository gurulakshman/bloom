package com.bloom;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The  configuration of Drop wizard application. 
 * This class will load all the configuration properties. 
 * @author Guru
 *
 */
public class BloomConfiguration extends Configuration {


    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    /**
     * This method will returns the data source after getting from yaml file..
     * @return DataSourceFactory
     */
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
