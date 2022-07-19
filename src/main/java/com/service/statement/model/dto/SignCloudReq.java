package com.service.statement.model.dto;

import java.util.List;

public class SignCloudReq {
    private String relyingParty;
    private String relyingPartyBillCode;
    private String agreementUUID;
    private String sharedAgreementUUID;
    private String sharedRelyingParty;
    private String mobileNo;
    private String email;
    private String certificateProfile;
    private AgreementDetails agreementDetails;
    private CredentialData credentialData;
    private String signingFileUUID;
    private byte[] signingFileData;
    private String signingFileName;
    private String mimeType;
    private String notificationTemplate;
    private String notificationSubject;
    private boolean timestampEnabled;
    private boolean ltvEnabled;
    private String language;
    private String authorizeCode;
    private boolean postbackEnabled;
    private boolean noPadding;
    private int authorizeMethod;
    private byte[] uploadingFileData;
    private String downloadingFileUUID;
    private String currentPasscode;
    private String newPasscode;
    private String hash;
    private String hashAlgorithm;
    private String encryption;
    private String billCode;
    private SignCloudMetaData signCloudMetaData;
    private int messagingMode;
    private int sharedMode;
    private String xslTemplateUUID;
    private String xslTemplate;
    private String xmlDocument;
    private boolean p2pEnabled;
    private boolean csrRequired;
    private boolean certificateRequired;
    private boolean keepOldKeysEnabled;
    private boolean revokeOldCertificateEnabled;
    private String certificate;
//    private List<MultipleSigningFileData> multipleSigningFileData;


    public SignCloudMetaData getSignCloudMetaData() {
        return signCloudMetaData;
    }

    public void setSignCloudMetaData(SignCloudMetaData signCloudMetaData) {
        this.signCloudMetaData = signCloudMetaData;
    }

    public String getRelyingParty() {
        return relyingParty;
    }

    public void setRelyingParty(String relyingParty) {
        this.relyingParty = relyingParty;
    }

    public String getRelyingPartyBillCode() {
        return relyingPartyBillCode;
    }

    public void setRelyingPartyBillCode(String relyingPartyBillCode) {
        this.relyingPartyBillCode = relyingPartyBillCode;
    }

    public String getAgreementUUID() {
        return agreementUUID;
    }

    public void setAgreementUUID(String agreementUUID) {
        this.agreementUUID = agreementUUID;
    }

    public String getSharedAgreementUUID() {
        return sharedAgreementUUID;
    }

    public void setSharedAgreementUUID(String sharedAgreementUUID) {
        this.sharedAgreementUUID = sharedAgreementUUID;
    }

    public String getSharedRelyingParty() {
        return sharedRelyingParty;
    }

