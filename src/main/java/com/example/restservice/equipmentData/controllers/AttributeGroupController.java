package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.AttributeGroup;
import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import com.example.restservice.equipmentData.equipmentRepos.AttributeGroupRepo;
import com.example.restservice.equipmentData.equipmentRepos.ProxyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AttributeGroupController {

    @Autowired
    private AttributeGroupRepo attributeGroupRepo;

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
        model.addAttribute("attrGroup", attributeGroup);

        return "element_attrGroup";
    }

    @PostMapping("addAttrGroup")
    private String addAttributeGroup(
            @RequestParam String attribute_group_name,
            @RequestParam String path

    ) {

//        if (attributeGroupRepo.findByName(attribute_group_name).isPresent()) {
//            return "redirect:" + path;
//        }

        AttributeGroup attributeGroup = new AttributeGroup();
        attributeGroupRepo.save(attributeGroup);

        return "redirect:" + path;
    }
}
