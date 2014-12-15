/**
 * Created by Strashimir on 15.12.2014 г..
 */
package com.mentormate.academy.redoflags;

public class Country {
    private String name;
    private String code;
    private int flag;

    public Country(Countries country) {
        this.name = country.name();
        this.code = country.code();
        this.flag = country.flag();
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(String code) {
        this.flag = flag;
    }
    //setters are useless
}
