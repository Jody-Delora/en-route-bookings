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
public class CarExtraLog {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="car_extra_log_id")
private long id;   
@Column(nullable = false)
private String carExtraType;
@Column(nullable = false)
private String carExtraPrice;

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

    public String getCarExtraPrice() {
        return carExtraPrice;
    }

    public void setCarExtraPrice(String carExtraPrice) {
        this.carExtraPrice = carExtraPrice;
    }

    public CarExtraLog() {
    }

}
