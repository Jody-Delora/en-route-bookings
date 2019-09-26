package com.enRoute.demo.model;

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
public class BillingDetails {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(nullable=false,name="billing_id")
private long id;    
@Column(nullable=false)
private String billingAddress1;
@Column(nullable=false)
private String billingSuburb;
@Column(nullable=false)
private String billingCity;
@Column(nullable=false)
private String billingCountry;
@Column(nullable=false)
private long billingPostalCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public void setBillingAddress1(String billingAddress1) {
        this.billingAddress1 = billingAddress1;
    }

    public String getBillingSuburb() {
        return billingSuburb;
    }

    public void setBillingSuburb(String billingSuburb) {
        this.billingSuburb = billingSuburb;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public long getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(long billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public BillingDetails() {
    }

}
