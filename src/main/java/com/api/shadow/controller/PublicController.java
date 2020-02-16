package com.api.shadow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.shadow.constants.VariableConstants;
import com.api.shadow.dao.repository.VersionRepository;
import com.api.shadow.modal.entity.UserEntity;
import com.api.shadow.response.ApiResponseVersionObject;
import com.api.shadow.service.UserService;

@RestController
@RequestMapping("/pub")
public class PublicController {

	@Autowired
	UserService userService;

	@Autowired
	VersionRepository versionRepository;

	@GetMapping(produces = "application/json")
	@ResponseBody
	public ApiResponseVersionObject version() {
		return new ApiResponseVersionObject(HttpStatus.OK, VariableConstants.SUCCESS,
				versionRepository.findByIsAuthenticated(VariableConstants.FLAG_Y));
	}

	@RequestMapping(value = "/create-user", method = RequestMethod.POST)
	public UserEntity create(@RequestBody UserEntity user) {
		return userService.save(user);
	}
}
