package com.company;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by rusJA.
 */
public abstract class Employees {
    protected Integer id;
    protected String name;
    protected String surname;
    protected String birthday;
    protected String startwork;

    public int getId() {
        return id;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStartwork() {
        return startwork;
    }

    public void setStartwork(String startWork) {
        this.startwork = startWork;
    }

    @Override
    public abstract String toString();
}
