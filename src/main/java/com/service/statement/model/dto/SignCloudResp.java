package com.service.statement.model.dto;

import java.util.Date;
import java.util.List;

public class SignCloudResp {
    private int responseCode;
    private String responseMessage;
    private String billCode;
    private Date timestamp;
    private int logInstance;
    private String notificationMessage;
    private int remainingCounter;
    private byte[] signedFileData;
    private String signedFileName;
    private String authorizeCredential;
    private String signedFileUUID;
    private String mimeType;
    private String certificateDN;
    private String certificateSerialNumber;
    private String certificateThumbprint;
    private Date validFrom;
    private Date validTo;
    private String issuerDN;
    private String uploadedFileUUID;
    private String downloadedFileUUID;
    private byte[] downloadedFileData;
    private String signatureValue;
    private int authorizeMethod;
    private String notificationSubject;
    private String dmsMetaData;
    private String csr;
    private String certificate;
    private int certificateStateID;
//    private List<MultipleSignedFileData> multipleSignedFileData;


    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getLogInstance() {
        return logInstance;
    }

    public void setLogInstance(int logInstance) {
        this.logInstance = logInstance;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public int getRemainingCounter() {
        return remainingCounter;
    }

    public void setRemainingCounter(int remainingCounter) {
        this.remainingCounter = remainingCounter;
    }

    public byte[] getSignedFileData() {
        return signedFileData;
    }

    public void setSignedFileData(byte[] signedFileData) {
        this.signedFileData = signedFileData;
    }

    public String getSignedFileName() {
        return signedFileName;
    }

    public void setSignedFileName(String signedFileName) {
        this.signedFileName = signedFileName;
    }

    public String getAuthorizeCredential() {
        return authorizeCredential;
    }

    public void setAuthorizeCredential(String authorizeCredential) {
        this.authorizeCredential = authorizeCredential;
    }

    public String getSignedFileUUID() {
        return signedFileUUID;
    }

    public void setSignedFileUUID(String signedFileUUID) {
        this.signedFileUUID = signedFileUUID;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getCertificateDN() {
        return certificateDN;
    }

    public void setCertificateDN(String certificateDN) {
        this.certificateDN = certificateDN;
    }

    public String getCertificateSerialNumber() {
        return certificateSerialNumber;
    }

    public void setCertificateSerialNumber(String certificateSerialNumber) {
        this.certificateSerialNumber = certificateSerialNumber;
    }

    public String getCertificateThumbprint() {
        return certificateThumbprint;
    }

    public void setCertificateThumbprint(String certificateThumbprint) {
        this.certificateThumbprint = certificateThumbprint;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getIssuerDN() {
        return issuerDN;
    }

    public void setIssuerDN(String issuerDN) {
        this.issuerDN = issuerDN;
    }

    public String getUploadedFileUUID() {
        return uploadedFileUUID;
    }

    public void setUploadedFileUUID(String uploadedFileUUID) {
        this.uploadedFileUUID = uploadedFileUUID;
    }

    public String getDownloadedFileUUID() {
        return downloadedFileUUID;
    }

    public void setDownloadedFileUUID(String downloadedFileUUID) {
        this.downloadedFileUUID = downloadedFileUUID;
    }

    public byte[] getDownloadedFileData() {
        return downloadedFileData;
    }

    public void setDownloadedFileData(byte[] downloadedFileData) {
        this.downloadedFileData = downloadedFileData;
    }

    public String getSignatureValue() {
        return signatureValue;
    }

    public void setSignatureValue(String signatureValue) {
        this.signatureValue = signatureValue;
    }

    public int getAuthorizeMethod() {
        return authorizeMethod;
    }

    public void setAuthorizeMethod(int authorizeMethod) {
        this.authorizeMethod = authorizeMethod;
    }

    public String getNotificationSubject() {
        return notificationSubject;
    }

    public void setNotificationSubject(String notificationSubject) {
        this.notificationSubject = notificationSubject;
    }

    public String getDmsMetaData() {
        return dmsMetaData;
    }

    public void setDmsMetaData(String dmsMetaData) {
        this.dmsMetaData = dmsMetaData;
    }

    public String getCsr() {
        return csr;
    }

    public void setCsr(String csr) {
        this.csr = csr;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public int getCertificateStateID() {
        return certificateStateID;
    }

    public void setCertificateStateID(int certificateStateID) {
        this.certificateStateID = certificateStateID;
    }
}
