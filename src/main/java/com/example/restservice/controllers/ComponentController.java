package com.example.restservice.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Component;
import com.example.restservice.equipmentData.equipmentDomain.Equipment;
import com.example.restservice.equipmentData.equipmentRepos.ComponentRepo;
import com.example.restservice.equipmentData.equipmentRepos.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
            @RequestParam Boolean isComposite,
            @RequestParam Boolean isMechanic,
            @RequestParam Boolean isElectric,
            @RequestParam Boolean isElectronic,

            Model model) {

        Component component = new Component(name);
        Equipment equipment = equipmentRepo.findByModel(myModel).get(0);
        if (equipment != null) {
            component.addOwner(equipment);
            component.getIsComposite();
            component.getIsMechanic();
            if (isElectric) { component.setIsElectric(isElectric); }
            if (isElectronic) { component.setIsElectronic(isElectronic); }

            componentRepo.save(component);
        }

        Iterable<Equipment> equipments = equipmentRepo.findAll();
        model.addAttribute("equipments", equipments);

        Iterable<Component> components = componentRepo.findAll();
        model.addAttribute("components", components);

        return "component";
    }
}
