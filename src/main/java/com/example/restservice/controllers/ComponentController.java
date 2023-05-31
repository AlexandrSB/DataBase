package com.example.restservice.controllers;

import com.example.restservice.data.domain.Attribute;
import com.example.restservice.data.domain.Component;
import com.example.restservice.data.domain.Equipment;
import com.example.restservice.data.repos.AttributeRepo;
import com.example.restservice.data.repos.ComponentRepo;
import com.example.restservice.data.repos.EquipmentRepo;
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

    @Autowired
    private AttributeRepo attributeRepo;


    @GetMapping("/component")
    public String component(Map<String, Object> model) {

        Iterable<Equipment> equipments = equipmentRepo.findAll();
        model.put("equipments", equipments);

        Iterable<Component> components = componentRepo.findAll();
        model.put("components", components);

        Iterable<Attribute> attributes = attributeRepo.findAll();
        model.put("attributes", attributes);

        return "component";
    }

    @PostMapping("addComponent")
    public String components(
            @RequestParam String myModel,
            @RequestParam(value = "comp", required = false) String compName,
            @RequestParam String name,
            @RequestParam(value = "attribute", required = false) String attr,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "isComposite", required = false) String isComposite,
            @RequestParam(value = "isMechanic", required = false) String isMechanic,
            @RequestParam(value = "isElectric", required = false) String isElectric,
            @RequestParam(value = "isElectronic", required = false) String isElectronic,
            Model model) {

        Component component = new Component(name);
        if (compName != null && compName != "") {
            Component componentParent = componentRepo.findByName(compName);
            component.addRelationship(componentParent);
        }

        if (attr != null) {
            Attribute attribute = attributeRepo.findByName(attr);
            component.addAttribute(attribute);
        }

        Equipment equipment = equipmentRepo.findByModel(myModel).get(0);

        if (equipment != null) {
            component.addOwner(equipment);

            if (description != null) {
                component.setDescription(description);
            }

            if (isComposite != null) {
                component.setIsComposite(true);
            } else {
                component.getIsComposite();
            }

            if (isMechanic != null) {
                component.setIsMechanic(true);
            } else {
                component.getIsMechanic();
            }

            if (isElectric != null) {
                component.setIsElectric(true);
            } else {
                component.setIsElectric(false);
            }

            if (isElectronic != null) {
                component.setIsElectronic(true);
            } else {
                component.setIsElectronic(false);
            }
            componentRepo.save(component);
        }

        Iterable<Equipment> equipments = equipmentRepo.findAll();
        model.addAttribute("equipments", equipments);

        Iterable<Component> components = componentRepo.findAll();
        model.addAttribute("components", components);

        return "component";
    }
}
