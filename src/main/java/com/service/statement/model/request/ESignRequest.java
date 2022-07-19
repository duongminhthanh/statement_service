package com.service.statement.model.request;

public class ESignRequest {
    private String personalName;
    private String email;
    private String telephoneNumber;
    private String personalID;
    private String signImage;

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
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

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public String getSignImage() {
        return signImage;
    }

    public void setSignImage(String signImage) {
        this.signImage = signImage;
    }
}
