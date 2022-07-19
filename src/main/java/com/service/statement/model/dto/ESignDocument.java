package com.service.statement.model.dto;

import java.util.Set;

public class ESignDocument {
    private int id;
    //private int agreementUUID;
    private String fileName;
    private String filePath;
    private String mimeType;
    private String documentType;
    private String signedFilePath;

    private ESignApplication eSignApplication;

    private byte[] fileData;

    private Set<ESignDocProperties> eSignDocProperties;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getSignedFilePath() {
        return signedFilePath;
    }

    public void setSignedFilePath(String signedFilePath) {
        this.signedFilePath = signedFilePath;
    }

    public ESignApplication geteSignApplication() {
        return eSignApplication;
    }

    public void seteSignApplication(ESignApplication eSignApplication) {
        this.eSignApplication = eSignApplication;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public Set<ESignDocProperties> geteSignDocProperties() {
        return eSignDocProperties;
    }

    public void seteSignDocProperties(Set<ESignDocProperties> eSignDocProperties) {
        this.eSignDocProperties = eSignDocProperties;
    }
}
