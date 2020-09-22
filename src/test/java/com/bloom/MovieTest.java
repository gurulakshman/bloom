package com.bloom;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import com.bloom.dao.MovieDao;
import com.bloom.models.Movie;
import com.bloom.resources.MovieResource;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class will implement all the test cases for the movie service
 * @author Guru
 *
 */
public class MovieTest {
    private static final MovieDao dao = mock(MovieDao.class);
    private final MovieResource movieResource = new MovieResource(dao);
    
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new MovieResource(dao))
            .build();

    private final Movie movie = new Movie(1,"name1", 100, "actor1", "actress1", "director1", 2020);
    
    @Before
    public void setup() {
    }

    @After
    public void tearDown() {
        reset(dao);
    }
    /**
     * This method will test the insert movie data to database.
     * If it fails it will throw exception.
     * @throws Exception
     */
    @Test
    public void testCreateMovie() throws Exception {
    	Response response =  resources.client().target("/movies").request().post(Entity.json(movie));
    	assertEquals(response.getStatus(),200);
    }
    /**
     * This method will test the get movie details by id.
     * If it fails it will throw exception.
     * @throws Exception
     */
    @Test
    public void testGetMovieId() throws Exception {
    	Response response = resources.client().target("/movies/1").request().get();
    	assertEquals(response.getStatus(),204);
    }
    /**
     * This method will test the get all movie details.
     * If it fails it will throw exception.
     * @throws Exception
     */
    @Test
    public void testGetAllMovies() throws Exception {
    	Response response = resources.client().target("/movies").request().get();
    	String output = response.readEntity(String.class);
    	assertEquals(response.getStatus(),200);
    }
    /**
     * This method will test the get movie details based on field.
     * If it fails it will throw exception.
     * @throws Exception
     */
    @Test
    public void testGetMovieByField() throws Exception {
    	Response response = resources.client().target("/movies/duration/8").request().get();
    	String output = response.readEntity(String.class);
    	assertEquals(response.getStatus(),200);
    }
    /**
     * This method will test the delete movie.
     * If it fails it will throw exception.
     * @throws Exception
     */
    @Test
    public void testDeleteMovieById() throws Exception {
    	Response response = resources.client().target("/movies/8").request().delete();
    	String output = response.readEntity(String.class);
    	assertEquals(response.getStatus(),200);
    }



}
