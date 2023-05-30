package com.example.restservice.controllers;

import com.example.restservice.data.domain.Component;
import com.example.restservice.data.domain.Equipment;
import com.example.restservice.data.repos.ComponentRepo;
import com.example.restservice.data.repos.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ComponentController {

    @Autowired
    private ComponentRepo componentRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;


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
            component.addOwner(equipment);
            componentRepo.save(component);
        }

        Iterable<Equipment> equipments = equipmentRepo.findAll();
        model.put("equipments", equipments);

        Iterable<Component> components = componentRepo.findAll();
        model.put("components", components);

        return "component";
    }
}
