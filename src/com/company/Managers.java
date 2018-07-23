package com.company;

import java.util.ArrayList;

/**
 * Created by rusJA.
 */
public class Managers extends Employees {

    ArrayList<String> workersId = new ArrayList<>();

    @Override
    public String toString() {
        return "Manager {" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", Birthday='" + birthday + '\'' +
                ", Start work='" + startwork + '\'' +
                ", workers ID='" + workersId + '\'' +
                '}';
    }
}
