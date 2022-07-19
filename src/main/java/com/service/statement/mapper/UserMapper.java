package com.service.statement.mapper;

import com.service.statement.exceptions.EtAuthException;
import com.service.statement.model.User;
import com.service.statement.model.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserMapper {

    User findByEmailAndPassword(String email) throws EtAuthException;

    Integer getCountByEmail(String email) throws EtAuthException;

    Integer getCountByUserCode(String code) throws EtAuthException;

    Integer getCountByPhoneNo(String phoneNo) throws EtAuthException;

    Integer getCountByFullName(String fullName) throws EtAuthException;

    User createdUser(User user) throws EtAuthException;

    List<User> search(UserRequest request);

    int count(UserRequest request);

    User updateUser(User request);

    int deleteUser(String id);

    void importExcel(List<User> users);
}
