package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.AttributeValue;
import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.Equipment;
import com.example.restservice.equipmentData.equipmentRepos.AttributeValueRepo;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ElementController {

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private AttributeValueRepo attributeValueRepo;


    @GetMapping("/component")
    public String component(Map<String, Object> model) {

        Iterable<Element> components = elementRepo.findAll();
        model.put("components", components);

        Iterable<AttributeValue> attributes = attributeValueRepo.findAll();
        model.put("attributes", attributes);

        return "component";
    }

    @GetMapping("element/{element}")
    public String componentViewForm(
            @PathVariable Element element,
            Model model
    ) {


        return "compView";
    }


    @PostMapping("elements")
    public String components(
            @RequestParam String parent,
            @RequestParam String elementName,

            Model model) {

        Long parentId = Long.valueOf(parent);

        Element element = new Element(elementName);
        if (parent != "<none>") {
            element.setParent(elementRepo.findByName(elementName));
        }
        elementRepo.save(element);

        return "component";
    }
}
