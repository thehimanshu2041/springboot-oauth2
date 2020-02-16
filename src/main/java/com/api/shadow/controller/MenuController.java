package com.api.shadow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.shadow.modal.entity.MenuEntity;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

	@GetMapping(value = "menu-list", produces = "application/json")
	@ResponseBody
	public MenuEntity menuList() throws Exception {
		return null;
	}
}
