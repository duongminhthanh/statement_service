package com.service.statement.service;

import com.service.statement.model.BankStatement;
import com.service.statement.model.request.ImportFileRequest;
import com.service.statement.model.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IImportService {
    BaseResponse importBankStatement(MultipartFile file, BankStatement bankStatement);

    BaseResponse getFileListPaging(ImportFileRequest request);
}
