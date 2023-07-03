package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Attribute;
import com.example.restservice.equipmentData.equipmentDomain.Component;
import com.example.restservice.equipmentData.equipmentDomain.Equipment;
import com.example.restservice.equipmentData.equipmentRepos.AttributeRepo;
import com.example.restservice.equipmentData.equipmentRepos.ComponentRepo;
import com.example.restservice.equipmentData.equipmentRepos.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

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

    @GetMapping("component/{component}")
    public String componentViewForm(
            @PathVariable Component component,
            Model model
    ) {
        model.addAttribute("comp", component);

        Set<Attribute> attr = component.getAttributes();
        model.addAttribute("attributes", attr);

        return "compView";
    }


    @PostMapping("components")
    public String components(
            @RequestParam String myModel,
            @RequestParam String componentName,
            @RequestParam(value = "isComposite", required = false) String isComposite,
            @RequestParam (value="isMechanic", required = false) String isMechanic,
            @RequestParam (value="isElectric", required = false) String isElectric,
            @RequestParam (value="isElectronic", required = false) String isElectronic,

            Model model) {

        Component component = new Component(componentName);
        Equipment equipment = equipmentRepo.findByModel(myModel).get(0);
        if (equipment != null) {
            component.addOwner(equipment);
            if (isComposite != null) {
                component.setIsComposite(true);
            } else {
                component.setIsComposite(false);
            }
            if (isMechanic != null) {
                component.setIsMechanic(true);
            } else {
                component.setIsMechanic(false);
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

        Iterable<Attribute> attributes = attributeRepo.findAll();
        model.addAttribute("attributes", attributes);

        return "component";
    }
}
