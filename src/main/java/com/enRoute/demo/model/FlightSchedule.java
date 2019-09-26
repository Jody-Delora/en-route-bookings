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
import javax.persistence.OneToOne;

/**
 *
 * @author JODY
 */
@Entity
public class FlightSchedule {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="flight_id")
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
 
    @OneToOne(cascade=CascadeType.ALL)
    private AirlineClass airlineClass;     
    
     @OneToMany(cascade=CascadeType.ALL)
    private List<FlightExtra> flightExtra;

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

    public AirlineClass getAirlineClass() {
        return airlineClass;
    }

    public void setAirlineClass(AirlineClass airlineClass) {
        this.airlineClass = airlineClass;
    }

    
    public List<FlightExtra> getFlightExtra() {
        return flightExtra;
    }

    public void setFlightExtra(List<FlightExtra> flightExtra) {
        this.flightExtra = flightExtra;
    }

    public FlightSchedule(long id, Time arrivalTime, String arrivalLocation, Date departureDate, Time departureTime, String departureLocation, String flightNo, Date arrivalDate, AirlineClass airlineClass, List<FlightExtra> flightExtra) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.departureLocation = departureLocation;
        this.flightNo = flightNo;
        this.arrivalDate = arrivalDate;
        this.airlineClass = airlineClass;
        this.flightExtra = flightExtra;
    }
    
    public FlightSchedule() {
    }
   
   

}

