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
    private AttributeRepo attributeRepo;

    @Autowired
    private UnitRepo unitRepo;

    @Autowired
    private AttributeValueRepo attributeValueRepo;

    @Autowired
    private GroupRecursiveRepo groupRecursiveRepo;

    @Autowired
    private ProxyRepo proxyRepo;

    @Autowired
    private FirmaRepo firmaRepo;


    @ModelAttribute
    public void addAttr( Model model ) {
        // Добавляем меню
        model.addAttribute("group", groupRecursiveRepo.findAll());
    }

    @GetMapping("/proxy")
    public String proxy(
            Model model
    ) {

        Iterable<Firma> firms = firmaRepo.findAll();
        model.addAttribute("firms", firms);

        Iterable<Proxy> proxies = proxyRepo.findAll();
        model.addAttribute("proxies", proxies);

        Iterable<Attribute> attributes = attributeRepo.findAll();
        model.addAttribute( "attributes", attributes );

        Iterable<Unit> units = unitRepo.findAll();
        model.addAttribute( "units", units );

        Iterable<AttributeValue> attributeValues = attributeValueRepo.findAll();
        model.addAttribute( "attributeValues", attributeValues );

        return "proxy";

    }

    @PostMapping("addProxy")
    private String addProxy(
        @RequestParam String firma,
        @RequestParam String proxy_name,
        Model model
    ) {

        Firma firm = firmaRepo.findByFirmName( firma );

        Proxy proxy = new Proxy();
        proxy.setName( proxy_name );
        proxy.setFirma( firm );
        proxyRepo.save( proxy );

        return "redirect:/proxy";
    }

    @PostMapping("proxy_addAttribute")
    private String addAttribute(
        @RequestParam String proxy_name,
        @RequestParam String attribute_name,
        @RequestParam String attribute_value,
        @RequestParam String unit_name,
        Model model
    ) {

        Optional<Attribute> attribute = attributeRepo.findByName( attribute_name );
        Optional<Unit> unit = unitRepo.findByName( unit_name );
        Optional<Proxy> proxy = proxyRepo.findByName( proxy_name );

        AttributeValue attributeValue = new AttributeValue();
        attributeValue.setName( attribute_value.trim() );
        attributeValue.setProxy( proxy.get() );
        attributeValue.setAttribute( attribute.get() );
        attributeValue.setUnit( unit.get() );
        attributeValueRepo.save( attributeValue );

        return "redirect:/proxy";
    }
}