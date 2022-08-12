package DAO;

import java.io.Serializable;

public class User implements  Serializable {

    private String firstName;
    private String lastName;
    private String alias;
    private boolean admin;

    public User(String firstName, String lastName, String alias, boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.admin = admin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}

