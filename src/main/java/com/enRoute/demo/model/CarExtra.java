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
public class CarExtra {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="car_extra_id")
private long id;   
@Column(nullable = false)
private String carExtraType;
@Column(nullable = false)
private double carExtraPrice;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarExtraType() {
        return carExtraType;
    }

    public void setCarExtraType(String carExtraType) {
        this.carExtraType = carExtraType;
    }

    public double getCarExtraPrice() {
        return carExtraPrice;
    }

    public void setCarExtraPrice(double carExtraPrice) {
        this.carExtraPrice = carExtraPrice;
    }


    public CarExtra() {
    }

}
