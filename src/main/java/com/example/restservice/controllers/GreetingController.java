package com.example.restservice;

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

	@GetMapping("/equipment")
	public String equipment(Map<String, Object> model) {
		Iterable<EnumTypeOfEquipment> enumTypeOfEquipments =
				List.of(EnumTypeOfEquipment.values());
		model.put("types", enumTypeOfEquipments);

		Iterable<EnumFirma> enumFirmas = List.of(EnumFirma.values());
		model.put("firmas", enumFirmas);

		Iterable<Equipment> equipments = equipmentRepo.findAll();
		model.put("equipments", equipments);

		return "equipment";
	}

	@PostMapping("equipments")
	public String equip(
			@RequestParam String firmName,
			@RequestParam String myModel,
			@RequestParam String type,
			Map<String, Object> model) {

		Iterable<EnumTypeOfEquipment> enumTypeOfEquipments =
				List.of(EnumTypeOfEquipment.values());
		model.put("types", enumTypeOfEquipments);

		Iterable<EnumFirma> enumFirmas = List.of(EnumFirma.values());
		model.put("firmas", enumFirmas);

		EnumFirma enumFirma = EnumFirma.valueOf(firmName);
		EnumTypeOfEquipment enumTypeOfEquipment =
				EnumTypeOfEquipment.valueOf(type);
		try {
			Equipment equipment = new Equipment(enumFirma, myModel, enumTypeOfEquipment);
			equipmentRepo.save(equipment);
		} catch (Exception e) {
			return "main";
		}

		Iterable<Equipment> equipments = equipmentRepo.findAll();
		model.put("equipments", equipments);

		return "equipment";
	}

	@GetMapping("/component")
	public String component(Map<String, Object> model) {

		Iterable<Equipment> equipments = equipmentRepo.findAll();
		model.put("equipments", equipments);

		Iterable<Component> components = componentRepo.findAll();
		model.put("components", components);

		return "component";
	}

	@PostMapping("components")
	public String components(
			@RequestParam String myModel,
			@RequestParam String name,
			Map<String, Object> model) {

		Component component = new Component(name);
		Equipment equipment = equipmentRepo.findByModel(myModel).get(0);
		if (equipment != null) {
			component.setOwner(equipment);
			componentRepo.save(component);
		}

		Iterable<Equipment> equipments = equipmentRepo.findAll();
		model.put("equipments", equipments);

		Iterable<Component> components = componentRepo.findAll();
		model.put("components", components);

		return "component";
	}
}
