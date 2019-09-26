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
public class Branch {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="branch_id")
private long id;
@Column(nullable=false)
private String branchAddress1;
@Column(nullable=false)
private String branchSuburb;
@Column(nullable=false)
private String branchCity;
@Column(nullable=false)
private String branchProvince;
@Column(nullable=false)
private String branchTel;
private String branchFax;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBranchAddress1() {
        return branchAddress1;
    }

    public void setBranchAddress1(String branchAddress1) {
        this.branchAddress1 = branchAddress1;
    }

    public String getBranchSuburb() {
        return branchSuburb;
    }

    public void setBranchSuburb(String branchSuburb) {
        this.branchSuburb = branchSuburb;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public String getBranchProvince() {
        return branchProvince;
    }

    public void setBranchProvince(String branchProvince) {
        this.branchProvince = branchProvince;
    }

    public String getBranchTel() {
        return branchTel;
    }

    public void setBranchTel(String branchTel) {
        this.branchTel = branchTel;
    }

    public String getBranchFax() {
        return branchFax;
    }

    public void setBranchFax(String branchFax) {
        this.branchFax = branchFax;
    }
    public Branch() {
    }
    
}
