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
public class CarWaiverDetails {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="car_waiver_id")
private long id;
@Column(nullable = false)
private double waiverAdminFee;
@Column(nullable = false)
private double waiverDepositFee;
@Column(nullable = false)
private double waiverExcessFee;
@Column(nullable = false,length = 1000)
private String waiverDescription;
@Column(nullable = false,length = 1000)
private String waiverExcludeDescription;
@Column(nullable = false,length = 1000)
private String waiverIncludeDescription;
@Column(nullable = false)
private String waiverType;
@Column(nullable = false)
private double waiverPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    

    public String getWaiverDescription() {
        return waiverDescription;
    }

    public void setWaiverDescription(String waiverDescription) {
        this.waiverDescription = waiverDescription;
    }

    public String getWaiverExcludeDescription() {
        return waiverExcludeDescription;
    }

    public void setWaiverExcludeDescription(String waiverExcludeDescription) {
        this.waiverExcludeDescription = waiverExcludeDescription;
    }

    public String getWaiverIncludeDescription() {
        return waiverIncludeDescription;
    }

    public void setWaiverIncludeDescription(String waiverIncludeDescription) {
        this.waiverIncludeDescription = waiverIncludeDescription;
    }

    public String getWaiverType() {
        return waiverType;
    }

    public void setWaiverType(String waiverType) {
        this.waiverType = waiverType;
    }

    public double getWaiverAdminFee() {
        return waiverAdminFee;
    }

    public void setWaiverAdminFee(double waiverAdminFee) {
        this.waiverAdminFee = waiverAdminFee;
    }

    public double getWaiverDepositFee() {
        return waiverDepositFee;
    }

    public void setWaiverDepositFee(double waiverDepositFee) {
        this.waiverDepositFee = waiverDepositFee;
    }

    public double getWaiverExcessFee() {
        return waiverExcessFee;
    }

    public void setWaiverExcessFee(double waiverExcessFee) {
        this.waiverExcessFee = waiverExcessFee;
    }

    public double getWaiverPrice() {
        return waiverPrice;
    }

    public void setWaiverPrice(double waiverPrice) {
        this.waiverPrice = waiverPrice;
    }

    public CarWaiverDetails() {
    }

}
