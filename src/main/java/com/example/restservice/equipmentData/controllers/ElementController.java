package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.AttributeValue;
import com.example.restservice.equipmentData.equipmentDomain.Element;
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


//    @GetMapping("/element")
//    public String element(Map<String, Object> model) {
//
//        Iterable<Element> elements = elementRepo.findAll();
//        model.put("elements", elements);
//
//        Iterable<AttributeValue> attributes = attributeValueRepo.findAll();
//        model.put("attributes", attributes);
//
//        return "element";
//    }
//
//    @GetMapping("element/{element}")
//    public String componentViewForm(
//            @PathVariable Element element,
//            Model model
//    ) {
//
//        return "compView";
//    }
//
//    @PostMapping("elements")
//    public String components(
//            @RequestParam String parent,
//            @RequestParam String elementName,
//
//            Model model) {
//
//        Long parentId = Long.valueOf(parent);
//
//        Element element = new Element(elementName);
//        elementRepo.save(element);
//
//        return "element";
//    }
}
