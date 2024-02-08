package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Attribute;
import com.example.restservice.equipmentData.equipmentDomain.AttributeDictionary;
import com.example.restservice.equipmentData.equipmentDomain.AttributeValue;
import com.example.restservice.equipmentData.equipmentDomain.AttributeValueDictionary;
import com.example.restservice.equipmentData.equipmentRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AttributeValueController {

    @Autowired
    private ProxyRepo proxyRepo;

    @Autowired
    private AttributeGroupRepo attributeGroupRepo;

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeDictionaryRepo attributeDictionaryRepo;

    @Autowired
    private AttributeValueRepo attributeValueRepo;

    @Autowired
    private AttributeValueDictionaryRepo attributeValueDictionaryRepo;

    @Autowired
    private UnitRepo unitRepo;


    @PostMapping("/addAttrValueName")
    private String addAttributeValueName(
            @RequestParam String path,
            @RequestParam String attr_dic_id,
            @RequestParam String attr_value_name
    ) {
        Long attrDicId = Long.valueOf(attr_dic_id);

        if (attributeValueDictionaryRepo
                .findByName(attr_value_name)
                .isPresent()) {
            return "redirect:" + path;
        }

        AttributeDictionary attributeDictionary =
                attributeDictionaryRepo
                        .findById(attrDicId)
                        .orElseThrow();

        AttributeValueDictionary attributeValueDictionary =
                new AttributeValueDictionary();
        attributeValueDictionary.setName(attr_value_name);
        attributeValueDictionary.setAttributeDictionary(attributeDictionary);
        attributeValueDictionaryRepo.save(attributeValueDictionary);


        return "redirect:" + path;
    }

    @PostMapping("/addAttributeValue")
    private String addAttributeValue (
            @RequestParam String path,
            @RequestParam String attr_id,
            @RequestParam String attr_value_name
    ) {
        Long attrId = Long.valueOf(attr_id);

        Attribute attribute =
                attributeRepo
                        .findById(attrId)
                        .orElseThrow();

        AttributeValueDictionary attributeValueDictionary =
                attributeValueDictionaryRepo
                        .findByName(attr_value_name)
                        .orElseThrow();

        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setAttribute(attribute);
        attributeValue.setAttributeValueDictionary(attributeValueDictionary);
        attributeValueRepo.save(attributeValue);


        return "redirect:" + path;
    }
}