    public void setSharedRelyingParty(String sharedRelyingParty) {
        this.sharedRelyingParty = sharedRelyingParty;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCertificateProfile() {
        return certificateProfile;
    }

    public void setCertificateProfile(String certificateProfile) {
        this.certificateProfile = certificateProfile;
    }

    public CredentialData getCredentialData() {
        return credentialData;
    }

    public void setCredentialData(CredentialData credentialData) {
        this.credentialData = credentialData;
    }

    public String getSigningFileUUID() {
        return signingFileUUID;
    }

    public void setSigningFileUUID(String signingFileUUID) {
        this.signingFileUUID = signingFileUUID;
    }

    public byte[] getSigningFileData() {
        return signingFileData;
    }

    public void setSigningFileData(byte[] signingFileData) {
        this.signingFileData = signingFileData;
    }

    public String getSigningFileName() {
        return signingFileName;
    }

    public void setSigningFileName(String signingFileName) {
        this.signingFileName = signingFileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getNotificationTemplate() {
        return notificationTemplate;
    }

    public void setNotificationTemplate(String notificationTemplate) {
        this.notificationTemplate = notificationTemplate;
    }

    public String getNotificationSubject() {
        return notificationSubject;
    }

    public void setNotificationSubject(String notificationSubject) {
        this.notificationSubject = notificationSubject;
    }

    public boolean isTimestampEnabled() {
        return timestampEnabled;
    }

    public void setTimestampEnabled(boolean timestampEnabled) {
        this.timestampEnabled = timestampEnabled;
    }

    public boolean isLtvEnabled() {
        return ltvEnabled;
    }

    public void setLtvEnabled(boolean ltvEnabled) {
        this.ltvEnabled = ltvEnabled;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthorizeCode() {
        return authorizeCode;
    }

    public void setAuthorizeCode(String authorizeCode) {
        this.authorizeCode = authorizeCode;
    }

    public boolean isPostbackEnabled() {
        return postbackEnabled;
    }

    public void setPostbackEnabled(boolean postbackEnabled) {
        this.postbackEnabled = postbackEnabled;
    }

    public boolean isNoPadding() {
        return noPadding;
    }

    public void setNoPadding(boolean noPadding) {
        this.noPadding = noPadding;
    }

    public int getAuthorizeMethod() {
        return authorizeMethod;
    }

    public void setAuthorizeMethod(int authorizeMethod) {
        this.authorizeMethod = authorizeMethod;
    }

    public byte[] getUploadingFileData() {
        return uploadingFileData;
    }

    public void setUploadingFileData(byte[] uploadingFileData) {
        this.uploadingFileData = uploadingFileData;
    }

    public String getDownloadingFileUUID() {
        return downloadingFileUUID;
    }

    public void setDownloadingFileUUID(String downloadingFileUUID) {
        this.downloadingFileUUID = downloadingFileUUID;
    }

    public String getCurrentPasscode() {
        return currentPasscode;
    }

    public void setCurrentPasscode(String currentPasscode) {
        this.currentPasscode = currentPasscode;
    }

    public String getNewPasscode() {
        return newPasscode;
    }

    public void setNewPasscode(String newPasscode) {
        this.newPasscode = newPasscode;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHashAlgorithm() {
        return hashAlgorithm;
    }

    public void setHashAlgorithm(String hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public int getMessagingMode() {
        return messagingMode;
    }

    public void setMessagingMode(int messagingMode) {
        this.messagingMode = messagingMode;
    }

    public int getSharedMode() {
        return sharedMode;
    }

    public void setSharedMode(int sharedMode) {
        this.sharedMode = sharedMode;
    }

    public String getXslTemplateUUID() {
        return xslTemplateUUID;
    }

    public void setXslTemplateUUID(String xslTemplateUUID) {
        this.xslTemplateUUID = xslTemplateUUID;
    }

    public String getXslTemplate() {
        return xslTemplate;
    }

    public void setXslTemplate(String xslTemplate) {
        this.xslTemplate = xslTemplate;
    }

    public String getXmlDocument() {
        return xmlDocument;
    }

    public void setXmlDocument(String xmlDocument) {
        this.xmlDocument = xmlDocument;
    }

    public boolean isP2pEnabled() {
        return p2pEnabled;
    }

    public void setP2pEnabled(boolean p2pEnabled) {
        this.p2pEnabled = p2pEnabled;
    }

    public boolean isCsrRequired() {
        return csrRequired;
    }

    public void setCsrRequired(boolean csrRequired) {
        this.csrRequired = csrRequired;
    }

    public boolean isCertificateRequired() {
        return certificateRequired;
    }

    public void setCertificateRequired(boolean certificateRequired) {
        this.certificateRequired = certificateRequired;
    }

    public boolean isKeepOldKeysEnabled() {
        return keepOldKeysEnabled;
    }

    public void setKeepOldKeysEnabled(boolean keepOldKeysEnabled) {
        this.keepOldKeysEnabled = keepOldKeysEnabled;
    }

    public boolean isRevokeOldCertificateEnabled() {
        return revokeOldCertificateEnabled;
    }

    public void setRevokeOldCertificateEnabled(boolean revokeOldCertificateEnabled) {
        this.revokeOldCertificateEnabled = revokeOldCertificateEnabled;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public AgreementDetails getAgreementDetails() {
        return agreementDetails;
    }

    public void setAgreementDetails(AgreementDetails agreementDetails) {
        this.agreementDetails = agreementDetails;
    }
}
