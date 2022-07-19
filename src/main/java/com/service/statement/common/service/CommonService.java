package com.service.statement.common.service;

import org.springframework.stereotype.Service;

@Service
public class CommonService {

    public String padLeft(String input, int len, String chr) {
        String output = input;
        for (int i = 1; i <= len - input.length(); i++) {
            output = chr + output;
        }
        return output;
    }
}
