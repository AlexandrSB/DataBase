package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Attribute;
import com.example.restservice.equipmentData.equipmentDomain.Component;
import com.example.restservice.equipmentData.equipmentDomain.EnumUnits;
import com.example.restservice.equipmentData.equipmentRepos.AttributeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.restservice.equipmentData.equipmentRepos.ComponentRepo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AttributeController {
    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private ComponentRepo componentRepo;
    @GetMapping("/addAttribute")
    public String addAttributeGet(Model model) {

        Iterable<Component> components = componentRepo.findAll();
        model.addAttribute("components", components);

        Iterable<EnumUnits> enumUnits = List.of(EnumUnits.values());
        model.addAttribute("units", enumUnits);

        return "addAttribute";
    }

    @PostMapping("addAttribute")
    public String addAttributePost(
            @RequestParam String comp,
            @RequestParam String attr,
            @RequestParam String val,
            @RequestParam String un,
            Model model
    ) {
        Component component = componentRepo.findByName(comp);
        Attribute attribute = new Attribute(attr);
        attribute.addComponent(component);
        attribute.addValues(val);
        attribute.setUnit(EnumUnits.valueOf(un));

        attributeRepo.save(attribute);

        return "addAttribute";
    }
}
