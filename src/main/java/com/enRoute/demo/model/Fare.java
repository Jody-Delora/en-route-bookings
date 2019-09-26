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
public class Fare {
    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="fare_id")
    private long id;
    @Column(nullable = false)
    private String fareType;
    @Column(nullable = false)
    private String checkedBaggage;
    @Column(nullable = false)
    private String flightCancellation;
    @Column(nullable = false)
    private String flightChanges;
    @Column(nullable = false)
    private String foodAndBeverages;
    @Column(nullable = false)
    private double farePrice;
    @Column(nullable = false)
    private double VAT;
    @Column(nullable = false)
    private double passengerSafetyCharge;
    @Column(nullable = false)
    private double passengerSecurityCharge;
    @Column(nullable = false)
    private double passengerServiceCharge;
    @Column(nullable = false)
    private long maxSeats;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Fare() {
    }
   
    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public String getCheckedBaggage() {
        return checkedBaggage;
    }

    public void setCheckedBaggage(String checkedBaggage) {
        this.checkedBaggage = checkedBaggage;
    }

    public String getFlightCancellation() {
        return flightCancellation;
    }

    public void setFlightCancellation(String flightCancellation) {
        this.flightCancellation = flightCancellation;
    }
    

    public String getFlightChanges() {
        return flightChanges;
    }

    public void setFlightChanges(String flightChanges) {
        this.flightChanges = flightChanges;
    }

    public String getFoodAndBeverages() {
        return foodAndBeverages;
    }

    public void setFoodAndBeverages(String foodAndBeverages) {
        this.foodAndBeverages = foodAndBeverages;
    }

    public double getFarePrice() {
        return farePrice;
    }

    public void setFarePrice(double farePrice) {
        this.farePrice = farePrice;
    }

    public double getPassengerSafetyCharge() {
        return passengerSafetyCharge;
    }

    public void setPassengerSafetyCharge(double passengerSafetyCharge) {
        this.passengerSafetyCharge = passengerSafetyCharge;
    }

    public double getPassengerSecurityCharge() {
        return passengerSecurityCharge;
    }

    public void setPassengerSecurityCharge(double passengerSecurityCharge) {
        this.passengerSecurityCharge = passengerSecurityCharge;
    }

    public double getPassengerServiceCharge() {
        return passengerServiceCharge;
    }

    public void setPassengerServiceCharge(double passengerServiceCharge) {
        this.passengerServiceCharge = passengerServiceCharge;
    }

    public long getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(long maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Fare(long id, String fareType, String checkedBaggage, String flightCancellation, String flightChanges, String foodAndBeverages, double farePrice, double VAT, double passengerSafetyCharge, double passengerSecurityCharge, double passengerServiceCharge, long maxSeats) {
        this.id = id;
        this.fareType = fareType;
        this.checkedBaggage = checkedBaggage;
        this.flightCancellation = flightCancellation;
        this.flightChanges = flightChanges;
        this.foodAndBeverages = foodAndBeverages;
        this.farePrice = farePrice;
        this.VAT = VAT;
        this.passengerSafetyCharge = passengerSafetyCharge;
        this.passengerSecurityCharge = passengerSecurityCharge;
        this.passengerServiceCharge = passengerServiceCharge;
        this.maxSeats = maxSeats;
    }

   
}
