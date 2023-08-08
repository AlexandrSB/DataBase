package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Attribute;
import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.Equipment;
import com.example.restservice.equipmentData.equipmentRepos.AttributeRepo;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.equipmentData.equipmentRepos.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@Controller
public class ElementController {

    @Autowired
    private ElementRepo componentRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private AttributeRepo attributeRepo;


    @GetMapping("/component")
    public String component(Map<String, Object> model) {

        Iterable<Equipment> equipments = equipmentRepo.findAll();
        model.put("equipments", equipments);

        Iterable<Element> components = componentRepo.findAll();
        model.put("components", components);

        Iterable<Attribute> attributes = attributeRepo.findAll();
        model.put("attributes", attributes);

        return "component";
    }

    @GetMapping("component/{component}")
    public String componentViewForm(
            @PathVariable Element element,
            Model model
    ) {


        return "compView";
    }


    @PostMapping("components")
    public String components(
            @RequestParam String myModel,
            @RequestParam String componentName,
            @RequestParam(value = "isComposite", required = false) String isComposite,
            @RequestParam (value="isMechanic", required = false) String isMechanic,
            @RequestParam (value="isElectric", required = false) String isElectric,
            @RequestParam (value="isElectronic", required = false) String isElectronic,

            Model model) {

        Element element = new Element(componentName);
        Equipment equipment = equipmentRepo.findByModel(myModel).get(0);
//        if (equipment != null) {
//            element.addOwner(equipment);
//            if (isComposite != null) {
//                element.setIsComposite(true);
//            } else {
//                element.setIsComposite(false);
//            }
//            if (isMechanic != null) {
//                element.setIsMechanic(true);
//            } else {
//                element.setIsMechanic(false);
//            }
//            if (isElectric != null) {
//                element.setIsElectric(true);
//            } else {
//                element.setIsElectric(false);
//            }
//            if (isElectronic != null) {
//                element.setIsElectronic(true);
//            } else {
//                element.setIsElectronic(false);
//            }

                componentRepo.save(element);
//        }
//
////        Iterable<Equipment> equipments = equipmentRepo.findAll();
//        model.addAttribute("equipments", equipments);
//
//        Iterable<Element> components = componentRepo.findAll();
//        model.addAttribute("components", components);
//
//        Iterable<Attribute> attributes = attributeRepo.findAll();
//        model.addAttribute("attributes", attributes);

        return "component";
    }
}
