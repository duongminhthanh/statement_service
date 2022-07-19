package com.service.statement.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.statement.constant.APIConstant;
import com.service.statement.model.Group;
import com.service.statement.model.request.GroupRequest;
import com.service.statement.model.response.BaseResponse;
import com.service.statement.service.IGroupService;

@RestController
@RequestMapping(value = APIConstant.API_GROUP)
public class GroupController {

	@Autowired
	private IGroupService service;

	@PostMapping(value = "/getGroupPaging", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> getGroupPaging(@RequestBody GroupRequest request) {
		return new ResponseEntity<>(service.paging(request), HttpStatus.OK);
	}

	@PostMapping(value = "/createGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> createGroup(@RequestBody Group request) throws IOException {
		return new ResponseEntity<>(service.createGroup(request), HttpStatus.OK);
	}

	@PostMapping(value = "/updateGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> updateGroup(@RequestBody Group request) throws IOException {
		return new ResponseEntity<>(service.updateGroup(request), HttpStatus.OK);
	}

	@PostMapping(value = "/deleteGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> deleteGroup(@RequestBody Group request) {
		return new ResponseEntity<>(service.deleteGroup(request), HttpStatus.OK);
	}

}
