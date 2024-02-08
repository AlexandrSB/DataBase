package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.AttributeDictionary;
import com.example.restservice.equipmentData.equipmentDomain.AttributeGroup;
import com.example.restservice.equipmentData.equipmentDomain.AttributeGroupDictionary;
import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import com.example.restservice.equipmentData.equipmentRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class AttributeGroupController {

    @Autowired
    private AttributeGroupRepo attributeGroupRepo;

    @Autowired
    private AttributeGroupDictionaryRepo attributeGroupDictionaryRepo;

    @Autowired
    private AttributeValueDictionaryRepo attributeValueDictionaryRepo;

    @Autowired
    private AttributeDictionaryRepo attributeDictionaryRepo;

    @Autowired
    private ProxyRepo proxyRepo;

    @ModelAttribute
    private void modelAttribute(Model model) {
        model.addAttribute("root", "proxy");
        model.addAttribute("root_name", "Proxy");
    }


    @GetMapping("/proxy/{proxy_id}/{attr_group_id}")
    private String viewAttributeGroup(
            @PathVariable String proxy_id,
            @PathVariable String attr_group_id,
            Model model
    ) {

        Long proxyId = Long.valueOf(proxy_id);
        Long attrGroupId = Long.valueOf(attr_group_id);

        Proxy proxy = proxyRepo
                .findById(proxyId)
                .orElseThrow();
        model.addAttribute("proxy", proxy);

        AttributeGroup attributeGroup = attributeGroupRepo
                .findById(attrGroupId)
                .orElseThrow();
        model.addAttribute("attr_group", attributeGroup);

        Iterable<AttributeDictionary> attributeDictionaries =
                attributeDictionaryRepo.findByOwner(
                        attributeGroup.getAttributeGroupDictionary()
                );
        model.addAttribute("attr_dic", attributeDictionaries);

        // Create broadcrumb menu
        List<String[]> breadcramb = new ArrayList<>();
        breadcramb.add(
                new String[] {"/proxy/" + proxy_id,
                        proxy.getName()}
        );
        model.addAttribute("nav_breadcrumb", breadcramb);
        model.addAttribute("last", attributeGroup.getAttributeGroupDictionary().getName());

        return "element_attrGroup";
    }

    @PostMapping("addAttrGroupName")
    private String addAttributeGroupName(
            @RequestParam String attribute_group_name,
            @RequestParam String path
    ) {

        if (attributeGroupDictionaryRepo
                .findByName(attribute_group_name)
                .isPresent()) {
            return "redirect:" + path;
        }

        AttributeGroupDictionary attributeGroupDictionary = new AttributeGroupDictionary();
        attributeGroupDictionary.setName(attribute_group_name);
        attributeGroupDictionaryRepo.save(attributeGroupDictionary);

        return "redirect:" + path;
    }

    @PostMapping("addAttributeGroup")
    private String addAttributeGroup(
            @RequestParam String proxy_id,
            @RequestParam String attribute_group_name,
            @RequestParam String path
    ) {
        Long proxyId = Long.valueOf(proxy_id);

        Proxy proxy = proxyRepo.findById(proxyId)
                .orElseThrow();

        AttributeGroupDictionary attributeGroupDictionary =
                attributeGroupDictionaryRepo.findByName(attribute_group_name)
                        .orElseThrow();

        Set<AttributeGroup> attributeGroups =
                new HashSet<>(proxy.getAttributeGroups());

        //TODO проверить Proxy чтобы не дублировались AttributeGroup
        //Переписать на Stream?
        for (AttributeGroup ag : attributeGroups) {
            if (ag.getAttributeGroupDictionary().equals(attributeGroupDictionary)) {
                return "redirect:" + path;
            }
        }

        AttributeGroup attributeGroup = new AttributeGroup();
        attributeGroup.setAttributeGroupDictionary(attributeGroupDictionary);
        attributeGroup.setProxy(proxy);
        attributeGroupRepo.save(attributeGroup);

        return "redirect:" + path;
    }
}
