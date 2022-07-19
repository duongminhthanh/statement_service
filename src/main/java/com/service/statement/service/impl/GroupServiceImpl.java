package com.service.statement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.statement.common.mapper.CommonMapper;
import com.service.statement.common.service.CommonService;
import com.service.statement.mapper.GroupMapper;
import com.service.statement.model.Group;
import com.service.statement.model.request.GroupRequest;
import com.service.statement.model.response.BaseListResponse;
import com.service.statement.model.response.BaseResponse;
import com.service.statement.service.IGroupService;

@Service
public class GroupServiceImpl implements IGroupService {

	@Autowired
	private GroupMapper mapper;

	@Autowired
	private CommonMapper commonMapper;

	@Autowired
	private CommonService commonService;

	@Override
	public BaseResponse paging(GroupRequest request) {
		List<Group> list = mapper.search(request);
		int totalRecords = mapper.count(request);
		BaseResponse result = new BaseListResponse(list, totalRecords, request.getLimit());
		return result;
	}

	@Override
	public BaseResponse createGroup(Group request) {
		BaseResponse response = new BaseResponse();
		String seq = commonMapper.getID("G");
		String pad = commonService.padLeft(seq, 4, "0");
		String id = "G" + pad;
		request.setId(id);
		Group groupExisted = mapper.findGroupByCode(request.getCode());
		if (groupExisted != null) {
			response.setErrorCode("-1");
			response.setErrorDesc("Group code already exists");
			return response;
		}

		Group group = mapper.createGroup(request);
		if (group != null) {
			response.setData(group);
			response.setErrorCode("0");
			response.setErrorDesc("Tạo thành công");
		} else {
			response.setErrorCode("1");
			response.setErrorDesc("Tạo thất bại");
		}
		return response;

	}

	@Override
	public BaseResponse updateGroup(Group request) {
		BaseResponse response = new BaseResponse();

		Group group = mapper.updateGroup(request);
		if (group != null) {
			response.setData(group);
			response.setErrorCode("0");
			response.setErrorDesc("Tạo thành công");
		} else {
			response.setErrorCode("1");
			response.setErrorDesc("Tạo thất bại");
		}

		return response;
	}

	@Override
	public Group findGroupByCode(String code) {
		return mapper.findGroupByCode(code);
	}

	@Override
	public BaseResponse deleteGroup(Group request) {
		BaseResponse response = new BaseResponse();

		int groupDeleted = mapper.deleteGroup(request.getId());
		if (groupDeleted > 0) {
			response.setErrorCode("0");
			response.setErrorDesc("Xóa thành công");
		} else {
			response.setErrorCode("1");
			response.setErrorDesc("Xóa thất bại");
		}

		return response;
	}

}
