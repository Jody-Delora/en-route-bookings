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
public class CarSupplier {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="car_supplier_id")
private long id;
@Column(nullable=false)
private String carSupplierName;
private String carSupplierLogo;
@OneToMany(cascade=CascadeType.ALL)
private List<Branch> branch; 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarSupplierName() {
        return carSupplierName;
    }

    public void setCarSupplierName(String carSupplierName) {
        this.carSupplierName = carSupplierName;
    }

    public List<Branch> getBranch() {
        return branch;
    }

    public void setBranch(List<Branch> branch) {
        this.branch = branch;
    }

    public String getCarSupplierLogo() {
        return carSupplierLogo;
    }

    public void setCarSupplierLogo(String carSupplierLogo) {
        this.carSupplierLogo = carSupplierLogo;
    }

    public CarSupplier() {
    }

    public CarSupplier(long id, String carSupplierName, String carSupplierLogo, List<Branch> branch) {
        this.id = id;
        this.carSupplierName = carSupplierName;
        this.carSupplierLogo = carSupplierLogo;
        this.branch = branch;
    }

}
