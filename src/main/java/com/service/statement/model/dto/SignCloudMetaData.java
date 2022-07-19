package com.service.statement.model.dto;

import java.util.HashMap;

public class SignCloudMetaData {
    private HashMap<String, String> singletonSigning;
    private HashMap<String, String> counterSigning;

    public HashMap<String, String> getSingletonSigning() {
        return singletonSigning;
    }

    public void setSingletonSigning(HashMap<String, String> singletonSigning) {
        this.singletonSigning = singletonSigning;
    }

    public HashMap<String, String> getCounterSigning() {
        return counterSigning;
    }

    public void setCounterSigning(HashMap<String, String> counterSigning) {
        this.counterSigning = counterSigning;
    }
}
