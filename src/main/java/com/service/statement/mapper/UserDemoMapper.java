package com.service.statement.mapper;

import com.service.statement.exceptions.EtAuthException;
import com.service.statement.model.UserDemo;
import com.service.statement.model.request.UserDemoRequest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDemoMapper {
    UserDemo findByEmailAndPassword(String email) throws EtAuthException;

    Integer getCountByEmail(String email) throws EtAuthException;

    Integer getCountByUserCode(String code) throws EtAuthException;

    Integer getCountByPhoneNo(String phoneNo) throws EtAuthException;

    Integer getCountByFullName(String fullName) throws EtAuthException;

    UserDemo createUserDemo(UserDemo user) throws EtAuthException;

    List<UserDemo> search(UserDemoRequest request);

    int count(UserDemoRequest request);

    UserDemo updateUserDemo(UserDemo request);

    int deleteUserDemo(String id);

    void importExcel(List<UserDemo> users);
}
