package com.service.statement.service;

import com.service.statement.exceptions.EtAuthException;
import com.service.statement.model.User;
import com.service.statement.model.request.UserRequest;
import com.service.statement.model.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;

public interface IUserService {
    User validateUser(String email, String password) throws EtAuthException;

    BaseResponse createUser(User user) throws MessagingException;

    BaseResponse getUserPaging(UserRequest request);

    BaseResponse updateUser(User request);

    BaseResponse deleteUser(User request);

    File exportUser(UserRequest request);

    BaseResponse importFile(MultipartFile file);
}
