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
public class Car {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="car_id")
  private long id;
  private String carImage;
  @Column(nullable = false)
  private String transmission;
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
  
   @OneToOne(cascade=CascadeType.ALL) 
   private CarSupplier carSupplier;
   
    @OneToMany(cascade=CascadeType.ALL)
    private List<CarWaiverDetails> carWaiverDetails;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<CarExtra> carExtra;

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<CarWaiverDetails> getCarWaiverDetails() {
        return carWaiverDetails;
    }

    public void setCarWaiverDetails(List<CarWaiverDetails> carWaiverDetails) {
        this.carWaiverDetails = carWaiverDetails;
    }

  
    public List<CarExtra> getCarExtra() {
        return carExtra;
    }

    public void setCarExtra(List<CarExtra> carExtra) {
        this.carExtra = carExtra;
    }

    public Car() {
    }

    public CarSupplier getCarSupplier() {
        return carSupplier;
    }

    public void setCarSupplier(CarSupplier carSupplier) {
        this.carSupplier = carSupplier;
    }

    public Car(long id, String carImage, String transmission, int doorCount, String airConditioning, String vehicleCategory, String vehicleClassSize, String vehicleMakeAndModel, int passengerCapacity, List<CarWaiverDetails> carWaiverDetails, List<CarExtra> carExtra) {
        this.id = id;
        this.carImage = carImage;
        this.transmission = transmission;
        this.doorCount = doorCount;
        this.airConditioning = airConditioning;
        this.vehicleCategory = vehicleCategory;
        this.vehicleClassSize = vehicleClassSize;
        this.vehicleMakeAndModel = vehicleMakeAndModel;
        this.passengerCapacity = passengerCapacity;
        this.carWaiverDetails = carWaiverDetails;
        this.carExtra = carExtra;
    }

    
}
