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
public class SeatLog {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="seat_log_id")
    private long id;
    @Column(nullable = false)
    private int seatRow;
    @Column(nullable = false)
    private String seatColumn;
    @Column(nullable = false)
    private String seatPosition; 
    @Column(nullable = false)
    private String seatType;
    @Column(nullable = false)
    private double seatPrice; 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(String seatColumn) {
        this.seatColumn = seatColumn;
    }

    public String getSeatPosition() {
        return seatPosition;
    }

    public void setSeatPosition(String seatPosition) {
        this.seatPosition = seatPosition;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(double seatPrice) {
        this.seatPrice = seatPrice;
    }

    public SeatLog() {
    }
    
}
