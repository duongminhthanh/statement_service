package com.service.statement.service;

import com.service.statement.model.Unit;
import com.service.statement.model.request.UnitRequest;
import com.service.statement.model.response.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


public interface IUnitService {
    BaseResponse getUnitPaging(UnitRequest request);

    BaseResponse createUnit(Unit request);

    BaseResponse updateUnit(Unit request);

    Unit findUnitByCode(String code);

    BaseResponse deleteUnit(Unit request);

    File exportUnit(UnitRequest request);

    BaseResponse importFile(MultipartFile file);

}
