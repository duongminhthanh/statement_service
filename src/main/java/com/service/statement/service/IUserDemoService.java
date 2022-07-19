package com.service.statement.service;

import com.service.statement.exceptions.EtAuthException;
import com.service.statement.model.UserDemo;
import com.service.statement.model.request.UserDemoRequest;
import com.service.statement.model.request.UserRequest;
import com.service.statement.model.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;

public interface IUserDemoService {
    UserDemo validateUser(String email, String password) throws EtAuthException;

    BaseResponse createUserDemo(UserDemo user) throws MessagingException;

    BaseResponse getUserDemoPaging(UserDemoRequest request);

    BaseResponse updateUserDemo(UserDemo request);

    BaseResponse deleteUserDemo(UserDemo request);

    BaseResponse importFile(MultipartFile file, String creater);

    File exportUser(UserDemoRequest request);
}
