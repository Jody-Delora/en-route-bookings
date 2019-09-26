package com.enRoute.demo.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author JODY
 */
@Entity
public class FlightLog {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="flight_log_id")
private long id;
@Column(nullable = false)
private Time arrivalTime;
@Column(nullable = false)
private String arrivalLocation;
@Column(nullable = false)
private Date departureDate;
@Column(nullable = false)
private Time departureTime;
@Column(nullable = false)
private String departureLocation;
@Column(nullable = false)
private String flightNo;
@Column(nullable = false)
private Date arrivalDate;
@Column(nullable = false)
private String className;
@Column(nullable = false)
private String aircraftName;
private String carrierLogo;
@Column(nullable = false)
private String carrierName;
private String fareType;
@Column(nullable=false)
private double passengerSafetyCharge;
@Column(nullable=false)
private double passengerSecurityCharge;
@Column(nullable=false)
private double passengerServiceCharge;
@Column(nullable=false)
private double VAT;
private double flightTotal;
private double taxTotal;
private double seatTotal;
private double extraTotal;
private double grandTotal;
@OneToMany(cascade=CascadeType.ALL)
private List<Traveller> traveller;
@OneToMany(cascade=CascadeType.ALL)
private List<SeatLog> seatLog;
@OneToMany(cascade=CascadeType.ALL)
private List<FlightExtraLog> flightExtraLog;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public List<Traveller> getTraveller() {
        return traveller;
    }

    public void setTraveller(List<Traveller> traveller) {
        this.traveller = traveller;
    }

    public List<SeatLog> getSeatLog() {
        return seatLog;
    }

    public void setSeatLog(List<SeatLog> seatLog) {
        this.seatLog = seatLog;
    }

    public List<FlightExtraLog> getFlightExtraLog() {
        return flightExtraLog;
    }

    public void setFlightExtraLog(List<FlightExtraLog> flightExtraLog) {
        this.flightExtraLog = flightExtraLog;
    }

    public String getCarrierLogo() {
        return carrierLogo;
    }

    public void setCarrierLogo(String carrierLogo) {
        this.carrierLogo = carrierLogo;
    }

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
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

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public double getFlightTotal() {
        return flightTotal;
    }

    public void setFlightTotal(double flightTotal) {
        this.flightTotal = flightTotal;
    }

    public double getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(double taxTotal) {
        this.taxTotal = taxTotal;
    }

    public double getSeatTotal() {
        return seatTotal;
    }

    public void setSeatTotal(double seatTotal) {
        this.seatTotal = seatTotal;
    }

    public double getExtraTotal() {
        return extraTotal;
    }

    public void setExtraTotal(double extraTotal) {
        this.extraTotal = extraTotal;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
    
    public FlightLog() {
    }

    public FlightLog(long id, Time arrivalTime, String arrivalLocation, Date departureDate, Time departureTime, String departureLocation, String flightNo, Date arrivalDate, String className, String aircraftName, String carrierLogo, String carrierName, String fareType, double passengerSafetyCharge, double passengerSecurityCharge, double passengerServiceCharge, double VAT, double flightTotal, double taxTotal, double seatTotal, double extraTotal, double grandTotal, List<Traveller> traveller, List<SeatLog> seatLog, List<FlightExtraLog> flightExtraLog) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.departureLocation = departureLocation;
        this.flightNo = flightNo;
        this.arrivalDate = arrivalDate;
        this.className = className;
        this.aircraftName = aircraftName;
        this.carrierLogo = carrierLogo;
        this.carrierName = carrierName;
        this.fareType = fareType;
        this.passengerSafetyCharge = passengerSafetyCharge;
        this.passengerSecurityCharge = passengerSecurityCharge;
        this.passengerServiceCharge = passengerServiceCharge;
        this.VAT = VAT;
        this.flightTotal = flightTotal;
        this.taxTotal = taxTotal;
        this.seatTotal = seatTotal;
        this.extraTotal = extraTotal;
        this.grandTotal = grandTotal;
        this.traveller = traveller;
        this.seatLog = seatLog;
        this.flightExtraLog = flightExtraLog;
    }

}
