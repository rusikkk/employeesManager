package com.company;

/**
 * Created by rusJA.
 */
public class Others extends Employees {
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Other {" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", Birthday='" + birthday + '\'' +
                ", Start work='" + startwork + '\'' +
                ", Description='" + description + '\'' +
                '}';
    }
}
