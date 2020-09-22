package com.bloom.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import com.bloom.models.Movie;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface MovieDao {
	
    @SqlUpdate("CREATE TABLE IF NOT EXISTS Movie (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, duration INT NOT NULL, actor VARCHAR(255) ,actress VARCHAR(255) ,director VARCHAR(255) NOT NULL, releaseYear INT NOT NULL, primary key(id))")
    void createMovieTable();

    @SqlUpdate("INSERT INTO Movie (name,duration,actor,actress,director,releaseYear) VALUES(:name,:duration,:actor,:actress,:director,:releaseYear)")
    @GetGeneratedKeys
    int addMovie(@BindBean Movie movie);

    @SqlQuery("SELECT * FROM Movie")
    List<Movie> getAll();

    @SqlQuery("SELECT * FROM Movie WHERE id = :id")
    Movie getMovieById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM Movie WHERE duration = :duration ")
    List<Movie> getMoviesByDuration( @Bind("duration") String duration);

    @SqlQuery("SELECT * FROM Movie WHERE actor = :actor ")
    List<Movie> getMoviesByActor( @Bind("actor") String actor);

    @SqlQuery("SELECT * FROM Movie WHERE actress = :actress ")
    List<Movie> getMoviesByActress( @Bind("actress") String actress);
    
    @SqlQuery("SELECT * FROM Movie WHERE director = :director ")
    List<Movie> getMoviesByDirector( @Bind("director") String director);

    @SqlQuery("SELECT * FROM Movie WHERE name = :name ")
    List<Movie> getMoviesByName( @Bind("name") String name);

    

    @SqlQuery("SELECT * FROM Movie WHERE releaseYear = :releaseYear ")
    List<Movie> getMoviesByReleaseYear( @Bind("releaseYear") String releaseYear);
    
    @SqlUpdate("DELETE FROM Movie WHERE id = :id")
    int removeMovieById(@Bind("id") int id);

    @SqlUpdate("UPDATE Movie SET name = :name,duration = :duration, actor =:actor, actress = :actress, director = :director, releaseYear = :releaseYear WHERE id = :id ")
    int updateMovie(@Bind("id") int id,@BindBean Movie movie);

}
