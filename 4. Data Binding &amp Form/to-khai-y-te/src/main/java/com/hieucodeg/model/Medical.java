package com.hieucodeg.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Medical {
    private String name;
    private Integer yearOfBirth;
    private String gender;
    private String country;
    private Long passport;
    private String tranfer;
    private Integer numberTranfer;
    private Integer numberChair;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate departureDay;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDay;
    private String provinceVisit;
    private String province;
    private String district;
    private String town;
    private String address;
    private Integer phoneNumber;
    private String Email;
    private boolean fever;
    private boolean cough;
    private boolean shortnessOfBreath;
    private boolean soreThroat;
    private boolean vomit;
    private boolean diarrhea;
    private boolean hemorrhage;
    private boolean rash;
    private boolean animalContact;
    private boolean animalPatient;



    public Medical() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPassport() {
        return passport;
    }

    public void setPassport(Long passport) {
        this.passport = passport;
    }

    public String getTranfer() {
        return tranfer;
    }

    public void setTranfer(String tranfer) {
        this.tranfer = tranfer;
    }

    public Integer getNumberTranfer() {
        return numberTranfer;
    }

    public void setNumberTranfer(Integer numberTranfer) {
        this.numberTranfer = numberTranfer;
    }

    public Integer getNumberChair() {
        return numberChair;
    }

    public void setNumberChair(Integer numberChair) {
        this.numberChair = numberChair;
    }

    public LocalDate getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(LocalDate departureDay) {
        this.departureDay = departureDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public String getProvinceVisit() {
        return provinceVisit;
    }

    public void setProvinceVisit(String provinceVisit) {
        this.provinceVisit = provinceVisit;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isShortnessOfBreath() {
        return shortnessOfBreath;
    }

    public void setShortnessOfBreath(boolean shortnessOfBreath) {
        this.shortnessOfBreath = shortnessOfBreath;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isVomit() {
        return vomit;
    }

    public void setVomit(boolean vomit) {
        this.vomit = vomit;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isHemorrhage() {
        return hemorrhage;
    }

    public void setHemorrhage(boolean hemorrhage) {
        this.hemorrhage = hemorrhage;
    }

    public boolean isRash() {
        return rash;
    }

    public void setRash(boolean rash) {
        this.rash = rash;
    }

    public boolean isAnimalContact() {
        return animalContact;
    }

    public void setAnimalContact(boolean animalContact) {
        this.animalContact = animalContact;
    }

    public boolean isAnimalPatient() {
        return animalPatient;
    }

    public void setAnimalPatient(boolean animalPatient) {
        this.animalPatient = animalPatient;
    }
}
