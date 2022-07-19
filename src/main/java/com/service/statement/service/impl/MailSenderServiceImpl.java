package com.service.statement.service.impl;

import com.service.statement.service.email.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

@Component
public class MailSenderServiceImpl extends MailSenderService {
    protected String fromUsername = "";

//    @Override
//    public void doSendDynamicContentEmail(String fromAddress, String[] recipients, String titleEmail,
//                                          String templatePath, Map<String, String> info) throws MessagingException {
//
//        // Init load config
//        JavaMailSender mailSender = loadConfig();
//
//        Locale locale = LocaleContextHolder.getLocale();
//        // Prepare the evaluation context
//        Context ctx = new Context(locale);
//        info.forEach((k, v) -> ctx.setVariable(k, isValidParam(v) ? v.trim().toUpperCase(Locale.ROOT) : " "));
//
//        // Create the HTML body using Thymeleaf
////        String emailContent = templateEngine.process(templatePath, ctx);
//        // Send Email
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
//        mimeMessageHelper.setFrom(new InternetAddress(fromAddress));
//        mimeMessageHelper.setSubject(titleEmail);
//        mimeMessageHelper.setTo(recipients);
//
//        // Create the HTML body using Thymeleaf
//        mimeMessageHelper.setText(emailContent, true);
//        mimeMessageHelper.setSentDate(new Date());
//
//        // Send email
//        mailSender.send(mimeMessage);
//    }

    @Override
    public void doSendEmailTemplate(String recipientEmail, String subject, String emailContent)
            throws MessagingException {

        // Init load config
        JavaMailSender mailSender = loadConfig();

        // Prepare message using a Spring helper
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setTo(recipientEmail);
        mimeMessageHelper.setFrom(fromUsername);

        // Create the HTML body using Thymeleaf
        mimeMessageHelper.setText(emailContent, true);
        mimeMessageHelper.setSentDate(new Date());

        // Send email
        sendMail(mailSender, mimeMessage);
    }

//    @Override
//    public void doSendEmailTemplateWithAttachment(String recipientEmail, String subject, String emailContent,
//                                                  String fileName, ByteArrayOutputStream baos) throws MessagingException {
//
//        JavaMailSender mailSender = loadConfig();
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
//        mimeMessageHelper.setSubject(subject);
//        mimeMessageHelper.setTo(recipientEmail);
//        mimeMessageHelper.setFrom(fromUsername);
//        // mimeMessageHelper.setText(emailContent, true);
//
//        DataSource aAttachment = new ByteArrayDataSource(baos.toByteArray(), "application/octet-stream");
//
//        MimeMultipart multipart = new MimeMultipart();
//        MimeBodyPart attachmentPart = new MimeBodyPart();
//        attachmentPart.setDataHandler(new DataHandler(aAttachment));
//        attachmentPart.setFileName(fileName);
//        multipart.addBodyPart(attachmentPart);
//
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent(emailContent, "text/html; charset=UTF-8");
//        multipart.addBodyPart(messageBodyPart);
//        mimeMessage.setContent(multipart);
//
//        sendMail(mailSender, mimeMessage);
//    }

    private void sendMail(JavaMailSender mailSender, MimeMessage mimeMessage) {
        try {
            mailSender.send(mimeMessage);
        } catch (Exception e) {
//            LogUtils.parseExceptionContents(e);
        }
    }

//    @Override
//    public void doSendEmailTemplateWithAttachment(String recipientEmail, String subject, String emailContent,
//                                                  List<FileTemplate> fileTemplates) throws MessagingException, IOException {
//        // Init load config
//        JavaMailSender mailSender = loadConfig();
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
//        mimeMessageHelper.setSubject(subject);
//        mimeMessageHelper.setTo(recipientEmail);
//        mimeMessageHelper.setFrom(fromUsername);
//
//        MimeMultipart multipart = new MimeMultipart();
//        List<File> files = new ArrayList<>();
//        for (FileTemplate fileTemplate : fileTemplates) {
//            List<String> names = getFileNameAndExtension(fileTemplate.getFilename());
//            File file = getFileFromAfresco(fileTemplate.getFileurl(), names.get(0), names.get(1));
//            if (file != null) {
//                files.add(file);
//                DataSource source = new FileDataSource(file.getPath());
//                MimeBodyPart attachmentPart = new MimeBodyPart();
//                attachmentPart.setDataHandler(new DataHandler(source));
//                attachmentPart.setFileName(fileTemplate.getFilename());
//                multipart.addBodyPart(attachmentPart);
//            }
//        }
//
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent(emailContent, "text/html; charset=UTF-8");
//        multipart.addBodyPart(messageBodyPart);
//        mimeMessage.setContent(multipart);
//
//        sendMail(mailSender, mimeMessage);
//        deleteFile(files);
//    }

//    @Override
//    public String doSendEmailTemplateWithAttachment(String recipientEmail, String subject, String emailContent,
//                                                  List<FileTemplate> fileTemplates, String password) throws MessagingException, IOException {
//
//        // Init load config
//        JavaMailSender mailSender = loadConfig();
//        // Prepare message using a Spring helper
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
//        mimeMessageHelper.setSubject(subject);
//        mimeMessageHelper.setTo(recipientEmail);
//        mimeMessageHelper.setFrom(fromUsername);
//
//        MimeMultipart multipart = new MimeMultipart();
//        ArrayList<File> files = new ArrayList<>();
//        for (FileTemplate fileTemplate : fileTemplates) {
//            List<String> names = getFileNameAndExtension(fileTemplate.getFilename());
//            File file = getFileFromAfresco(fileTemplate.getFileurl(), names.get(0), names.get(1));
//            if (file != null) {
//                files.add(file);
//            }
//        }
//
//        String filePath = zipFilePassword(files, password);
//
//        DataSource source = new FileDataSource(filePath);
//        MimeBodyPart attachmentPart = new MimeBodyPart();
//        attachmentPart.setDataHandler(new DataHandler(source));
//        attachmentPart.setFileName("File.zip");
//        multipart.addBodyPart(attachmentPart);
//
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent(emailContent, "text/html; charset=UTF-8");
//        multipart.addBodyPart(messageBodyPart);
//        mimeMessage.setContent(multipart);
//
//        sendMail(mailSender, mimeMessage);
//        deleteFile(files);
//
//        return filePath;
//    }

