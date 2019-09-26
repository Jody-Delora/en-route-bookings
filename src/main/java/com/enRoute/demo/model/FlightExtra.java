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
public class FlightExtra {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="flight_extra_id")
    private long id;
    @Column(nullable = false)
    private String extraType;
    @Column(nullable = false,length = 1000)
    private String extraDescription;
    @Column(nullable = false)
    private double extraPrice;
    private String extraImage;

  
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExtraType() {
        return extraType;
    }

    public void setExtraType(String extraType) {
        this.extraType = extraType;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }

    public double getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(double extraPrice) {
        this.extraPrice = extraPrice;
    }

    public String getExtraImage() {
        return extraImage;
    }

    public void setExtraImage(String extraImage) {
        this.extraImage = extraImage;
    }

    public FlightExtra(long id, String extraType, String extraDescription, double extraPrice, String extraImage) {
        this.id = id;
        this.extraType = extraType;
        this.extraDescription = extraDescription;
        this.extraPrice = extraPrice;
        this.extraImage = extraImage;
    }
    
    
    public FlightExtra() {
    }

}
