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
public class AirlineClass {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_id")
    private long id;
    @Column(nullable = false)
    private String className;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Fare> fare;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<SeatSelection> seatPlan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Fare> getFare() {
        return fare;
    }

    public void setFare(List<Fare> fare) {
        this.fare = fare;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public AirlineClass() {
    }

    public List<SeatSelection> getSeatPlan() {
        return seatPlan;
    }

    public void setSeatPlan(List<SeatSelection> seatPlan) {
        this.seatPlan = seatPlan;
    }

    public AirlineClass(long id, String className, List<Fare> fare, List<SeatSelection> seatPlan) {
        this.id = id;
        this.className = className;
        this.fare = fare;
        this.seatPlan = seatPlan;
    }

    
}