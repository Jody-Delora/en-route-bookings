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
public class Room {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="room_id")
private long id;
@Column(nullable = false)
private String roomType;
@Column(nullable = false,length = 1000)
private String roomDescription;
@Column(nullable = false,length = 1000)
private String roomAmenity;
private double roomPrice;


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

    public Room() {
    }

    
}

