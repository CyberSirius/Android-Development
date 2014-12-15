package com.example.lyubo.classassignmentsix;

/**
 * Created by Lyubo on 12/4/2014.
 */
public class Country {
    private String name;
    private String code;
    private int id;

    public Country() {
        name = null;
        code = null;
    }

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
        this.id = 1;
    }

    public Country(String name, String code, int id) {
        this.name = name;
        this.code = code;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return code + " " + name;
    }
}
