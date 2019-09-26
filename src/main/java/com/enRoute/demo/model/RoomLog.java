package com.enRoute.demo.model;

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
public class RoomLog {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="room_log_id")
private long id;
@Column(nullable = false)
private String roomType;
@Column(nullable = false,length = 1000)
private String roomDescription;
@Column(nullable = false,length = 1000)
private String roomAmenity;
@Column(nullable=false)
private double roomPrice;


@OneToMany(cascade=CascadeType.ALL)
private List<Traveller> traveller;

@OneToOne(cascade=CascadeType.ALL)
private PrimaryContactDetails primaryContact;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomAmenity() {
        return roomAmenity;
    }

    public void setRoomAmenity(String roomAmenity) {
        this.roomAmenity = roomAmenity;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public List<Traveller> getTraveller() {
        return traveller;
    }

    public void setTraveller(List<Traveller> traveller) {
        this.traveller = traveller;
    }

    public PrimaryContactDetails getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(PrimaryContactDetails primaryContact) {
        this.primaryContact = primaryContact;
    }

    public RoomLog() {
    }

    public RoomLog(long id, String roomType, String roomDescription, String roomAmenity, double roomPrice, List<Traveller> traveller, PrimaryContactDetails primaryContact) {
        this.id = id;
        this.roomType = roomType;
        this.roomDescription = roomDescription;
        this.roomAmenity = roomAmenity;
        this.roomPrice = roomPrice;
        this.traveller = traveller;
        this.primaryContact = primaryContact;
    }
    

}

