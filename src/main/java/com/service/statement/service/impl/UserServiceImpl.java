package com.service.statement.service.impl;

import com.monitorjbl.xlsx.StreamingReader;
import com.service.statement.common.mapper.CommonMapper;
import com.service.statement.common.service.CommonService;
import com.service.statement.exceptions.EtAuthException;
import com.service.statement.mapper.UserMapper;
import com.service.statement.model.Department;
import com.service.statement.model.User;
import com.service.statement.model.request.UserRequest;
import com.service.statement.model.response.BaseListResponse;
import com.service.statement.model.response.BaseResponse;
import com.service.statement.service.IUserService;
import com.service.statement.service.email.MailSenderService;
import com.service.statement.util.ExportUtil;
import com.service.statement.util.GenerateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private final String textHtml = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
            "<head>\n" +
            "<!--[if gte mso 9]>\n" +
            "<xml>\n" +
            "  <o:OfficeDocumentSettings>\n" +
            "    <o:AllowPNG/>\n" +
            "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
            "  </o:OfficeDocumentSettings>\n" +
            "</xml>\n" +
            "<![endif]-->\n" +
            "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
            "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
            "  <title></title>\n" +
            "  \n" +
            "    <style type=\"text/css\">\n" +
            "      table, td { color: #000000; } @media only screen and (min-width: 520px) {\n" +
            "  .u-row {\n" +
            "    width: 500px !important;\n" +
            "  }\n" +
            "  .u-row .u-col {\n" +
            "    vertical-align: top;\n" +
            "  }\n" +
            "\n" +
            "  .u-row .u-col-100 {\n" +
            "    width: 500px !important;\n" +
            "  }\n" +
            "\n" +
            "}\n" +
            "\n" +
            "@media (max-width: 520px) {\n" +
            "  .u-row-container {\n" +
            "    max-width: 100% !important;\n" +
            "    padding-left: 0px !important;\n" +
            "    padding-right: 0px !important;\n" +
            "  }\n" +
            "  .u-row .u-col {\n" +
            "    min-width: 320px !important;\n" +
            "    max-width: 100% !important;\n" +
            "    display: block !important;\n" +
            "  }\n" +
            "  .u-row {\n" +
            "    width: calc(100% - 40px) !important;\n" +
            "  }\n" +
            "  .u-col {\n" +
            "    width: 100% !important;\n" +
            "  }\n" +
            "  .u-col > div {\n" +
            "    margin: 0 auto;\n" +
            "  }\n" +
            "}\n" +
            "body {\n" +
            "  margin: 0;\n" +
            "  padding: 0;\n" +
            "}\n" +
            "\n" +
            "table,\n" +
            "tr,\n" +
            "td {\n" +
            "  vertical-align: top;\n" +
            "  border-collapse: collapse;\n" +
            "}\n" +
            "\n" +
            "p {\n" +
            "  margin: 0;\n" +
            "}\n" +
            "\n" +
            ".ie-container table,\n" +
            ".mso-container table {\n" +
            "  table-layout: fixed;\n" +
            "}\n" +
            "\n" +
            "* {\n" +
            "  line-height: inherit;\n" +
            "}\n" +
            "\n" +
            "a[x-apple-data-detectors='true'] {\n" +
            "  color: inherit !important;\n" +
            "  text-decoration: none !important;\n" +
            "}\n" +
            "\n" +
            "</style>\n" +
            "  \n" +
            "  \n" +
            "\n" +
            "</head>\n" +
            "\n" +
            "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #e7e7e7;color: #000000\">\n" +
            "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
            "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
            "  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #e7e7e7;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
            "  <tbody>\n" +
            "  <tr style=\"vertical-align: top\">\n" +
            "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
            "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #e7e7e7;\"><![endif]-->\n" +
            "    \n" +
            "\n" +
            "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
            "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 500px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
            "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
            "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:500px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
            "      \n" +
            "<!--[if (mso)|(IE)]><td align=\"center\" width=\"500\" style=\"width: 500px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
            "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 500px;display: table-cell;vertical-align: top;\">\n" +
            "  <div style=\"width: 100% !important;\">\n" +
            "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
            "  \n" +
            "<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
            "  <tbody>\n" +
            "    <tr>\n" +
            "      <td style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
            "        \n" +
            "  <div style=\"line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
            "    <p style=\"font-size: 14px; line-height: 140%; text-align: center;\"><strong>TẠO TÀI KHOẢN THÀNH CÔNG</strong></p>\n" +
            "<p style=\"font-size: 14px; line-height: 140%;\">&nbsp;</p>\n" +
            "<p style=\"font-size: 14px; line-height: 140%;\">- MẬT KHẨU: <strong>[PASSWORD] </strong></p>\n" +
            "  </div>\n" +
            "\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "  </tbody>\n" +
            "</table>\n" +
            "\n" +
            "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
            "  </div>\n" +
            "</div>\n" +
            "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
            "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
            "    </div>\n" +
            "  </div>\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
            "    </td>\n" +
            "  </tr>\n" +
            "  </tbody>\n" +
            "  </table>\n" +
            "  <!--[if mso]></div><![endif]-->\n" +
            "  <!--[if IE]></div><![endif]-->\n" +
            "</body>\n" +
            "\n" +
            "</html>\n";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private MailSenderService emailService;

    @Value("${size.list.data}")
    private int sizeData;


    @Override
    public BaseResponse createUser(User user) throws MessagingException {

        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        String email = user.getEmail();

        if (email != null) email = email.toLowerCase();

        assert email != null;
        if (!pattern.matcher(email).matches()) {
            return responseStatus("-1", "Invalid email format");
        }

        Integer countUserCode = userMapper.getCountByUserCode(user.getCode());
        if (countUserCode > 0) {
            return responseStatus("-2", "UserCode already in use");
        }

        Integer countPhoneNo = userMapper.getCountByPhoneNo(user.getPhoneNo());
        if (countPhoneNo > 0) {
            return responseStatus("-3", "PhoneNo already in use");
        }

        Integer countByEmail = userMapper.getCountByEmail(email);
        if (countByEmail > 0) {
            return responseStatus("-4", "Email already in use");
        }

        if (user.getPhoneNo().length() > 10) {
            return responseStatus("-5", "PhoneNo must lower or equal to 10");
        }
        int kt = 0;
        for (int i = 0; i < user.getPhoneNo().length(); i++) {
            char a = user.getPhoneNo().charAt(i);
            if (a >= 'A' && a <= 'Z' || a >= 'a' && a <= 'z') kt = -1;

        }
        if (kt == -1) {
            return responseStatus("-6", "PhoneNo must be number");
        }
        String name = user.getFullName();
        Integer countByFullName = userMapper.getCountByFullName(name);
        if (countByFullName > 0) {
            return responseStatus("-7", "UserName already in use");
        }

        String id = generateUserId();
        String passGenRamdom = GenerateUtil.generateNumber(6);
        String hashedPassword = BCrypt.hashpw(passGenRamdom, BCrypt.gensalt(10));

        user.setId(id);
        user.setPassword(hashedPassword);

        User userRes = userMapper.createdUser(user);

        if (userRes != null) {
            // send mail
            emailService.doSendEmailTemplate(user.getEmail(), "E-Statement account", textHtml.replace("[PASSWORD]", passGenRamdom));

            return responseStatus("0", "Tạo thành công");
        }

        return responseStatus("1", "Tạo thất bại");
    }

    @Override
    public BaseResponse getUserPaging(UserRequest request) {
        List<User> list = userMapper.search(request);
        int totalRecords = userMapper.count(request);
        BaseResponse result = new BaseListResponse(list, totalRecords, request.getLimit());
        return result;
    }

    @Override
    public BaseResponse updateUser(User request) {
        BaseResponse response = new BaseResponse();

        User user = userMapper.updateUser(request);
        if (user != null) {
            response.setData(user);
            response.setErrorCode("0");
            response.setErrorDesc("Tạo thành công");
        } else {
            response.setErrorCode("1");
            response.setErrorDesc("Tạo thất bại");
        }

        return response;
    }

    @Override
    public BaseResponse deleteUser(User request) {
        BaseResponse response = new BaseResponse();

        int userDeleted = userMapper.deleteUser(request.getId());
        if (userDeleted > 0) {
            response.setErrorCode("0");
            response.setErrorDesc("Xóa thành công");
        } else {
            response.setErrorCode("1");
            response.setErrorDesc("Xóa thất bại");
        }

        return response;
    }


    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if (email != null) email = email.toLowerCase();
        try {
            User user = userMapper.findByEmailAndPassword(email.toUpperCase());
            if (!BCrypt.checkpw(password, user.getPassword()))
                throw new EtAuthException("Invalid email/password");
            return user;
        } catch (EmptyResultDataAccessException e) {
            throw new EtAuthException("Invalid email/password");
        }
    }



    private BaseResponse responseStatus(String code, String desc) {
        BaseResponse response = new BaseResponse();
        response.setErrorCode(code);
        response.setErrorDesc(desc);
        return response;
    }

    private String generateUserId() {
        String seq = commonMapper.getID("U");
        String pad = commonService.padLeft(seq, 4, "0");

        return "U" + pad;
    }

    @Override
    public File exportUser(UserRequest request) {
        File file = null;

        try {

            file = File.createTempFile("out", ".tmp");
            file.deleteOnExit();
            Resource resource = new ClassPathResource("templates/User.jasper");
            try (FileOutputStream fos = new FileOutputStream(file);
                 InputStream inputStream = resource.getInputStream();)
            {
                List<Department> list = request.getF();

                // Get list code category
                if (!list.isEmpty()) {
                    list.add(0, new Department());
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("printDate",cal.getTime());
                ExportUtil.exportReport(inputStream, fos,parameters, list, request.getFileType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public BaseResponse importFile(MultipartFile file) {
        if (file != null) {
            try (@SuppressWarnings("deprecation")
                 StreamingReader reader = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).sheetIndex(0)
                    .read(file.getInputStream())) {
                @SuppressWarnings("deprecation")
                Iterator<Row> rowIterator = reader.iterator();
                Row row = rowIterator.next(); // Bỏ qua head;
                List<User> users = new ArrayList<>();
                User user = new User();
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();


                    Cell code = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    Cell name = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell birthDay = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell phone = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell email = row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell groupCode = row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell deptCode = row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell unitCode = row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    user.setId(generateUserId());
                    user.setCode(code.getStringCellValue());
                    user.setFullName(name.getStringCellValue());
                    user.setBirthday(birthDay.getDateCellValue());
                    user.setPhoneNo(phone.getStringCellValue());
                    user.setEmail(email.getStringCellValue());
                    user.setGroupCode(groupCode.getStringCellValue());
                    user.setDepartmentCode(deptCode.getStringCellValue());
                    user.setUnitCode(unitCode.getStringCellValue());
                    Integer countUserCode=userMapper.getCountByUserCode(code.getStringCellValue());
                    if (countUserCode > 0) {
                        return responseStatus("-2", "UserCode already in use");
                    }
                    users.add(user);
                    userMapper.importExcel(users);

                    users.clear();

                }

                return responseStatus("0", "Import thành công");
            } catch (Exception e) {
                return responseStatus("1", "Import thất bại");
            }
        }
        return responseStatus("1", "Import thất bại");
    }
}
