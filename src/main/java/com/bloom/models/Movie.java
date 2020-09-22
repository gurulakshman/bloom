package com.bloom.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * This is entity class for Movie table.
 * @author Guru
 *
 */
public class Movie {
	
    @JsonProperty
    private int id;

    @NotNull
    @JsonProperty
    private String name;


    @NotNull
    @JsonProperty
    private int duration;


    @JsonProperty
    private String actor;

    @JsonProperty
    private String actress;

    @NotNull
    @JsonProperty
    private String director;

    @NotNull
    @JsonProperty
    private int releaseYear;

	public int getId() {
		return id;
	}
	
	public Movie() {
		
	}
	
	

	public Movie(String name, int duration, String actor, String actress, String director, int releaseYear) {
		super();
		this.name = name;
		this.duration = duration;
		this.actor = actor;
		this.actress = actress;
		this.director = director;
		this.releaseYear = releaseYear;
	}





	public Movie(int id, String name, int duration, String actor, String actress, String director, int releaseYear) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.actor = actor;
		this.actress = actress;
		this.director = director;
		this.releaseYear = releaseYear;
	}





	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getActress() {
		return actress;
	}

	public void setActress(String actress) {
		this.actress = actress;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", duration=" + duration + ", actor=" + actor + ", actress="
				+ actress + ", director=" + director + ", releaseYear=" + releaseYear + "]";
	}
    
    
    
    
    
    
    
    
}
