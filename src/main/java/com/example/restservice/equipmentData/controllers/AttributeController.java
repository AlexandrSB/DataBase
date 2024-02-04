package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Attribute;
import com.example.restservice.equipmentData.equipmentRepos.AttributeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AttributeController {

    @Autowired
    private AttributeRepo attributeRepo;

    @PostMapping("addAttr")
    private String addAttribute(
            @RequestParam String attribute_name,
            @RequestParam String path
    ) {

        if (attributeRepo.findByName(attribute_name).isPresent()) {
            return "redirect:" + path;
        }

        Attribute attribute = new Attribute();
        attribute.setName(attribute_name);
        attributeRepo.save(attribute);

        return "redirect:" + path;
    }
}
