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
public class CarHireLog {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="car_hire_log_id")
    private long id;
    @Column(nullable = false)
    private String transmission;
    private String carImage;
    @Column(nullable = false)
    private int doorCount;
    @Column(nullable = false)
    private String airConditioning;
    @Column(nullable = false)
    private String vehicleCategory;
    @Column(nullable = false)
    private String vehicleClassSize;
    @Column(nullable = false)
    private String vehicleMakeAndModel;
    @Column(nullable = false)
    private int passengerCapacity;    
    private String dropOffAddress1;
    private String dropOffSuburb;
    private String dropOffCity;
    private String dropOffProvince;
    private Date dropOffDate;
    private Time dropOffTime;
    private String dropOffTel;   
    private String pickUpAddress1;
    private String pickUpSuburb;
    private String pickUpCity;
    private String pickUpProvince;
    private Date pickUpDate;
    private Time pickUpTime;
    private String pickUpTel;
    private double waiverAdminFee;
    @Column(nullable = false)
    private double waiverDepositFee;
    @Column(nullable = false)
    private double waiverExcessFee;
    @Column(nullable = false,length = 1000)
    private String waiverDescription;
    @Column(nullable = false,length = 1000)
    private String waiverExcludeDescription;
    @Column(nullable = false,length = 1000)
    private String waiverIncludeDescription;
    @Column(nullable = false)
    private String waiverType;
    @Column(nullable = false)
    private double waiverPrice;
    private double extraTotal;
    private double grandTotal;
    private String carSupplierName;
    private String carSupplierLogo;
    
    @OneToOne(cascade = CascadeType.ALL)
    private DriverDetails driverDetails;

    @OneToMany(cascade=CascadeType.ALL)
    private List<CarExtraLog> carExtraLog;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public Time getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(Time dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Time getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Time pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getDropOffSuburb() {
        return dropOffSuburb;
    }

    public void setDropOffSuburb(String dropOffSuburb) {
        this.dropOffSuburb = dropOffSuburb;
    }

    public String getPickUpSuburb() {
        return pickUpSuburb;
    }

    public void setPickUpSuburb(String pickUpSuburb) {
        this.pickUpSuburb = pickUpSuburb;
    }

    public DriverDetails getDriverDetails() {
        return driverDetails;
    }

    public void setDriverDetails(DriverDetails driverDetails) {
        this.driverDetails = driverDetails;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public String getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(String airConditioning) {
        this.airConditioning = airConditioning;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getVehicleClassSize() {
        return vehicleClassSize;
    }

    public void setVehicleClassSize(String vehicleClassSize) {
        this.vehicleClassSize = vehicleClassSize;
    }

    public String getVehicleMakeAndModel() {
        return vehicleMakeAndModel;
    }

    public void setVehicleMakeAndModel(String vehicleMakeAndModel) {
        this.vehicleMakeAndModel = vehicleMakeAndModel;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public List<CarExtraLog> getCarExtraLog() {
        return carExtraLog;
    }

    public void setCarExtraLog(List<CarExtraLog> carExtraLog) {
        this.carExtraLog = carExtraLog;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public double getWaiverAdminFee() {
        return waiverAdminFee;
    }

    public void setWaiverAdminFee(double waiverAdminFee) {
        this.waiverAdminFee = waiverAdminFee;
    }

    public double getWaiverDepositFee() {
        return waiverDepositFee;
    }

    public void setWaiverDepositFee(double waiverDepositFee) {
        this.waiverDepositFee = waiverDepositFee;
    }

    public double getWaiverExcessFee() {
        return waiverExcessFee;
    }

    public void setWaiverExcessFee(double waiverExcessFee) {
        this.waiverExcessFee = waiverExcessFee;
    }

    public String getWaiverDescription() {
        return waiverDescription;
    }

    public void setWaiverDescription(String waiverDescription) {
        this.waiverDescription = waiverDescription;
    }

    public String getWaiverExcludeDescription() {
        return waiverExcludeDescription;
    }

    public void setWaiverExcludeDescription(String waiverExcludeDescription) {
        this.waiverExcludeDescription = waiverExcludeDescription;
    }

    public String getWaiverIncludeDescription() {
        return waiverIncludeDescription;
    }

    public void setWaiverIncludeDescription(String waiverIncludeDescription) {
        this.waiverIncludeDescription = waiverIncludeDescription;
    }

    public String getWaiverType() {
        return waiverType;
    }

    public void setWaiverType(String waiverType) {
        this.waiverType = waiverType;
    }

    public double getWaiverPrice() {
        return waiverPrice;
    }

    public void setWaiverPrice(double waiverPrice) {
        this.waiverPrice = waiverPrice;
    }

    public String getCarSupplierName() {
        return carSupplierName;
    }

    public void setCarSupplierName(String carSupplierName) {
        this.carSupplierName = carSupplierName;
    }

    public String getCarSupplierLogo() {
        return carSupplierLogo;
    }

    public void setCarSupplierLogo(String carSupplierLogo) {
        this.carSupplierLogo = carSupplierLogo;
    }

    public String getDropOffAddress1() {
        return dropOffAddress1;
    }

    public void setDropOffAddress1(String dropOffAddress1) {
        this.dropOffAddress1 = dropOffAddress1;
    }

    public String getDropOffCity() {
        return dropOffCity;
    }

    public void setDropOffCity(String dropOffCity) {
        this.dropOffCity = dropOffCity;
    }

    public String getDropOffProvince() {
        return dropOffProvince;
    }

    public void setDropOffProvince(String dropOffProvince) {
        this.dropOffProvince = dropOffProvince;
    }

    public String getDropOffTel() {
        return dropOffTel;
    }

    public void setDropOffTel(String dropOffTel) {
        this.dropOffTel = dropOffTel;
    }

    public String getPickUpAddress1() {
        return pickUpAddress1;
    }

    public void setPickUpAddress1(String pickUpAddress1) {
        this.pickUpAddress1 = pickUpAddress1;
    }

    public String getPickUpCity() {
        return pickUpCity;
    }

    public void setPickUpCity(String pickUpCity) {
        this.pickUpCity = pickUpCity;
    }

    public String getPickUpProvince() {
        return pickUpProvince;
    }

    public void setPickUpProvince(String pickUpProvince) {
        this.pickUpProvince = pickUpProvince;
    }

    public String getPickUpTel() {
        return pickUpTel;
    }

    public void setPickUpTel(String pickUpTel) {
        this.pickUpTel = pickUpTel;
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

    public CarHireLog() {
    }

    public CarHireLog(long id, String transmission, String carImage, int doorCount, String airConditioning, String vehicleCategory, String vehicleClassSize, String vehicleMakeAndModel, int passengerCapacity, String dropOffAddress1, String dropOffSuburb, String dropOffCity, String dropOffProvince, Date dropOffDate, Time dropOffTime, String dropOffTel, String pickUpAddress1, String pickUpSuburb, String pickUpCity, String pickUpProvince, Date pickUpDate, Time pickUpTime, String pickUpTel, double waiverAdminFee, double waiverDepositFee, double waiverExcessFee, String waiverDescription, String waiverExcludeDescription, String waiverIncludeDescription, String waiverType, double waiverPrice, double extraTotal, double grandTotal, String carSupplierName, String carSupplierLogo, DriverDetails driverDetails, List<CarExtraLog> carExtraLog) {
        this.id = id;
        this.transmission = transmission;
        this.carImage = carImage;
        this.doorCount = doorCount;
        this.airConditioning = airConditioning;
        this.vehicleCategory = vehicleCategory;
        this.vehicleClassSize = vehicleClassSize;
        this.vehicleMakeAndModel = vehicleMakeAndModel;
        this.passengerCapacity = passengerCapacity;
        this.dropOffAddress1 = dropOffAddress1;
        this.dropOffSuburb = dropOffSuburb;
        this.dropOffCity = dropOffCity;
        this.dropOffProvince = dropOffProvince;
        this.dropOffDate = dropOffDate;
        this.dropOffTime = dropOffTime;
        this.dropOffTel = dropOffTel;
        this.pickUpAddress1 = pickUpAddress1;
        this.pickUpSuburb = pickUpSuburb;
        this.pickUpCity = pickUpCity;
        this.pickUpProvince = pickUpProvince;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpTel = pickUpTel;
        this.waiverAdminFee = waiverAdminFee;
        this.waiverDepositFee = waiverDepositFee;
        this.waiverExcessFee = waiverExcessFee;
        this.waiverDescription = waiverDescription;
        this.waiverExcludeDescription = waiverExcludeDescription;
        this.waiverIncludeDescription = waiverIncludeDescription;
        this.waiverType = waiverType;
        this.waiverPrice = waiverPrice;
        this.extraTotal = extraTotal;
        this.grandTotal = grandTotal;
        this.carSupplierName = carSupplierName;
        this.carSupplierLogo = carSupplierLogo;
        this.driverDetails = driverDetails;
        this.carExtraLog = carExtraLog;
    }
}
