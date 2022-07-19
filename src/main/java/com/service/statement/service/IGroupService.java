package com.service.statement.service;

import com.service.statement.model.Group;
import com.service.statement.model.request.GroupRequest;
import com.service.statement.model.response.BaseResponse;

public interface IGroupService {
	BaseResponse paging(GroupRequest request);

	BaseResponse createGroup(Group request);

	BaseResponse updateGroup(Group request);

	Group findGroupByCode(String code);

	BaseResponse deleteGroup(Group request);

}
