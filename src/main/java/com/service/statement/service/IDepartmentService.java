package com.service.statement.service;

import java.io.File;
import java.io.IOException;

import com.service.statement.model.Department;
import com.service.statement.model.request.DepartmentRequest;
import com.service.statement.model.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IDepartmentService {

    BaseResponse paging(DepartmentRequest request);

    BaseResponse createDepartment(Department request) throws IOException;

    BaseResponse updateDepartment(Department request) throws IOException;

    Department findDepartmentByCode(String code);

    BaseResponse deleteDepartment(Department request);

    File exportDepartment(DepartmentRequest request);

    BaseResponse importFile(MultipartFile file);
}
