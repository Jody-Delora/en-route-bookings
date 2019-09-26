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
public class PrimaryContactDetails {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="contact_id")
private long id;  

@Column(nullable=false)
private String contactName;
@Column(name="person_is_travelling")
private Boolean personIsTravelling;
@Column(nullable = false)
private String email;
@Column(nullable = false)
private String cellPhone;
private String homePhone;
private String workPhone;
@Column(nullable = false)
private String address1;
private String address2;
private String address3;
@Column(nullable = false)
private String cityOrTown;
@Column(nullable = false)
private String province;
@Column(nullable = false)
private String postalCode;
@Column(nullable = false)
private String country;
private String saIdNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getPersonIsTravelling() {
        return personIsTravelling;
    }

    public void setPersonIsTravelling(Boolean personIsTravelling) {
        this.personIsTravelling = personIsTravelling;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public void setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaIdNo() {
        return saIdNo;
    }

    public void setSaIdNo(String saIdNo) {
        this.saIdNo = saIdNo;
    }


    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public PrimaryContactDetails() {
    }

    public PrimaryContactDetails(long id, String contactName, Boolean personIsTravelling, String email, String cellPhone, String homePhone, String workPhone, String address1, String address2, String address3, String cityOrTown, String province, String postalCode, String country, String saIdNo) {
        this.id = id;
    
        this.contactName = contactName;
        this.personIsTravelling = personIsTravelling;
        this.email = email;
        this.cellPhone = cellPhone;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.cityOrTown = cityOrTown;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
        this.saIdNo = saIdNo;
    }

}
