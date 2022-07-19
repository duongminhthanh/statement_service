package com.service.statement.mapper;

import com.service.statement.exceptions.EtAuthException;
import com.service.statement.model.Unit;
import com.service.statement.model.UserDemo;
import com.service.statement.model.request.UnitRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UnitMapper {
    List<Unit> search(UnitRequest request);

    int count(UnitRequest request);

    int countAll();

    Unit findUnitById(String id);

    Unit findUnitByCode(String code);

    Unit createUnit(Unit request);

    Unit updateUnit(Unit request);

    int deleteUnit(String id);

    void exportExcel(List<Unit> units);

    Integer getCountByUnitCode(String code) throws EtAuthException;

    void importExcel(List<Unit> units);

}
