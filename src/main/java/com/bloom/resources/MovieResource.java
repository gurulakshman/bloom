package com.bloom.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bloom.dao.MovieDao;
import com.bloom.models.Movie;
/**
 * This is rest/Controller class for Movie services.
 * @author Guru
 *
 */
@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource {
	
    private MovieDao movieDao;

    public MovieResource(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
    /**
     * This service will return all the movies in the movie table.
     * @return List<Movie>
     */
    @GET
    public List<Movie> getAllMovies() { return this.movieDao.getAll(); }
    
    /**
     * This service will return the movie details of the Id.
     * @return Movie
     */
    @GET
    @Path("/{id}")
    public Movie getMovieById(@PathParam("id") int id) { 
    	return this.movieDao.getMovieById(id); 
    }
    /**
     * This service returns the movie list base on field and field value.  
     * @param fieldname  field name you want to search.
     * @param fieldvalue field value you want to search.
     * @return List<Movie>
     */
    @GET
    @Path("/{fieldname}/{fieldvalue}")
    public List<Movie> getMovieById(@PathParam("fieldname") String fieldname,@PathParam("fieldvalue") String fieldvalue) { 
    	if(fieldname.equals("duration")) {
    		return this.movieDao.getMoviesByDuration(fieldvalue); 
    	} 
    	if(fieldname.equals("actor")) {
    		return this.movieDao.getMoviesByActor(fieldvalue); 
    	} 
    	if(fieldname.equals("actress")) {
    		return this.movieDao.getMoviesByActress(fieldvalue); 
    	} 
    	if(fieldname.equals("director")) {
    		return this.movieDao.getMoviesByDirector(fieldvalue); 
    	} 
    	if(fieldname.equals("releaseYear")) {
    		return this.movieDao.getMoviesByReleaseYear(fieldvalue); 
    	} 
    	if(fieldname.equals("name")) {
    		return this.movieDao.getMoviesByName(fieldvalue); 
    	} 

    	return null;
    }
    /**
     * This method will add movie details to movie table. 
     * @param movie
     * @return Movie
     */
    @POST
    public Movie addMovie(@Valid Movie movie) {
        int movieID = this.movieDao.addMovie(movie);
        movie.setId(movieID);
        return movie;
    }
    /**
     * This method will delete movie details based on id. 
     * @param id of the movide record.
     * @return id deleted record id.
     */
    @DELETE
    @Path("/{id}")
    public int removeMovie(@PathParam("id") int id) {
        this.movieDao.removeMovieById(id);
        return id;
    }
    /**
     * This method will update the movie details by id
     * @param movie new movie details to update
     * @param id  the movie id
     * @return id deleted record id
     */
    @PUT
    @Path("/{id}")
    public int updateMovie(@Valid Movie movie,@PathParam("id") int id) {
        int movieID = this.movieDao.updateMovie(id,movie);
        return movieID;
    }

}
