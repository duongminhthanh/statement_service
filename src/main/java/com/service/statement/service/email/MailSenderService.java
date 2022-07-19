package com.service.statement.service.email;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.activation.DataSource;
import javax.mail.MessagingException;

public abstract class MailSenderService {

//	public abstract void doSendDynamicContentEmail(String fromAddress, String[] recipientEmail, String titleEmail,
//			String templatePath, Map<String, String> info) throws MessagingException;

    public abstract void doSendEmailTemplate(String recipientEmail, String subject, String emailContent) throws MessagingException;

//	public abstract void doSendEmailTemplateWithAttachment(String recipientEmail, String subject, String emailContent, String fileName, ByteArrayOutputStream baos) throws MessagingException;
//
//	public abstract void doSendEmailTemplateWithAttachment(String recipientEmail, String subject, String emailContent, List<FileTemplate> fileTemplates) throws MessagingException, IOException;
//
//	public abstract String doSendEmailTemplateWithAttachment(String recipientEmail, String subject, String emailContent, List<FileTemplate> fileTemplates, String password) throws MessagingException, IOException;

}
