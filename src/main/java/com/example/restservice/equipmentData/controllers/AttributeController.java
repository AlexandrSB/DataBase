package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Attribute;
import com.example.restservice.equipmentData.equipmentDomain.AttributeDictionary;
import com.example.restservice.equipmentData.equipmentDomain.AttributeGroup;
import com.example.restservice.equipmentData.equipmentDomain.AttributeGroupDictionary;
import com.example.restservice.equipmentData.equipmentRepos.AttributeDictionaryRepo;
import com.example.restservice.equipmentData.equipmentRepos.AttributeGroupDictionaryRepo;
import com.example.restservice.equipmentData.equipmentRepos.AttributeGroupRepo;
import com.example.restservice.equipmentData.equipmentRepos.AttributeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AttributeController {

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeDictionaryRepo attributeDictionaryRepo;

    @Autowired
    private AttributeGroupRepo attributeGroupRepo;

    @Autowired
    private AttributeGroupDictionaryRepo attributeGroupDictionaryRepo;

    @PostMapping("addAttrName")
    private String addAttributeName(
            @RequestParam String attribute_name,
            @RequestParam String attr_group_dic_id,
            @RequestParam String path
    ) {

        Long attrGroupId = Long.valueOf(attr_group_dic_id);

        if (attributeDictionaryRepo.findByName(attribute_name)
                .isPresent()) {
            return "redirect:" + path;
        }

        AttributeGroupDictionary attributeGroupDictionary =
                attributeGroupDictionaryRepo
                        .findById(attrGroupId)
                        .orElseThrow();

        AttributeDictionary attributeDictionary = new AttributeDictionary();
        attributeDictionary.setName(attribute_name);
        attributeDictionary.setAttributeGroupDictionary(attributeGroupDictionary);
        attributeDictionaryRepo.save(attributeDictionary);

        return "redirect:" + path;
    }

    @PostMapping("addAttribute")
    private String addAttribute(
            @RequestParam String attr_group_id,
            @RequestParam String attr_name,
            @RequestParam String path
    ) {

        Long attrGroupId = Long.valueOf(attr_group_id);

        AttributeGroup attributeGroup =
                attributeGroupRepo
                        .findById(attrGroupId)
                        .orElseThrow();

        AttributeDictionary attributeDictionary =
                attributeDictionaryRepo
                        .findByName(attr_name)
                        .orElseThrow();

        Set<Attribute> attributes = new HashSet<>(
                attributeGroup.getAttributes()
        );

        for (Attribute a : attributes) {
            if (a.getAttributeDictionary().equals(attributeDictionary)) {
                return "redirect:" + path;
            }
        }

        Attribute attribute = new Attribute();
        attribute.setAttributeDictionary(attributeDictionary);
        attribute.setAttributeGroup(attributeGroup);
        attributeRepo.save(attribute);

        return "redirect:" + path;
    }
}
