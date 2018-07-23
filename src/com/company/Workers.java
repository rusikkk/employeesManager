package com.company;

/**
 * Created by rusJA.
 */
public class Workers extends Employees {

    @Override
    public String toString() {
        return "Worker {" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", Birthday='" + birthday + '\'' +
                ", Start work='" + startwork + '\'' +
                '}';

    }
}
