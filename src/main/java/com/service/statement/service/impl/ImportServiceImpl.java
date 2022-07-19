package com.service.statement.service.impl;

import com.monitorjbl.xlsx.StreamingReader;
import com.service.statement.common.mapper.CommonMapper;
import com.service.statement.common.service.CommonService;
import com.service.statement.exceptions.EtAuthException;
import com.service.statement.mapper.ImportManagementMapper;
import com.service.statement.model.BankStatement;
import com.service.statement.model.User;
import com.service.statement.model.request.ImportFileRequest;
import com.service.statement.model.response.BaseListResponse;
import com.service.statement.model.response.BaseResponse;
import com.service.statement.service.IImportService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class ImportServiceImpl implements IImportService {

    @Autowired
    private ImportManagementMapper importManagementMapper;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private CommonService commonService;

    @Value("${size.list.data}")
    private int sizeData;


    @Override
    public BaseResponse importBankStatement(MultipartFile file, BankStatement bankStatementReq) {
        System.out.println(file != null);
        if (file != null) {
            try (@SuppressWarnings("deprecation")
                 StreamingReader reader = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).sheetIndex(0)
                    .read(file.getInputStream())) {
                @SuppressWarnings("deprecation")
                Iterator<Row> rowIterator = reader.iterator();
                Row row = rowIterator.next(); // Bỏ qua head

                int index = 0;

                List<BankStatement> bankStatements = new ArrayList<>();
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();
                    BankStatement bankStatement = new BankStatement();

                    Cell bank_code = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell branch_code = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell statement_number = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell from_date = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell to_date = row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell superior_branch_code = row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell accnoo = row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell custno = row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell posttype = row.getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell orderno = row.getCell(9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell notranfalg = row.getCell(10, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    bankStatement.setId(generateBankStatementId());
                    bankStatement.setBankCode(bank_code.getStringCellValue());
                    bankStatement.setBranchCode(branch_code.getStringCellValue());
                    bankStatement.setStatementNumber(statement_number.getStringCellValue());
                    bankStatement.setFromDate(from_date.getDateCellValue());
                    bankStatement.setToDate(to_date.getDateCellValue());
                    bankStatement.setSuperiorBranchCode(superior_branch_code.getStringCellValue());
                    bankStatement.setAccnoo(accnoo.getStringCellValue());
                    bankStatement.setCustno(custno.getStringCellValue());
                    bankStatement.setPosttype(posttype.getStringCellValue());
                    bankStatement.setOrderno(orderno.getStringCellValue());
                    bankStatement.setNotranfalg(notranfalg.getStringCellValue());
                    bankStatement.setStatus("Imported");
                    bankStatement.setFileName(file.getOriginalFilename());
                    bankStatement.setFileType("excel");
                    bankStatement.setCreater(bankStatementReq.getCreater());
                    bankStatements.add(bankStatement);
                    index++;

                    if (index >= sizeData) {
                        importManagementMapper.importExcel(bankStatements);
                        bankStatements.clear();
                        index = 0;
                    }
                }
                if (index > 0) {
                    importManagementMapper.importExcel(bankStatements);
                    bankStatements.clear();
                }
                return responseStatus("0", "Import thành công");
            } catch (Exception e) {
                e.printStackTrace();
                return responseStatus("1", "Import thất bại");
            }
        }
        return responseStatus("1", "Import thất bại");
    }

    @Override
    public BaseResponse getFileListPaging(ImportFileRequest request) {
        List<BankStatement> list = importManagementMapper.search(request);
        int totalRecords = importManagementMapper.count(request);
        BaseResponse result = new BaseListResponse(list, totalRecords, request.getLimit());
        return result;
    }

    private BaseResponse responseStatus(String code, String desc) {
        BaseResponse response = new BaseResponse();
        response.setErrorCode(code);
        response.setErrorDesc(desc);
        return response;
    }

    private String generateBankStatementId() {
        String seq = commonMapper.getID("BS");
        String pad = commonService.padLeft(seq, 4, "0");

        return "BS" + pad;
    }
}
