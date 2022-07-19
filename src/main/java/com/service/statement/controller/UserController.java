package com.service.statement.controller;

import com.service.statement.constant.APIConstant;
import com.service.statement.model.User;
import com.service.statement.model.request.UserRequest;
import com.service.statement.model.response.BaseResponse;
import com.service.statement.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping(value = APIConstant.API_USER)
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createUser(@RequestBody User user) throws MessagingException {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @PostMapping(value = "/getUserPaging", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getUserPaging(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.getUserPaging(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateUser(@RequestBody User request) throws IOException {
        return new ResponseEntity<>(userService.updateUser(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteUser(@RequestBody User request) {
        return new ResponseEntity<>(userService.deleteUser(request), HttpStatus.OK);
    }

    @PostMapping(value = "/importUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> importUser(@RequestPart("file") MultipartFile file) {
        return new ResponseEntity<>(userService.importFile(file), HttpStatus.OK);
    }

}