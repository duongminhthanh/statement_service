//package com.service.statement.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import com.service.statement.model.dto.AgreementDetails;
//import com.service.statement.model.dto.ESignApplication;
//import com.service.statement.model.dto.SignCloudReq;
//import com.service.statement.model.request.ESignRequest;
//import com.service.statement.model.response.ESignResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.lang.Nullable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.service.statement.constant.APIConstant;
//import com.service.statement.model.BankStatement;
//import com.service.statement.service.IReportService;
//
//@RestController
//@RequestMapping(value = APIConstant.API_REPORT)
//public class ReportManagementController {
//    @Autowired
//    private IReportService reportService;
//
//    @PostMapping(value = "/exportBankStatement", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    public ResponseEntity<InputStreamResource> exportBankStatementList(@RequestBody BankStatement bankStatement) {
//        try {
//            File file = reportService.exportBankStatement(bankStatement);
//            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//            return ResponseEntity.ok()
//                    .headers(new HttpHeaders())
//                    .contentLength(file.length())
//                    .contentType(MediaType.parseMediaType("application/pdf"))
//                    .body(resource);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
////            throw new Exception("Lỗi xuất hợp đồng");
//            return null;
//        }
//    }
//
//    @PostMapping(value = "/prepareCertificateForSignCloud", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ESignResponse> prepareCertificateForSignCloud(@Nullable @RequestPart("signFile") MultipartFile signFile, @Nullable @RequestPart("signImage") MultipartFile signImage, @RequestPart("info") ESignRequest eSignRequest) throws IOException {
//        return  new ResponseEntity<>(reportService.prepareCertificateForSignCloud(signFile, signImage, eSignRequest), HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/authorizeCounterSigningForSignCloud", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<InputStreamResource> authorizeCounterSigningForSignCloud(@RequestBody SignCloudReq signCloudReq) throws IOException {
//        try {
//            File file = reportService.authorizeCounterSigningForSignCloud(signCloudReq);
//
//            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//            return ResponseEntity.ok()
//                    .headers(new HttpHeaders())
//                    .contentLength(file.length())
//                    .contentType(MediaType.parseMediaType("application/pdf"))
//                    .body(resource);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
////            throw new Exception("Lỗi xuất hợp đồng");
//            return null;
//        }
//    }
//
//    @PostMapping(value = "/signBankStatement", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    public ResponseEntity<InputStreamResource> signBankStatement(@Nullable @RequestPart("file") MultipartFile file, @RequestPart("info") BankStatement bankStatement) throws IOException {
//        try {
//            File file2 = reportService.signBankStatement(file, bankStatement);
//
//            InputStreamResource resource = new InputStreamResource(new FileInputStream(file2));
//            return ResponseEntity.ok()
//                    .headers(new HttpHeaders())
//                    .contentLength(file2.length())
//                    .contentType(MediaType.parseMediaType("application/pdf"))
//                    .body(resource);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
////            throw new Exception("Lỗi xuất hợp đồng");
//            return null;
//        }
//    }
//}
