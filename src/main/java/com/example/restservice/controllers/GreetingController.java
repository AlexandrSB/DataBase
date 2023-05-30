package com.example.restservice.controllers;

import java.util.List;
import java.util.Map;

import com.example.restservice.data.domain.*;
import com.example.restservice.data.repos.ComponentRepo;
import com.example.restservice.data.repos.EquipmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	@Autowired
	private EquipmentRepo equipmentRepo;
	@Autowired
	private ComponentRepo componentRepo;

	@GetMapping("/greeting")
	public String greeting(
			@RequestParam(name = "name",
					required = false,
					defaultValue = "World") String name,
			Map<String, Object> model) {

		model.put("name", name);
		return "greeting";
	}

	@GetMapping("/")
	public String main(Map<String, Object> model) {

		return "main";
	}


}
