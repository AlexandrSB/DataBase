package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.*;
import com.example.restservice.equipmentData.equipmentRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProxyController {

    @Autowired
    private AttributeGroupRepo attributeGroupRepo;

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeValueRepo attributeValueRepo;

    @Autowired
    private GroupRecursiveRepo groupRecursiveRepo;

    @Autowired
    private ProxyRepo proxyRepo;

    @Autowired
    private UnitRepo unitRepo;

    @Autowired
    private UnitDictionaryRepo unitDictionaryRepo;


    @ModelAttribute
    public void addAttr( Model model ) {
        // Добавляем меню
        model.addAttribute("group", groupRecursiveRepo.findAll());
    }

    @GetMapping("/proxy")
    public String proxy(
            Model model
    ) {

        Iterable<Proxy> proxies = proxyRepo.findAll();
        model.addAttribute("proxies", proxies);

        Iterable<Attribute> attributes = attributeRepo.findAll();
        model.addAttribute( "attributes", attributes );

        Iterable<UnitDictionary> unit_dictionaries = unitDictionaryRepo.findAll();
        model.addAttribute( "unit_dic", unit_dictionaries );

        Iterable<AttributeValue> attributeValues = attributeValueRepo.findAll();
        model.addAttribute( "attributeValues", attributeValues );

        Iterable<AttributeGroup> attributeGroups = attributeGroupRepo.findAll();
        model.addAttribute("attr_groups", attributeGroups);


        return "element_proxy";
    }

    @PostMapping("addProxy")
    private String addProxy(
        @RequestParam String proxy_name,
        @RequestParam String path
    ) {

        Proxy proxy = new Proxy();
        proxy.setName( proxy_name );
        proxyRepo.save( proxy );

        return "redirect:"+path;
    }

    @PostMapping("proxy_addAttribute")
    private String addAttribute(
        @RequestParam String proxy_name,
        @RequestParam String attribute_groups_name,
        @RequestParam String attribute_name,
        @RequestParam String attribute_value,
        @RequestParam String unit_dic_name,
        @RequestParam String path,
        Model model
    ) {

        Proxy proxy = proxyRepo
                .findByName( proxy_name )
                .orElseThrow();
        Attribute attribute = attributeRepo
                .findByName( attribute_name )
                .orElseThrow();
        AttributeGroup attributeGroup = attributeGroupRepo
                .findByName(attribute_groups_name)
                .orElseThrow();
        UnitDictionary unitDic = unitDictionaryRepo
                .findByName(unit_dic_name)
                .orElseThrow();

        attributeGroup.setProxy(proxy);
        attributeGroupRepo.save(attributeGroup);

        attribute.setAttributeGroup(attributeGroup);
        attributeRepo.save(attribute);

        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setName( attribute_value );
        attributeValue.setAttribute( attribute );
        attributeValueRepo.save( attributeValue );

        Unit unit = new Unit();
        unit.setUnitDictionary(unitDic);
        unit.setAttributeValue(attributeValue);
        unitRepo.save(unit);

        return "redirect:" + path;
    }
}
