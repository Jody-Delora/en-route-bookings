package com.enRoute.demo.model;

import java.sql.Date;
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
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="user_id")
private long id;
@Column(columnDefinition = "VARCHAR(30) default 'ROLE_USER'")
private String permission;
private String password;
@Column(nullable = false)
private String email1;
@Column(nullable = false)
private String firstName;
@Column(nullable = false)
private String lastName;
@Column(nullable = false)
private Date dateOfBirth;
@Column(nullable = false)
private String mobile1;
private String mobile2;
@Column(nullable = false)
private String gender;
private String email2;

@OneToOne(cascade=CascadeType.ALL)
private BillingDetails billingDetails;
    public User() {
       
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BillingDetails getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    public User(long id, String permission, String password, String email1, String firstName, String lastName, Date dateOfBirth, String mobile1, String mobile2, String gender, String email2, BillingDetails billingDetails) {
        this.id = id;
        this.permission = permission;
        this.password = password;
        this.email1 = email1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.gender = gender;
        this.email2 = email2;
        this.billingDetails = billingDetails;
    }
    
    
}