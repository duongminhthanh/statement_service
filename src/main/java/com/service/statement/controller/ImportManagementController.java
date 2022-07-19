package com.service.statement.controller;

import com.service.statement.constant.APIConstant;
import com.service.statement.model.BankStatement;
import com.service.statement.model.request.ImportFileRequest;
import com.service.statement.model.response.BaseResponse;
import com.service.statement.service.IImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = APIConstant.API_IMPORT)
public class ImportManagementController {
    @Autowired
    IImportService importService;

    @PostMapping(value = "/getFileListPaging", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getFileListPaging(@RequestBody ImportFileRequest request) {
        return new ResponseEntity<>(importService.getFileListPaging(request), HttpStatus.OK);
    }

    @PostMapping(value = "/importBankStatement", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> importBankStatement(@RequestPart("file") MultipartFile file, @RequestPart("info") BankStatement bankStatement) {
        return new ResponseEntity<>(importService.importBankStatement(file, bankStatement), HttpStatus.OK);
    }
}
