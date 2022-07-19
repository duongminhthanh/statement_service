package com.service.statement.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.statement.model.Group;
import com.service.statement.model.request.GroupRequest;

@Service
public interface GroupMapper {

	List<Group> search(GroupRequest request);

	int count(GroupRequest request);

	int countAll();

	Group findGroupById(String id);

	Group findGroupByCode(String code);

	Group createGroup(Group request);

	Group updateGroup(Group request);

	int deleteGroup(String id);
}
