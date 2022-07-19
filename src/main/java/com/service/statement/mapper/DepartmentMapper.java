package com.service.statement.mapper;

import com.service.statement.model.Department;
import com.service.statement.model.Unit;
import com.service.statement.model.request.DepartmentRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface DepartmentMapper {

    List<Department> search(DepartmentRequest request);

    int count(DepartmentRequest request);

    int countAll();

    Department findDepartmentById(String id);

    Department findDepartmentByCode(String code);

    Department createDepartment(Department request);

    Department updateDepartment(Department request);

    int deleteDepartment(String id);

    void importExcel(List<Department> departments);
    void exportExcel(List<Department> departments);

}
