package com.bloom.resources;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.bloom.dao.EmployeeDao;
import com.bloom.dao.MovieDao;
import com.bloom.models.Employee;
import com.bloom.models.Movie;

import java.util.List;
import java.util.Optional;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource {
	
    private MovieDao movieDao;

    public MovieResource(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @GET
    //@Path("/getAll")
    public List<Movie> getAllMovies() { return this.movieDao.getAll(); }

    @GET
    @Path("/{id}")
    public Movie getMovieById(@PathParam("id") int id) { 
    	return this.movieDao.getMovieById(id); 
    }
    @GET
    @Path("/{fieldname}/{fieldvalue}")
    public List<Movie> getMovieById(@PathParam("fieldname") String fieldname,@PathParam("fieldvalue") String fieldvalue) { 
    	System.out.println("fieldname :" + fieldname ); 
    	System.out.println("fieldvalue :" + fieldvalue );
    	if(fieldname.equals("duration")) {
    		return this.movieDao.getMoviesByDuration(fieldvalue); 
    	} 

    	return null;
    }

    @POST
    public Movie addMovie(@Valid Movie movie) {
        int movieID = this.movieDao.addMovie(movie);
        movie.setId(movieID);
        return movie;
    }
    @DELETE
    @Path("/{id}")
    public int removeMovie(@PathParam("id") int id) {
        this.movieDao.removeMovieById(id);
        return id;
    }
    @PUT
    @Path("/{id}")
    public int updateMovie(@Valid Movie movie,@PathParam("id") int id) {
        int movieID = this.movieDao.updateMovie(id,movie);
        return movieID;
    }

}
