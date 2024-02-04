package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.AttributeGroup;
import com.example.restservice.equipmentData.equipmentRepos.AttributeGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AttributeGroupController {

    @Autowired
    private AttributeGroupRepo attributeGroupRepo;

    @PostMapping("addAttrGroup")
    private String addAttributeGroup(
            @RequestParam String attribute_group_name,
            @RequestParam String path

    ) {

        if (attributeGroupRepo.findByName(attribute_group_name).isPresent()) {
            return "redirect:" + path;
        }

        AttributeGroup attributeGroup = new AttributeGroup();
        attributeGroup.setName(attribute_group_name);
        attributeGroupRepo.save(attributeGroup);

        return "redirect:" + path;
    }
}
