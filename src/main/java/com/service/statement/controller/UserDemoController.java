package com.service.statement.controller;

import com.service.statement.constant.APIConstant;
import com.service.statement.model.UserDemo;
import com.service.statement.model.request.UserDemoRequest;
import com.service.statement.model.response.BaseResponse;
import com.service.statement.service.IUserDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping(value = APIConstant.API_USERDEMO)
public class UserDemoController {
    @Autowired
    IUserDemoService userService;

    @PostMapping(value = "/createUserDemo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createUserDemo(@RequestBody UserDemo user) throws MessagingException {
        return new ResponseEntity<>(userService.createUserDemo(user), HttpStatus.OK);
    }

    @PostMapping(value = "/getUserDemoPaging", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getUserDemoPaging(@RequestBody UserDemoRequest request) {
        return new ResponseEntity<>(userService.getUserDemoPaging(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateUserDemo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateUserDemo(@RequestBody UserDemo request) throws IOException {
        return new ResponseEntity<>(userService.updateUserDemo(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteUserDemo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteUserDemo(@RequestBody UserDemo request) {
        return new ResponseEntity<>(userService.deleteUserDemo(request), HttpStatus.OK);
    }

    @PostMapping(value = "/importUserDemo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> importUserDemo(@RequestPart("file") MultipartFile file, @RequestPart("info") UserDemo user) {
        return new ResponseEntity<>(userService.importFile(file, user.getCreater()), HttpStatus.OK);
    }

}
