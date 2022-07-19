package com.service.statement.controller;

import com.service.statement.constant.APIConstant;
import com.service.statement.model.Department;
import com.service.statement.model.request.DepartmentRequest;
import com.service.statement.model.response.BaseResponse;
import com.service.statement.service.IDepartmentService;
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
@RequestMapping(value = APIConstant.API_DEPARTMENT)
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @PostMapping(value = "/getDepartmentPaging", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getDepartmentPaging(@RequestBody DepartmentRequest request) {
        return new ResponseEntity<>(departmentService.paging(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createDepartment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createDepartment(@RequestBody Department request) throws IOException {
        return new ResponseEntity<>(departmentService.createDepartment(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateDepartment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateDepartment(@RequestBody Department request) throws IOException {
        return new ResponseEntity<>(departmentService.updateDepartment(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteDepartment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteDepartment(@RequestBody Department request) {
        return new ResponseEntity<>(departmentService.deleteDepartment(request), HttpStatus.OK);
    }

    @PostMapping(value = "/exportDepartment", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> exportDepartment(@RequestBody DepartmentRequest request) {
        try {
            File file = departmentService.exportDepartment(request);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().headers(new HttpHeaders()).contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/" + request.getFileType())).body(resource);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            throw new Exception("Lỗi xuất nhân viên");
            return null;
        }
    }
    @PostMapping(value = "/importDepartment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> importDepartment(@RequestPart("file") MultipartFile file) {
        return new ResponseEntity<>(departmentService.importFile(file), HttpStatus.OK);
    }
}
