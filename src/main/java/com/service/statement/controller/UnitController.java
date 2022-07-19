package com.service.statement.controller;

import com.service.statement.constant.APIConstant;
import com.service.statement.model.Unit;
import com.service.statement.model.UserDemo;
import com.service.statement.model.request.UnitRequest;
import com.service.statement.model.response.BaseResponse;
import com.service.statement.service.IUnitService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping(value = APIConstant.API_UNIT)
public class UnitController {
    @Autowired
    private IUnitService service;

    @PostMapping(value = "/getUnitPaging", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getUnitPaging(@RequestBody UnitRequest request) {
        return new ResponseEntity<>(service.getUnitPaging(request), HttpStatus.OK);
    }
//    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
////    public ResponseEntity<BaseResponse> findUnitByCode(@RequestBody Unit code) {
////        return new ResponseEntity<>(service.findUnitByCode(code), HttpStatus.OK);
////    }
    @PostMapping(value = "/createUnit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createUnit(@RequestBody Unit request) throws IOException {
        return new ResponseEntity<>(service.createUnit(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateUnit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateUnit(@RequestBody Unit request) throws IOException {
        return new ResponseEntity<>(service.updateUnit(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteUnit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteGroup(@RequestBody Unit request) {
        return new ResponseEntity<>(service.deleteUnit(request), HttpStatus.OK);
    }
    @PostMapping(value = "/exportUnit", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> exportBankStatementList(@RequestBody UnitRequest request) {
        try {
            File file = service.exportUnit(request);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().headers(new HttpHeaders()).contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/" + request.getFileType())).body(resource);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            throw new Exception("Lỗi xuất đơn vị");
            return null;
        }
    }
    @PostMapping(value = "/importUnit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> importUnit(@RequestPart("file") MultipartFile file) {
        return new ResponseEntity<>(service.importFile(file), HttpStatus.OK);
    }
}
