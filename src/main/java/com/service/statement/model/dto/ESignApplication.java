package com.service.statement.model.dto;

import java.util.Date;
import java.util.Set;

public class ESignApplication {
    private int id;
    private String agreementUUID;
    public String personalID;
    public String personalName;
    public String location;
    public String stateProvince;
    public String country;
    public String authorizationEmail;
    public String authorizationMobileNo;

    private Set<ESignDocument> eSignDocuments;

    private String username;
    private Date createDate;
    private String status;
    private int otptimesregen;
    private int otptimesauth;
    private String billcode;
    private String callbackurl;
    private String photoidcardPath;
    public String legalRepresentative;
    public String legalTitle;
    public String gender;
    public String dateOfBirth;
    public String currentSubDistrict;
    public String currentLocation;
    public String currentStateProvince;
    public String occupation;
    public String title;
    public String issueDate;
    public String issuePlace;
    public String subDistrict;
    public String address;
    public String currentAddress;
    public String taxCode;

    private JwtRequest jwtRequest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgreementUUID() {
        return agreementUUID;
    }

    public void setAgreementUUID(String agreementUUID) {
        this.agreementUUID = agreementUUID;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAuthorizationEmail() {
        return authorizationEmail;
    }

    public void setAuthorizationEmail(String authorizationEmail) {
        this.authorizationEmail = authorizationEmail;
    }

    public String getAuthorizationMobileNo() {
        return authorizationMobileNo;
    }

    public void setAuthorizationMobileNo(String authorizationMobileNo) {
        this.authorizationMobileNo = authorizationMobileNo;
    }

    public Set<ESignDocument> geteSignDocuments() {
        return eSignDocuments;
    }

    public void seteSignDocuments(Set<ESignDocument> eSignDocuments) {
        this.eSignDocuments = eSignDocuments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOtptimesregen() {
        return otptimesregen;
    }

    public void setOtptimesregen(int otptimesregen) {
        this.otptimesregen = otptimesregen;
    }

    public int getOtptimesauth() {
        return otptimesauth;
    }

    public void setOtptimesauth(int otptimesauth) {
        this.otptimesauth = otptimesauth;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public String getCallbackurl() {
        return callbackurl;
    }

    public void setCallbackurl(String callbackurl) {
        this.callbackurl = callbackurl;
    }

    public String getPhotoidcardPath() {
        return photoidcardPath;
    }

    public void setPhotoidcardPath(String photoidcardPath) {
        this.photoidcardPath = photoidcardPath;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getLegalTitle() {
        return legalTitle;
    }

    public void setLegalTitle(String legalTitle) {
        this.legalTitle = legalTitle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCurrentSubDistrict() {
        return currentSubDistrict;
    }

    public void setCurrentSubDistrict(String currentSubDistrict) {
        this.currentSubDistrict = currentSubDistrict;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getCurrentStateProvince() {
        return currentStateProvince;
    }

    public void setCurrentStateProvince(String currentStateProvince) {
        this.currentStateProvince = currentStateProvince;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public JwtRequest getJwtRequest() {
        return jwtRequest;
    }

    public void setJwtRequest(JwtRequest jwtRequest) {
        this.jwtRequest = jwtRequest;
    }
}
