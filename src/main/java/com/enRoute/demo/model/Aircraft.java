package com.enRoute.demo.model;

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
public class Aircraft {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="aircraft_id")
    private long id;
    @Column(nullable = false)
    private String aircraftName;
    @Column(nullable = false)
    private String carrierName;
    private String carrierLogo;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<FlightSchedule> flightSchedule;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aircraft(long id, String aircraftName, String carrierName, String carrierLogo, List<FlightSchedule> flightSchedule) {
        this.id = id;
        this.aircraftName = aircraftName;
        this.carrierName = carrierName;
        this.carrierLogo = carrierLogo;
        this.flightSchedule = flightSchedule;
    }

    
    public Aircraft() {
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

    public void setCarirerName(String carrierName) {
        this.carrierName = carrierName;
    }

   
    public List<FlightSchedule> getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(List<FlightSchedule> flightSchedule) {
        this.flightSchedule = flightSchedule;
    }

    public String getCarrierLogo() {
        return carrierLogo;
    }

    public void setCarrierLogo(String carrierLogo) {
        this.carrierLogo = carrierLogo;
    }

   
}