    private File getFileFromAfresco(String urlFile, String fileName, String suffix) {
        File file = null;
        try {
            URL url = new URL(urlFile);

            file = File.createTempFile(fileName, suffix);
            file.deleteOnExit();

            try (FileOutputStream fos = new FileOutputStream(file);
                 ReadableByteChannel rbc = Channels.newChannel(url.openStream())) {
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            }
        } catch (Exception e) {
//            LogUtils.parseExceptionContents(e.getStackTrace(), e.getMessage());
        }
        return file;
    }

    private void deleteFile(List<File> files) {
        for (File file : files) {
            try {
                boolean delete = file.delete();
                if (delete) {
                    System.out.println("Delete success");
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public int sendMailZip(String[] toAddress, String subject, String content, String password)
            throws Exception {
        JavaMailSender mailSender = loadConfig();
        // Prepare message using a Spring helper
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        mimeMessage.setFrom(fromUsername);
        MimeMessageHelper helper;
        /*
        try {

            String filePath = zipFilePassword(password);
            helper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.toString());
            helper.setTo(toAddress);
            helper.setSubject(subject);

            MimeBodyPart messageBodyPartContent = new MimeBodyPart();
            messageBodyPartContent.setContent(content, "text/html;charset=UTF-8");
            //messageBodyPartContent.setDescription("សូមកុំឆ្លើយតបអ៊ីមែលនេះដោយផ្ទាល់។");
            MimeBodyPart messageBodyPartFile = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath);
            messageBodyPartFile.setDataHandler(new DataHandler(source));
            messageBodyPartFile.setFileName("File.zip");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPartContent);
            multipart.addBodyPart(messageBodyPartFile);

            mimeMessage.setContent(multipart);
            mailSender.send(mimeMessage);
            File f = new File(filePath);
            f.delete();

        } catch (MessagingException e1) {
            e1.printStackTrace();
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
        */

        return 0;
    }


//    public String zipFilePassword(ArrayList<File> files, String password) throws IOException {
//        try {
//            ZipParameters zipParameters = new ZipParameters();
//            zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
//            zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
//            zipParameters.setEncryptFiles(true);
//            zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
//            zipParameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
//            zipParameters.setPassword(password);
//
//            String cwd = Paths.get("").toAbsolutePath().toString();
//            // String destinationZipFilePath = cwd + "\\File.zip";
//            String destinationZipFilePath = "File.zip";
//            ZipFile zipFile = new ZipFile(destinationZipFilePath);
//            //zipFile.addFile(file.getAbsoluteFile(), zipParameters);
//            zipFile.addFiles(files, zipParameters);
//            return destinationZipFilePath;
//
//        } catch (ZipException e) {
////            LogUtils.parseExceptionContents(e.getStackTrace(), e.getMessage());
//            return null;
//        }
//    }

    private List<String> getFileNameAndExtension(String fileName) {
        List<String> names = new ArrayList<>();
        int index = fileName.lastIndexOf(".");
        names.add(fileName.substring(0, index));
        names.add(fileName.substring(index));
        return names;
    }

    private JavaMailSender loadConfig() {
        JavaMailSenderImpl mailSenderImpl = null;
        try {


            mailSenderImpl = new JavaMailSenderImpl();

            mailSenderImpl.setHost("smtp.gmail.com");
            mailSenderImpl.setPort(465);
            mailSenderImpl.setUsername("howlpusifletter@gmail.com");
            mailSenderImpl.setPassword("01208687169");
            mailSenderImpl.setDefaultEncoding("UTF-8");
            fromUsername = mailSenderImpl.getUsername();

            Properties props = mailSenderImpl.getJavaMailProperties();
            props.put("mail.smtp.starttls.required", "false"); // added this line
            props.put("mail.smtp.starttls.enable", "true"); // added this line
            props.put("mail.smtp.ssl.enable", true);
            props.put("mail.smtp.auth", true);
            props.put("mail.debug", true);
            props.put("mail.init.config", true);
        } catch (Exception e) {
//            LogUtils.parseExceptionContents(e.getStackTrace(), e.getMessage());
//            throw new ServiceException("Load config Email failed");
        }
        if (mailSenderImpl == null) {
//            throw new ServiceException("Load config Email failed");
        }
        return mailSenderImpl;
    }

    private boolean isValidParam(String param) {
        return (param != null && !param.isEmpty());
    }
}
