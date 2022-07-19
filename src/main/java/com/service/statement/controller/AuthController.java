package com.service.statement.controller;

import com.service.statement.Constants;
import com.service.statement.constant.APIConstant;
import com.service.statement.model.User;
import com.service.statement.model.UserDemo;
import com.service.statement.service.impl.UserDemoServiceImpl;
import com.service.statement.service.impl.UserServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = APIConstant.API_AUTH)
public class AuthController {

    @Autowired
    UserServiceImpl userService;


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap) {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.validateUser(email, password);
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }



//    @PostMapping("/register")
//    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
//        String firstName = (String) userMap.get("firstName");
//        String lastName = (String) userMap.get("lastName");
//        String email = (String) userMap.get("email");
//        String password = (String) userMap.get("password");
//        UserDemo user = userService.registerUser(firstName, lastName, email, password);
//        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
//    }

    private Map<String, String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("code", user.getCode())
                .claim("fullName", user.getFullName())
                .claim("birthday", user.getBirthday())
                .claim("email", user.getEmail())
                .claim("phoneNo", user.getPhoneNo())
                .claim("departmentCode", user.getDepartmentCode())
                .claim("groupCode", user.getGroupCode())
                .claim("unitCode",user.getUnitCode())
                .claim("status", user.isStatus())
                .claim("creater", user.getCreater())
                .claim("createdDate", user.getCreatedDate())
                .claim("editer", user.getEditer())
                .claim("editedDate", user.getEditedDate())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }


}
