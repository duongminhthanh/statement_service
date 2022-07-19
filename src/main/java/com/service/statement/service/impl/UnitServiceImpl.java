package com.service.statement.service.impl;


import com.monitorjbl.xlsx.StreamingReader;
import com.service.statement.common.mapper.CommonMapper;
import com.service.statement.common.service.CommonService;
import com.service.statement.mapper.UnitMapper;
import com.service.statement.model.Unit;
import com.service.statement.model.request.UnitRequest;
import com.service.statement.model.response.BaseListResponse;
import com.service.statement.model.response.BaseResponse;
import com.service.statement.service.IUnitService;
import com.service.statement.util.ExportUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;



@Service
public class UnitServiceImpl implements IUnitService {
    @Autowired
    private UnitMapper mapper;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private CommonService commonService;

    @Value("${size.list.data}")
    private int sizeData;

    @Override
    public BaseResponse getUnitPaging(UnitRequest request) {
        List<Unit> list = mapper.search(request);
        int totalRecords = mapper.count(request);
        BaseResponse result = new BaseListResponse(list, totalRecords, request.getLimit());
        return result;
    }

    @Override
    public BaseResponse createUnit(Unit request) {
        BaseResponse response = new BaseResponse();
        String seq = commonMapper.getID("G");
        String pad = commonService.padLeft(seq, 4, "0");
        String id = "G" + pad;
        request.setId(id);
        Unit unitExisted = mapper.findUnitByCode(request.getCode());
        if (unitExisted != null) {
            response.setErrorCode("-1");
            response.setErrorDesc("Unit code already exists");
            return response;
        }

        Unit unit = mapper.createUnit(request);
        if (unit != null) {
            response.setData(unit);
            response.setErrorCode("0");
            response.setErrorDesc("Tạo thành công");
        } else {
            response.setErrorCode("1");
            response.setErrorDesc("Tạo thất bại");
        }
        return response;
    }

    @Override
    public BaseResponse updateUnit(Unit request) {
        BaseResponse response = new BaseResponse();
//        Unit unitExisted = mapper.findUnitByCode(request.getCode());
//        if (unitExisted != null) {
//            response.setErrorCode("-1");
//            response.setErrorDesc("Unit code already exists");
//            return response;
//        }
        Unit unit = mapper.updateUnit(request);
        if (unit != null) {
            response.setData(unit);
            response.setErrorCode("0");
            response.setErrorDesc("Tạo thành công");
        } else {
            response.setErrorCode("1");
            response.setErrorDesc("Tạo thất bại");
        }

        return response;
    }

    @Override
    public Unit findUnitByCode(String code) {
        return mapper.findUnitByCode(code);
    }

    @Override
    public BaseResponse deleteUnit(Unit request) {
        BaseResponse response = new BaseResponse();

        int unitDeleted = mapper.deleteUnit(request.getId());
        if (unitDeleted > 0) {
            response.setErrorCode("0");
            response.setErrorDesc("Xóa thành công");
        } else {
            response.setErrorCode("1");
            response.setErrorDesc("Xóa thất bại");
        }

        return response;
    }

    private BaseResponse responseStatus(String code, String desc) {
        BaseResponse response = new BaseResponse();
        response.setErrorCode(code);
        response.setErrorDesc(desc);
        return response;
    }

    @Override
    public File exportUnit(UnitRequest request) {
        File file = null;

        try {

            file = File.createTempFile("out", ".tmp");
            file.deleteOnExit();
            Resource resource = new ClassPathResource("templates/Unit_1.jasper");
            try (FileOutputStream fos = new FileOutputStream(file);
                 InputStream inputStream = resource.getInputStream();) {
                List<Unit> list = request.getF();

                // Get list code category
                if (!list.isEmpty()) {
                    list.add(0, new Unit());
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                Map<String, Object> parameters = new HashMap<>();
                // parameters.put("printDate",cal.getTime());
                ExportUtil.exportReport(inputStream, fos, null, list, request.getFileType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
    private String generateUnitId() {
        String seq = commonMapper.getID("U");
        String pad = commonService.padLeft(seq, 4, "0");

        return "U" + pad;
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


                List<Unit> units = new ArrayList<>();
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();
                    Unit unit = new Unit();

                    Cell code = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell name = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell nameEn = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell createdDate = row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    unit.setId(generateUnitId());
                    unit.setCode(code.getStringCellValue());
                    unit.setName(name.getStringCellValue());
                    unit.setNameEn(nameEn.getStringCellValue());
                  //  unit.setCreater(creater);
                    unit.setCreatedDate(createdDate.getStringCellValue());
                    units.add(unit);
                    mapper.importExcel(units);
                    units.clear();

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

