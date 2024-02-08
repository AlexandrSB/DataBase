package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.*;
import com.example.restservice.equipmentData.equipmentRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @Autowired
    private AttributeValueDictionaryRepo attributeValueDictionaryRepo;

    @Autowired
    private UnitDictionaryRepo unitDictionaryRepo;

    @Autowired
    private ProxyRepo proxyRepo;



    @ModelAttribute
    private void modelAttribute(Model model) {
        model.addAttribute("root", "proxy");
        model.addAttribute("root_name", "Proxy");
    }

    @GetMapping("/proxy/{proxy_id}/{attr_group_id}/{attr_id}")
    private String viewAttributeValue(
            @PathVariable String proxy_id,
            @PathVariable String attr_group_id,
            @PathVariable String attr_id,
            Model model
    ) {
        Long proxyId = Long.valueOf(proxy_id);
        Long attrGroupId = Long.valueOf(attr_group_id);
        Long attrId = Long.valueOf(attr_id);

        Proxy proxy = proxyRepo.findById(proxyId).orElseThrow();
        model.addAttribute("proxy", proxy);

        AttributeGroup attributeGroup = attributeGroupRepo
                .findById(attrGroupId)
                .orElseThrow();
        model.addAttribute("attr_group", attributeGroup);

        Attribute attribute = attributeRepo
                .findById(attrId)
                .orElseThrow();
        model.addAttribute("attr", attribute);

        Iterable<AttributeValueDictionary> attributeValueDictionary =
                attributeValueDictionaryRepo.findByOwner(
                   attribute.getAttributeDictionary());
        model.addAttribute("attr_value_dic", attributeValueDictionary);

        Iterable<UnitDictionary> unitDictionaries =
                unitDictionaryRepo.findAll();
        model.addAttribute("unit_dic", unitDictionaries);

        // Create broadcrumb menu
        List<String[]> breadcramb = new ArrayList<>();
        breadcramb.add(
                new String[]{"/proxy/" + proxy_id,
                        proxy.getName()}
        );
        breadcramb.add(
                new String[]{"/proxy/" + proxy_id + "/" + attr_group_id,
                        attributeGroup.getAttributeGroupDictionary().getName()}
        );
        model.addAttribute("nav_breadcrumb", breadcramb);
        model.addAttribute("last", attribute.getAttributeDictionary().getName());

        return "element_attr";
    }

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
