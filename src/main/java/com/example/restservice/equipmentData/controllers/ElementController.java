package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.Group;
import com.example.restservice.equipmentData.equipmentRepos.AttributeRepo;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.equipmentData.equipmentRepos.GroupRecursiveRepo;
import com.example.restservice.equipmentData.equipmentRepos.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/element")
public class ElementController {

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private GroupRecursiveRepo groupRecursiveRepo;


    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("group", groupRecursiveRepo.findAll());

        Iterable<Element> elements = elementRepo.findAll();
        model.addAttribute("elements", elements);
    }

    @GetMapping("/{group_id}")
    public String showElements(
        @PathVariable String group_id,
        Model model) {

        Optional<Group> group = groupRepo.findById(Long.valueOf(group_id));
        model.addAttribute("my_group", group.get());


        return "element";
    }

    @PostMapping("add_element")
    public String addElement(
            @RequestParam String group_name,
            @RequestParam String elementName,
            @RequestParam String description,
            @RequestParam String parent,
            Model model) {

        Optional<Group> group = Optional.ofNullable(
                groupRepo.findByGroupName(group_name).get(0)
        );
        model.addAttribute("my_group", group.get());

        Element elem= new Element();
        elem.setName( elementName.trim() );
        elem.setDescription( description.trim() );
        elem.setParent(elementRepo.findByName( parent ));
        elem.addGroup(group);
        elementRepo.save( elem );

//        Iterable<Attribute> attributes = attributeRepo.findAll();
//        model.addAttribute("attributes", attributes);

        return "element/"+group;
    }
}
