package com.enRoute.demo.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
public class HotelLog {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="hotel_log_id")
private long id;
@Column(nullable = false)
private String hotelName;
@ElementCollection
private List<String> hotelImage;
@Column(nullable = false)
private String hotelChain;
@Column(nullable = false)
private String hotelAddress1;
@Column(nullable = false)
private String hotelSuburb;
@Column(nullable = false)
private String hotelCity;
@Column(nullable = false)
private String hotelProvince;
@Column(nullable = false)
private String hotelCountry;
@Column(nullable = false)
private String starRating;
private String propertyType;
private String locationType;
@Column(nullable = false,length = 1000)
private String hotelDescription;
@Column(nullable = false,length = 1000)
private String propertyAmenities;
@Column(nullable=false)
private Date checkInDate;
@Column(nullable=false)
private Date checkOutDate;

@OneToMany(cascade=CascadeType.ALL)
private List<RoomLog>roomLog;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelChain() {
        return hotelChain;
    }

    public void setHotelChain(String hotelChain) {
        this.hotelChain = hotelChain;
    }

    public String getHotelAddress1() {
        return hotelAddress1;
    }

    public void setHotelAddress1(String hotelAddress1) {
        this.hotelAddress1 = hotelAddress1;
    }

    public String getHotelSuburb() {
        return hotelSuburb;
    }

    public void setHotelSuburb(String hotelSuburb) {
        this.hotelSuburb = hotelSuburb;
    }

   

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelProvince() {
        return hotelProvince;
    }

    public void setHotelProvince(String hotelProvince) {
        this.hotelProvince = hotelProvince;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(String hotelCountry) {
        this.hotelCountry = hotelCountry;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public String getPropertyAmenities() {
        return propertyAmenities;
    }

    public void setPropertyAmenities(String propertyAmenities) {
        this.propertyAmenities = propertyAmenities;
    }

   
    public List<RoomLog> getRoomLog() {
        return roomLog;
    }

    public void setRoomLog(List<RoomLog> roomLog) {
        this.roomLog = roomLog;
    }

    public List<String> getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(List<String> hotelImage) {
        this.hotelImage = hotelImage;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public HotelLog() {
    }

    public HotelLog(long id, String hotelName, List<String> hotelImage, String hotelChain, String hotelAddress1, String hotelSuburb, String hotelCity, String hotelProvince, String hotelCountry, String starRating, String propertyType, String locationType, String hotelDescription, String propertyAmenities, Date checkInDate, Date checkOutDate, List<RoomLog> roomLog) {
        this.id = id;
        this.hotelName = hotelName;
        this.hotelImage = hotelImage;
        this.hotelChain = hotelChain;
        this.hotelAddress1 = hotelAddress1;
        this.hotelSuburb = hotelSuburb;
        this.hotelCity = hotelCity;
        this.hotelProvince = hotelProvince;
        this.hotelCountry = hotelCountry;
        this.starRating = starRating;
        this.propertyType = propertyType;
        this.locationType = locationType;
        this.hotelDescription = hotelDescription;
        this.propertyAmenities = propertyAmenities;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomLog = roomLog;
    }

}

