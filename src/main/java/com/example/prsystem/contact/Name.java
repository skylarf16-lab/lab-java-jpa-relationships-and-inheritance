package com.example.prsystem.contact;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Name implements Serializable {
    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;

    public Name() {}

    public Name(String salutation, String firstName, String middleName, String lastName) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    // getters and setters
    public String getSalutation() { return salutation; }
    public void setSalutation(String salutation) { this.salutation = salutation; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
