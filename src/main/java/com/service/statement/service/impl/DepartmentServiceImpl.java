package com.service.statement.service.impl;

import com.monitorjbl.xlsx.StreamingReader;
import com.service.statement.common.mapper.CommonMapper;
import com.service.statement.common.service.CommonService;
import com.service.statement.mapper.DepartmentMapper;
import com.service.statement.model.Department;
import com.service.statement.model.Unit;
import com.service.statement.model.request.DepartmentRequest;
import com.service.statement.model.response.BaseListResponse;
import com.service.statement.model.response.BaseResponse;
import com.service.statement.service.IDepartmentService;
import com.service.statement.util.ExportUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper mapper;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private CommonService commonService;

    @Override
    public BaseResponse paging(DepartmentRequest request) {
        List<Department> list = mapper.search(request);
        int totalRecords = mapper.count(request);
        BaseResponse result = new BaseListResponse(list, totalRecords, request.getLimit());
        return result;
    }

    @Override
    public BaseResponse createDepartment(Department request) throws IOException {
        BaseResponse response = new BaseResponse();

        String seq = commonMapper.getID("Dep");
        String pad = commonService.padLeft(seq, 4, "0");

        String id = "Dep" + pad;
        request.setId(id);
        Department departmentExisted = mapper.findDepartmentByCode(request.getCode());
        if (departmentExisted != null) {
            response.setErrorCode("-1");
            response.setErrorDesc("Mã phòng ban đã tồn tại");
            return response;
        }

        Department department = mapper.createDepartment(request);
        if(department != null) {
            response.setData(department);
            response.setErrorCode("0");
            response.setErrorDesc("Tạo thành công");
        } else {
            response.setErrorCode("1");
            response.setErrorDesc("Tạo thất bại");
        }

        return response;
    }

    @Override
    public BaseResponse updateDepartment(Department request) throws IOException {
        BaseResponse response = new BaseResponse();

        Department department = mapper.updateDepartment(request);
        Department departmentExisted = mapper.findDepartmentByCode(request.getCode());
        if (departmentExisted != null) {
            response.setErrorCode("-1");
            response.setErrorDesc("Department code already exists");
            return response;

        }
        if(department != null) {
            response.setData(department);
            response.setErrorCode("0");
            response.setErrorDesc("Tạo thành công");
        } else {
            response.setErrorCode("1");
            response.setErrorDesc("Tạo thất bại");
        }

        return response;
    }

    @Override
    public Department findDepartmentByCode(String code) {
        return mapper.findDepartmentById(code);
    }

    @Override
    public BaseResponse deleteDepartment(Department request) {
        BaseResponse response = new BaseResponse();

        int departmentDeleted = mapper.deleteDepartment(request.getId());
        if(departmentDeleted > 0) {
            response.setErrorCode("0");
            response.setErrorDesc("Xóa thành công");
        } else {
            response.setErrorCode("1");
            response.setErrorDesc("Xóa thất bại");
        }

        return response;
    }

    @Override
    public File exportDepartment(DepartmentRequest request) {
        File file = null;

        try {

            file = File.createTempFile("out", ".tmp");
            file.deleteOnExit();
            Resource resource = new ClassPathResource("templates/Department_1.jasper");
            try (FileOutputStream fos = new FileOutputStream(file);
                 InputStream inputStream = resource.getInputStream();)
            {
                List<Department> list = request.getF();

                // Get list code category
                if (!list.isEmpty()) {
                    list.add(0, new Department());
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("printDate",cal.getTime());
                ExportUtil.exportReport(inputStream, fos,parameters, list, request.getFileType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
    private BaseResponse responseStatus(String code, String desc) {
        BaseResponse response = new BaseResponse();
        response.setErrorCode(code);
        response.setErrorDesc(desc);
        return response;
    }

    private String generateUnitId() {
        String seq = commonMapper.getID("d");
        String pad = commonService.padLeft(seq, 4, "0");

        return "d" + pad;
    }


    @Override
    public BaseResponse importFile(MultipartFile file) {
        if (file != null) {
            try (@SuppressWarnings("deprecation")
                 StreamingReader reader = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).sheetIndex(0)
                    .read(file.getInputStream())) {
                @SuppressWarnings("deprecation")
                Iterator<Row> rowIterator = reader.iterator();
                Row row = rowIterator.next(); // Bỏ qua head


                List<Department> departments = new ArrayList<>();
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();
                    Department department = new Department();

                    Cell code = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell name = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell nameEn = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell createdDate = row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell unitCode = row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    department.setId(generateUnitId());
                    department.setCode(code.getStringCellValue());
                    department.setName(name.getStringCellValue());
                    department.setNameEn(nameEn.getStringCellValue());
                    department.setCreatedDate(createdDate.getStringCellValue());
                    department.setUnit(unitCode.getStringCellValue());
                    departments.add(department);
                    mapper.importExcel(departments);
                    departments.clear();

                }
//                if (index > 0) {
//                    mapper.importExcel(units);
//                    units.clear();
//                }
                return responseStatus("0", "Import thành công");
            } catch (Exception e) {
                return responseStatus("1", "Import thất bại");
            }
        }
        return responseStatus("1", "Import thất bại");

    }
}
