package com.enRoute.demo.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author JODY
 */
@Entity
public class Traveller {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="traveller_id")
private long id;
private String title;
@Column(nullable = false)
private String firstName;
@Column(nullable = false)
private String lastName;
@Column(nullable = false)
private Date dateOfBirth;
@Column(nullable = false)
private String gender;
private String mobile1;
private String mobile2;
private String email1;
private String email2;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Traveller() {
    }
    public Traveller(long id, String title, String firstName, String lastName, Date dateOfBirth, String gender, String mobile1, String mobile2, String email1, String email2) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.email1 = email1;
        this.email2 = email2;
    }

    
}

