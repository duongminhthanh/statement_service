package com.service.statement.service;

import java.io.File;
import java.io.IOException;

import com.service.statement.model.dto.AgreementDetails;
import com.service.statement.model.dto.ESignApplication;
import com.service.statement.model.dto.SignCloudReq;
import com.service.statement.model.request.ESignRequest;
import com.service.statement.model.response.ESignResponse;
import org.springframework.web.multipart.MultipartFile;

import com.service.statement.model.BankStatement;

public interface IReportService {
    File exportBankStatement(BankStatement bankStatement);

    ESignResponse prepareCertificateForSignCloud(MultipartFile signFile, MultipartFile signImage, ESignRequest eSignRequest);

    File authorizeCounterSigningForSignCloud(SignCloudReq signCloudReq);

    File signBankStatement(MultipartFile file, BankStatement bankStatement) throws IOException;
}
