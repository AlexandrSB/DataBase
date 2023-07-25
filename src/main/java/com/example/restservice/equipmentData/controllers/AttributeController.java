package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Attribute;
import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.Unit;
import com.example.restservice.equipmentData.equipmentRepos.AttributeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AttributeController {
    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private ElementRepo componentRepo;
    @GetMapping("/addAttribute")
    public String addAttributeGet(Model model) {

        Iterable<Element> components = componentRepo.findAll();
        model.addAttribute("components", components);

//        Iterable<Unit> enumUnits = List.of(Unit.values());
//        model.addAttribute("units", enumUnits);

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
        Element element = componentRepo.findByName(comp);
        Attribute attribute = new Attribute(attr);
//        attribute.addComponent(element);
//        attribute.addValues(val);
//        attribute.setUnit(Unit.valueOf(un));

        attributeRepo.save(attribute);

        return "addAttribute";
    }
}
