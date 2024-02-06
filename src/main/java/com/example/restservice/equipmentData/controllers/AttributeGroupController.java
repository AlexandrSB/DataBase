package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.*;
import com.example.restservice.equipmentData.equipmentRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

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
                attributeDictionaryRepo.findAll();
        model.addAttribute("attr_dic", attributeDictionaries);

        return "element_attrGroup";
    }

    @PostMapping("addAttrGroupName")
    private String addAttributeGroupName(
            @RequestParam String attribute_group_name,
            @RequestParam String path
    ) {

        if (attributeGroupDictionaryRepo.findByName(attribute_group_name).isPresent()) {
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
