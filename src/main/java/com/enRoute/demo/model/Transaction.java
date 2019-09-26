package com.enRoute.demo.model;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author JODY
 */
@Entity
public class Transaction {
@Id
@Column(name="transaction_id",nullable=false)
private long id;
private String paymentMethod;
private String cardNumber;
private String cardName;
private Date expirationDate;
private long CVV;
private String email;
private String billingAddress1;
private String billingSuburb;
private String billingCity;
private String billingCountry;
private long billingPostalCode;
@Column(nullable=false)
private Timestamp transactionDate;

private long userId;

@OneToOne(cascade = CascadeType.ALL)
private CarHireLog carHireLog;  

@OneToOne(cascade = CascadeType.ALL)
private HotelLog hotelLog;  

@OneToOne(cascade = CascadeType.ALL)
private FlightLog flightLog;    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public long getCVV() {
        return CVV;
    }

    public void setCVV(long CVV) {
        this.CVV = CVV;
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

    public long getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(long billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public CarHireLog getCarHireLog() {
        return carHireLog;
    }

    public void setCarHireLog(CarHireLog carHireLog) {
        this.carHireLog = carHireLog;
    }

    public HotelLog getHotelLog() {
        return hotelLog;
    }

    public void setHotelLog(HotelLog hotelLog) {
        this.hotelLog = hotelLog;
    }

    public FlightLog getFlightLog() {
        return flightLog;
    }

    public void setFlightLog(FlightLog flightLog) {
        this.flightLog = flightLog;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Transaction() {
    }

    public Transaction(long id, String paymentMethod, String cardNumber, String cardName, Date expirationDate, long CVV, String email, String billingAddress1, String billingSuburb, String billingCity, String billingCountry, long billingPostalCode, Timestamp transactionDate, long userId, CarHireLog carHireLog, HotelLog hotelLog, FlightLog flightLog) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.expirationDate = expirationDate;
        this.CVV = CVV;
        this.email = email;
        this.billingAddress1 = billingAddress1;
        this.billingSuburb = billingSuburb;
        this.billingCity = billingCity;
        this.billingCountry = billingCountry;
        this.billingPostalCode = billingPostalCode;
        this.transactionDate = transactionDate;
        this.userId = userId;
        this.carHireLog = carHireLog;
        this.hotelLog = hotelLog;
        this.flightLog = flightLog;
    }

    public Transaction(long id, String paymentMethod, String cardNumber, String cardName, Date expirationDate, long CVV, String email, String billingAddress1, String billingSuburb, String billingCity, String billingCountry, long billingPostalCode, Timestamp transactionDate, CarHireLog carHireLog, HotelLog hotelLog, FlightLog flightLog) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.expirationDate = expirationDate;
        this.CVV = CVV;
        this.email = email;
        this.billingAddress1 = billingAddress1;
        this.billingSuburb = billingSuburb;
        this.billingCity = billingCity;
        this.billingCountry = billingCountry;
        this.billingPostalCode = billingPostalCode;
        this.transactionDate = transactionDate;
        this.carHireLog = carHireLog;
        this.hotelLog = hotelLog;
        this.flightLog = flightLog;
    }

    
   
}


