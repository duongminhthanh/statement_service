package com.service.statement.model.dto;

public class AgreementDetails {
    private String personalName;
    private String organization;
    private String organizationUnit;
    private String title;
    private String email;
    private String telephoneNumber;
    private String location;
    private String stateOrProvince;
    private String country;
    private String personalID;
    private String passportID;
    private String taxID;
    private String budgetID;

    private byte[] applicationForm;
    private byte[] requestForm;
    private byte[] authorizeLetter;
    private byte[] photoIDCard;
    private byte[] photoActivityDeclaration;
    private byte[] photoAuthorizeDelegate;

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(String organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public String getBudgetID() {
        return budgetID;
    }

    public void setBudgetID(String budgetID) {
        this.budgetID = budgetID;
    }

    public byte[] getApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(byte[] applicationForm) {
        this.applicationForm = applicationForm;
    }

    public byte[] getRequestForm() {
        return requestForm;
    }

    public void setRequestForm(byte[] requestForm) {
        this.requestForm = requestForm;
    }

    public byte[] getAuthorizeLetter() {
        return authorizeLetter;
    }

    public void setAuthorizeLetter(byte[] authorizeLetter) {
        this.authorizeLetter = authorizeLetter;
    }

    public byte[] getPhotoIDCard() {
        return photoIDCard;
    }

    public void setPhotoIDCard(byte[] photoIDCard) {
        this.photoIDCard = photoIDCard;
    }

    public byte[] getPhotoActivityDeclaration() {
        return photoActivityDeclaration;
    }

    public void setPhotoActivityDeclaration(byte[] photoActivityDeclaration) {
        this.photoActivityDeclaration = photoActivityDeclaration;
    }

    public byte[] getPhotoAuthorizeDelegate() {
        return photoAuthorizeDelegate;
    }

    public void setPhotoAuthorizeDelegate(byte[] photoAuthorizeDelegate) {
        this.photoAuthorizeDelegate = photoAuthorizeDelegate;
    }
}
