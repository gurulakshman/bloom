package com.bloom.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;



public class Employee {

    public Employee(int id, String name, String phoneNumber, String acronym) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.acronym = acronym;
    }
    public Employee() {

    }

    @NotNull
    @JsonProperty
    private int id;

    @NotNull
    @JsonProperty
    private String name;

    @NotNull
    @JsonProperty
    private String phoneNumber;


    @NotNull
    @JsonProperty
    private String acronym;


    /*  Jackson operates on Setters and Getters, don't remove. */


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }

    public void setAcronym(String acronym) { this.acronym = acronym; }


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getAcronym() { return this.acronym; }

}
