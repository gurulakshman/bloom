package com.bloom.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource {
    private final String defaultName;

    public MovieResource(final String defaultName) {
        this.defaultName = defaultName;
    }

    @GET
    public String getById(@QueryParam("id") Optional<String> id) {
       return " This returns movie details based on id : " + id.get()  ;
    }

}
