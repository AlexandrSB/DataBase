package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentRepos.AttributeRepo;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ElementController {

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private AttributeRepo attributeRepo;


    @GetMapping("/element")
    public String showElement(Model model) {

        Iterable<Element> elements = elementRepo.findAll();
        model.addAttribute("elements", elements);

//        Iterable<Attribute> attributes = attributeRepo.findAll();
//        model.put("attributes", attributes);

        return "element";
    }

    @GetMapping("element/{elem}")
    public String componentViewForm(
            @PathVariable Element element,
            Model model
    ) {

        return "element";
    }


    @PostMapping("add_element")
    public String addElement(
            @RequestParam String elementName,
            @RequestParam String description,
            @RequestParam String parent,
            Model model) {

        Element elem= new Element();
        elem.setName(elementName);
        elem.setDescription(description);
        elem.setParent(elementRepo.findByName(parent));
        elementRepo.save(elem);

//        Iterable<Attribute> attributes = attributeRepo.findAll();
//        model.addAttribute("attributes", attributes);

        return "element";
    }
}
