package org.yurovnik.germes.app.model.entity.geography;

/**
 * Value type that stores address attributes
 * of the specific office or person
 * @author YurovnikMV
 *
 */

public class Address {
    private String zipCode;

    private String Street;

    private String houseNo;

    /**
     * (Optional) Apartment if it's address
     * of the apartment;
     */
    private String apartment;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
