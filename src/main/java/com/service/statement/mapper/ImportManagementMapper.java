package com.service.statement.mapper;

import com.service.statement.model.BankStatement;
import com.service.statement.model.request.ImportFileRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImportManagementMapper {
    List<BankStatement> search(ImportFileRequest request);

    int count(ImportFileRequest request);

    void importExcel(List<BankStatement> bankStatements);
}
