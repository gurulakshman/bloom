package com.bloom;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;


public class BloomConfiguration extends Configuration {


    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();


    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
