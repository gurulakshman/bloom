package com.bloom;

import com.bloom.resources.MovieResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class BloomApplication
    extends Application<BloomConfiguration> {

    public static void main(String[] args) throws Exception {
        new BloomApplication().run(args);
    }

    @Override
    public void run(BloomConfiguration configuration,
                    Environment environment) {
        environment.jersey().register(new MovieResource(configuration.getDefaultName()));
    }
}