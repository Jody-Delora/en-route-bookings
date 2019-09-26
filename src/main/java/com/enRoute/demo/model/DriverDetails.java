package com.enRoute.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author JODY
 */
@Entity
public class DriverDetails {
@Id   
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="driver_id")
private long id;
private String title;
private String firstName;
private String lastName;
private int age;

@OneToOne(cascade = CascadeType.ALL)
private PrimaryContactDetails primaryContact;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DriverDetails() {
    }

    public DriverDetails(long id, String title, String firstName, String lastName, int age, PrimaryContactDetails primaryContact) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.primaryContact = primaryContact;
    }

   
}
