//package com.service.statement.service.impl;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
//import com.lowagie.text.pdf.PdfDocument;
//import com.lowagie.text.pdf.PdfSignature;
//import com.service.statement.model.BankStatement;
//import com.service.statement.model.dto.*;
//import com.service.statement.model.request.ESignRequest;
//import com.service.statement.model.response.ESignResponse;
//import com.service.statement.service.IReportService;
//import com.service.statement.util.ExportUtil;
//import com.service.statement.util.GenerateUtil;
//import com.spire.pdf.PdfDocument;
//import com.spire.pdf.graphics.PdfImage;
//import com.spire.pdf.graphics.PdfTrueTypeFont;
//import com.spire.pdf.security.GraphicMode;
//import com.spire.pdf.security.PdfCertificate;
//import com.spire.pdf.security.PdfCertificationFlags;
//import com.spire.pdf.security.PdfSignature;
//import org.apache.commons.io.IOUtils;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import javax.net.ssl.*;
//import javax.xml.bind.DatatypeConverter;
//import java.awt.*;
//import java.awt.geom.Point2D;
//import java.awt.geom.Rectangle2D;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.security.*;
//import java.security.cert.X509Certificate;
//import java.util.List;
//import java.util.*;
//
//@Service
//@Transactional
//public class ReportServiceImpl implements IReportService {
//    public static String getPKCS1Signature(String data, String relyingPartyKeyStore, String relyingPartyKeyStorePassword) throws Exception {
//        Security.addProvider(new BouncyCastleProvider());
//        KeyStore keystore = KeyStore.getInstance("PKCS12");
//
//        InputStream is = new FileInputStream(relyingPartyKeyStore);
//        keystore.load(is, relyingPartyKeyStorePassword.toCharArray());
//
//        Enumeration<String> e = keystore.aliases();
//        String aliasName = "";
//        while (e.hasMoreElements()) {
//            aliasName = e.nextElement();
//        }
//        PrivateKey key = (PrivateKey) keystore.getKey(aliasName,
//                relyingPartyKeyStorePassword.toCharArray());
//
//        Signature sig = Signature.getInstance("SHA1withRSA");
//        sig.initSign(key);
//        sig.update(data.getBytes());
//        return DatatypeConverter.printBase64Binary(sig.sign());
//
////        KeyStore keystore = KeyStore.getInstance("PKCS12");
////        InputStream is = new FileInputStream(relyingPartyKeyStore);
////        keystore.load(is, relyingPartyKeyStorePassword.toCharArray());
////        Enumeration<String> e = keystore.aliases();
////        String aliasName = "";
////        PrivateKey key = null;
////        while (e.hasMoreElements()) {
////            aliasName = e.nextElement();
////            key = (PrivateKey) keystore.getKey(aliasName, relyingPartyKeyStorePassword.toCharArray());
////            if(key != null)
////                break;
////        }
////        Signature sig = Signature.getInstance("SHA1withRSA");
////        sig.initSign(key);
////        sig.update("To be signed".getBytes());
////        return DatatypeConverter.printBase64Binary(sig.sign());
//    }
//
//    @Override
//    public File exportBankStatement(BankStatement bankStatement) {
//        File file = null;
//        FileOutputStream fos = null;
//
//        // Fake data table export
//        List<TableDemo> list = new ArrayList<>();
//
//        list.add(new TableDemo("211018", "211018", "/PTVNL0210011XXXX//Local Clearing And Inward Remittance VONG CHAN KHAU 79303008 SACOMBANK-SG THUONG TIN TAN BINH Cty Hoa Thao", "3,510,000", "3,627,337,942"));
//        list.add(new TableDemo("211005", "211005", "/PTVNL0210011XXXX//Local Clearing And Inward Remittance TRAN THI YEN NHI 01201004 VIETINBANK-CONG THUONG CN  BA DINH PHI GIA NHAP PHONG THUONG MAI CONG TY TINH HUY", "11,700,000", "3,623,827,942"));
//
//        // multi table(param)
////        List<TableDemo1> list0 = new ArrayList<>();
////        list0.add(new TableDemo1("1", "Con hàng 1", "100$", ""));
////        list0.add(new TableDemo1("2", "Con hàng 2", "100$", ""));
////        list0.add(new TableDemo1("3", "Con hàng 3", "100$", ""));
////        List<TableDemo1> list1 = new ArrayList<>();
////        list1.add(new TableDemo1("7", "Con hàng 7", "100$", "ngon, múp"));
////        list1.add(new TableDemo1("6", "Con hàng 6", "100$", "ngon, múp"));
////        list1.add(new TableDemo1("5", "Con hàng 5", "100$", "ngon, múp"));
//
//
//        // chart(list - line chart)
////        List<ChartDemo> list = new ArrayList<>();
////        list.add(new ChartDemo(1L, "Jan 1", -7.3));
////        list.add(new ChartDemo(2L, "Jan 10", -3.4));
////        list.add(new ChartDemo(3L, "Jan 12", -5.0));
////        list.add(new ChartDemo(4L, "Jan 20", -0.9));
////        list.add(new ChartDemo(5L, "Jan 30", -2.2));
////        list.add(new ChartDemo(6L, "Feb 1", 4.8));
////        list.add(new ChartDemo(7L, "Feb 2", 5.1));
////        list.add(new ChartDemo(9L, "Feb 5", -1.9));
////        list.add(new ChartDemo(10L, "Feb 8", 0));
////        list.add(new ChartDemo(11L, "Feb 12", 2.6));
//
//        try {
//            file = File.createTempFile("out", ".tmp");
//            file.deleteOnExit();
//            fos = new FileOutputStream(file);
//
//            String fileName = "";
//
//            fileName = "bankstatement";
////            fileName = "testmulti";
////            fileName = "testchart";
//
//            String filePath = String.format(Locale.ROOT, "templates/%s.jasper", fileName);
//
//            Resource resource = new ClassPathResource(filePath);
//            InputStream inputStream = resource.getInputStream();
//            Map<String, Object> parameters = new HashMap<>();
//
//            parameters.put("StatementNumber", bankStatement.getStatementNumber());
//            parameters.put("Accno", bankStatement.getAccnoo());
//            parameters.put("Custno", bankStatement.getCustno());
//            parameters.put("FromDate", bankStatement.getFromDate());
//            parameters.put("ToDate", bankStatement.getToDate());
//
//            parameters.put("productName", "VND/CURRE/RECEIPT/CORP");
//            parameters.put("curren", "VND");
//            parameters.put("balan", "3,652,910,977");
//
//
////            BufferedImage image = ImageIO.read(new File("C:\\Users\\tinnt27\\Downloads\\a.jpg"));
////            parameters.put("imageUrl", image);
//
//            // multi
////            parameters.put("datasource1", list0);
////            parameters.put("datasource2", list1);
//
////            parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.FALSE);
////            if ("pdf".equals(exportBankStatement.getExportType()) || "docx".equals(exportBankStatement.getExportType())) {
////                parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.FALSE);
////            } else {
////                parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
////            }
//
//            ExportUtil.exportReport(inputStream, fos, parameters, list, "pdf");
//
////            prepareCertificateForSignCloud();
////            authorizeCounterSigningForSignCloud();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (fos != null) {
//                try {
//                    fos.flush();
//                    fos.close();
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
//        return file;
//    }
//
//    @Override
//    public File signBankStatement(MultipartFile file, BankStatement bankStatement) throws IOException {
//        File fileSign = exportBankStatement(bankStatement);
//        if (fileSign != null) {
//            PdfDocument doc = new PdfDocument();
//            doc.loadFromFile(fileSign.getAbsolutePath());
//            // Load PFX certificate
//            PdfCertificate cert = new PdfCertificate("C:\\Users\\DiNV\\Downloads\\UAT.pfx", "uat");
//
//            // Add a digital signature and set its location and size
//            PdfSignature signature = new PdfSignature(doc, doc.getPages().get(doc.getPages().getCount() - 1), cert, "MySignature");
//            Rectangle2D rect = new Rectangle2D.Float();
//            rect.setFrame(new Point2D.Float((float) doc.getPages().get(0).getActualSize().getWidth() - 250,
//                    (float) doc.getPages().get(0).getActualSize().getHeight() - 150), new Dimension(170, 150));
//            signature.setBounds(rect);
//            // Set signature as picture
//            signature.setGraphicMode(GraphicMode.Sign_Image_Only);
//            signature.setSignImageSource(PdfImage.fromStream(file.getInputStream()));
//            // Set the font for the signature
//            signature.setSignDetailsFont(new PdfTrueTypeFont(new Font("Arial Unicode MS", Font.PLAIN, 11)));
//            // Set document permissions to prohibit changes
//            signature.setDocumentPermissions(PdfCertificationFlags.Forbid_Changes);
//            signature.setCertificated(true);
//            // Save document
//            doc.saveToFile("C:\\Users\\DiNV\\Desktop\\anh\\ImageSignature.pdf");
//            doc.close();
//        }
//
//        return new File("C:\\Users\\DiNV\\Desktop\\anh\\ImageSignature.pdf");
//    }
//
//    @Override
//    public ESignResponse prepareCertificateForSignCloud(MultipartFile signFile, MultipartFile signImage, ESignRequest eSignRequest) {
//        String relyingParty = "UBANK";
//        String agreementUUID = GenerateUtil.generateNumber(12); //"12081999010";
//
//        try {
//            SignCloudReq signCloudReq = new SignCloudReq();
//            signCloudReq.setRelyingParty(relyingParty);
//            signCloudReq.setAgreementUUID(agreementUUID);
//            signCloudReq.setCertificateProfile("PERS.1D");
//            //----------------------- Customer's information -----------------------
//
//            signCloudReq.setEmail(eSignRequest.getEmail());
////            signCloudReq.setMobileNo(agreementDetails.getTelephoneNumber());
//            signCloudReq.setMobileNo("0983987605");
//            //----------------------- AgreementDetails -----------------------
//            AgreementDetails agreementDetails = new AgreementDetails();
//            agreementDetails.setPersonalName(eSignRequest.getPersonalName());
//            agreementDetails.setPersonalID(eSignRequest.getPersonalID());
//            agreementDetails.setEmail(eSignRequest.getEmail());
//            agreementDetails.setLocation("District 7");
//            agreementDetails.setStateOrProvince("HCM City");
//            agreementDetails.setCountry("VN");
//
//            // Photo ID Card
////            byte[] photoData = IOUtils.toByteArray(new FileInputStream("D:\\Bank\\mydoc\\tinnt27.jpg"));
////            agreementDetails.setPhotoIDCard(photoData);
//
//            signCloudReq.setAgreementDetails(agreementDetails);
//            //----------------------- AgreementDetails -----------------------
//            CredentialData credentialData = CreateCredentialData();
//            signCloudReq.setCredentialData(credentialData);
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//            objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
//            String jsonResponse = sendPost("/prepareCertificateForSignCloud", objectMapper.writeValueAsString(signCloudReq));
//            SignCloudResp signCloudResp = objectMapper.readValue(jsonResponse, SignCloudResp.class);
//
//            if (signCloudResp.getResponseCode() == 0) {
////            byte[] fileData = IOUtils.toByteArray(new FileInputStream("D:\\Bank\\mydoc\\UBANK.pdf"));
//                byte[] fileData = IOUtils.toByteArray(signFile.getInputStream());
//
//                SignCloudReq signCloudFileReq = new SignCloudReq();
//                signCloudFileReq.setRelyingParty(relyingParty);
//                signCloudFileReq.setAgreementUUID(agreementUUID);
//                signCloudFileReq.setAuthorizeMethod(1); // Mobile
//                signCloudFileReq.setMessagingMode(1);
//
//                signCloudFileReq.setSigningFileData(fileData);
//                signCloudFileReq.setSigningFileName("UBANK.pdf");
//                signCloudFileReq.setMimeType("application/pdf");
//
//                SignCloudMetaData signCloudMetaData = new SignCloudMetaData();
//                HashMap<String, String> myHashMap = new HashMap<>();
////                if (eSignDocProperties.getCountersignenabled() != null) {
//
////                }
//                myHashMap.put("PAGENO", "Last");
//                myHashMap.put("POSITIONIDENTIFIER", "CHUNG TU DIEN TU, KHONG CAN KY TEN DONG DAU");
//                myHashMap.put("RECTANGLEOFFSET", "10,-100");
//                myHashMap.put("RECTANGLESIZE", "170,70");
//                myHashMap.put("VISIBLESIGNATURE", "True");
//                myHashMap.put("VISUALSTATUS", "False");
//                myHashMap.put("SHADOWSIGNATUREPROPERTIES", "all");
//                myHashMap.put("SHOWSIGNERINFO", "True");
//                myHashMap.put("SIGNERINFOPREFIX", "Ký bởi:");
//                myHashMap.put("SHOWDATETIME", "True");
//                myHashMap.put("DATETIMEPREFIX", "Ký ngày:");
////            myHashMap.put("SHOWREASON", "True");
////            myHashMap.put("SIGNREASONPREFIX", "Lý do:");
////            myHashMap.put("SIGNREASON", "Đồng ý");
//                myHashMap.put("SHOWLOCATION", "True");
//                myHashMap.put("LOCATION", "TP Hồ Chí Minh");
//                myHashMap.put("LOCATIONPREFIX", "Nơi ký:");
//                myHashMap.put("TEXTCOLOR", "black");
////            myHashMap.put("LOCKAFTERSIGNING", "False");
//
////                myHashMap.put("ONLYCOUNTERSIGNENABLED", "True");
//                myHashMap.put("COUNTERSIGNENABLED", "False");
////                myHashMap.put("COUNTERAGREEMENTUUID", agreementUUID);
////                myHashMap.put("COUNTERAGREEMENTPASSCODE", eSignDocProperties.getCounteragreementpasscode());
//
////            myHashMap.put("SIGNATUREIMAGE", "data:image/png;base64,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");
//
//                if (eSignRequest != null && eSignRequest.getSignImage() != null && !eSignRequest.getSignImage().isEmpty()) {
//                    myHashMap.put("SIGNATUREIMAGE", eSignRequest.getSignImage().replace("data:image/png;base64,", ""));
//                } else {
//
////                File initialFile = new File("D:\\Bank\\mydoc\\signature\\sign.png");
////                InputStream targetStream = new FileInputStream(initialFile);
////                byte[] imgData = IOUtils.toByteArray(targetStream);
//                    byte[] imgData = IOUtils.toByteArray(signImage.getInputStream());
//                    myHashMap.put("SIGNATUREIMAGE", Base64.getEncoder().encodeToString(imgData));
//                }
//
//
//                myHashMap.put("IMAGEANDTEXT", "True");
//                myHashMap.put("TEXTDIRECTION", "RIGHTTOLEFT");
//
////                myHashMap.put("SHOWTITLE", "True");
////                myHashMap.put("TITLEPREFIX", "Chức vụ:");
////
////                signCloudMetaData.setCounterSigning(myHashMap);
////                myHashMap.put("COUNTERSIGNENABLED", "False");
//                signCloudMetaData.setSingletonSigning(myHashMap);
//
//
////                signCloudMetaData.setCounterSigning(myHashMap);
////                if (eSignDocProperties.getCusbnk().toUpperCase().equals("CUS")) // singletonSigning
////                {
////                    // Customer's sign
////                    if (eSignWebRequest.getCustomerSign() != null && eSignWebRequest.getCustomerSign() != "") {
////                        myHashMap.put("SIGNATUREIMAGE", eSignWebRequest.getCustomerSign());
////                        myHashMap.put("IMAGEANDTEXT", "True");
////                        myHashMap.put("TEXTDIRECTION", "RIGHTTOLEFT");
////                    }
////                    //
////                    signCloudMetaData.setSingletonSigning(myHashMap);
////                } else if (eSignDocProperties.getCusbnk().toUpperCase().equals("BNK")) { // BNK --> counterSigning
////                    myHashMap.put("SHOWTITLE", eSignDocProperties.getShowtitle());
////                    myHashMap.put("TITLEPREFIX", eSignDocProperties.getTitleprefix());
////                    signCloudMetaData.setCounterSigning(myHashMap);
////                }
//
//                signCloudFileReq.setSignCloudMetaData(signCloudMetaData);
//                signCloudFileReq.setNotificationTemplate("Your authorize code: \n" +
//                        "{AuthorizeCode}. Authorize \n" +
//                        "Code is valid within 5 minutes");
//                signCloudFileReq.setNotificationSubject("Authorization Code");
//                signCloudFileReq.setCredentialData(credentialData);
//
//                ObjectMapper objectFileMapper = new ObjectMapper(); // prepareMultipleFilesForSignCloud
//                objectFileMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//                objectFileMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
//                String jsonFileResponse = sendPost("/prepareFileForSignCloud", objectFileMapper.writeValueAsString(signCloudFileReq));
//                SignCloudResp signCloudFileResp = objectFileMapper.readValue(jsonFileResponse, SignCloudResp.class);
//                ESignResponse eSignResponse = new ESignResponse();
//
//                if (signCloudFileResp.getResponseCode() == 1007) {
//                    boolean smsRelyingPartyEnable = false;
//
////                    eSignApplication.setStatus("otp");
////                    eSignApplication.setAuthorizationMobileNo("0983987605");
//                    eSignResponse.setBillCode(signCloudFileResp.getBillCode()); // Save billcode. use for next step or resume at otp step.
//                    eSignResponse.setAgreementUUID(agreementUUID);
//
//                    //------------------------------------- START SEND OTP TO CUSTOMER BY FE SMS GATEWAY
////                    System.out.println("Sending OTP to " + eSignApplication.getAuthorizationMobileNo());
////                if (smsRelyingPartyEnable) {
////                        System.out.println("Send OTP is using relying Party SMS Gateway");
////                        Map<String, Object> map = new HashMap<>();
////                        map.put("partnerChannel", "FPT");
////                        map.put("message", signCloudResp.getBillCode());
////                        map.put("contactNumber", eSignApplication.getAuthorizationMobileNo());
////                        BankUtils bankUtils = new BankUtils();
////                        bankUtils.SendRequestChildThread(user.getSmsUrl(), user.getSmsUserName(), user.getSmsPassword(), map);
////                } else {
////                    System.out.println("Send OTP is using FPT-CA");
////                }
//
//
//                    //------------------------------------ END SEND OTP TO CUSTOMER BY FE SMS GATEWAY
//                }
//                return eSignResponse;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ESignResponse();
//    }
//
//    @Override
//    public File authorizeCounterSigningForSignCloud(SignCloudReq signCloudReq) {
//        try {
////            SignCloudReq signCloudReq = new SignCloudReq();
//            signCloudReq.setRelyingParty("UBANK");
////            signCloudReq.setAgreementUUID("12081999010");
//            signCloudReq.setMessagingMode(3);
////            signCloudReq.setBillCode("UBANK-220307103413-766050-238272");
////            signCloudReq.setAuthorizeCode("483619");
//
//            signCloudReq.setLtvEnabled(false);
//            CredentialData credentialData = CreateCredentialData();
//            signCloudReq.setCredentialData(credentialData);
//
//            ObjectMapper objectMapper = new ObjectMapper(); // authorizeSingletonSigningForSignCloud
//            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//            objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
//            String jsonResponse = sendPost("/authorizeCounterSigningForSignCloud", objectMapper.writeValueAsString(signCloudReq));
//            SignCloudResp signCloudResp = objectMapper.readValue(jsonResponse, SignCloudResp.class);
//
//            if (signCloudResp.getResponseCode() == 0) {
//                String filePath = "D:\\Bank\\mydoc\\signature\\" + signCloudResp.getSignedFileName();
//                FileOutputStream file = new FileOutputStream(filePath);
//                IOUtils.write(signCloudResp.getSignedFileData(), file);
//
//                return new File(filePath);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    //objectMapper.writeValueAsString(payload)
//    private String sendPost(String function, String payload) throws Exception {
//        //log.info("Request: " + payload);
//        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
//            public boolean verify(String arg0, SSLSession arg1) {
//                return true;
//            }
//        });
//        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
//            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                return new X509Certificate[0];
//            }
//
//            public void checkClientTrusted(X509Certificate[] certs, String authType) {
//            }
//
//            public void checkServerTrusted(X509Certificate[] certs, String authType) {
//            }
//        }};
//
//        SSLContext sc = SSLContext.getInstance("SSL");
//        sc.init(null, trustAllCerts, new SecureRandom());
//        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//
//        String endpointUrl = "https://rssp.mobile-id.vn/eSignCloud/restapi" + function; // /getSignedFileForSignCloud
//
//        URL obj = new URL(endpointUrl);
//        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//
//        //add request header
//        con.setRequestMethod("POST");
//        con.setRequestProperty("User-Agent", "Mozilla/5.0"); // private static final String USER_AGENT = "Mozilla/5.0";
//        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//
//        // Send post request
//        con.setDoOutput(true);
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.write(payload.getBytes(StandardCharsets.UTF_8));
//        wr.flush();
//        wr.close();
//
//
//        int responseCode = con.getResponseCode();
//        if (responseCode != 200) {
//            throw new Exception("Error while calling eSignCloud server");
//        }
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//        return response.toString();
//    }
//
//    private CredentialData CreateCredentialData() throws Exception { //User user
//        String signature = "lo/iJ/+80T5U8yY4nYRFDgh40/+WQ4Ato9uo/b02GuxrNyd7LIt2LJC89q4n2H3S5GtykW8nUvs8TTYueTndIwubNpBO28O0C1Rw2jJTaEyF8xsAGwch5yNG1Lq5xyRnD+ffKy7tcqAue7GiAHmr1VA6Qie8SKGnfnJdzK/v28f0srb7EyoojGZl5sb/RrJmEG4uRjenmc7GY00OsbE+GC2m+e9/C6D7/lxMA9bKUFaKUNECEiMLGKuhQV6S0Wk5LQ1EAWD6XJt5zvwqLK9mGCMgTmv0Kg02ULPbQvPjuPinLxi1MXaNZC1Jmw9UnDeMJu6SHdcl13fd+U5PEkLhWw==";
//        String timestamp = String.valueOf(System.currentTimeMillis());
//        String data2sign = "ubank_esign" + "gGNDE9a7" + signature + timestamp;
////        String pkcs1Signature = getPKCS1Signature(data2sign, "D:\\Bank\\mydoc\\UAT.pfx", "uat");
//        String pkcs1Signature = getPKCS1Signature(data2sign, "D:\\Bank\\mydoc\\ubank\\ubank.p12", "C8ENndDL");
//        CredentialData credentialData = new CredentialData();
//        credentialData.setUsername("ubank_esign");
//        credentialData.setPassword("gGNDE9a7");
//        credentialData.setTimestamp(timestamp);
//        credentialData.setSignature(signature);
//        credentialData.setPkcs1Signature(pkcs1Signature);
//        return credentialData;
//    }
//}
