package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Category;
import com.example.restservice.storageData.storageDomain.Condition;
import com.example.restservice.storageData.storageDomain.Equipment;
import com.example.restservice.storageData.storageRepos.ConditionRepo;
import com.example.restservice.storageData.storageRepos.EquipmentRepo;
import com.example.restservice.storageData.storageRepos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/storage/equipment")
public class GoodsEquipmentController {

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @Autowired
    private GoodsRepo goodsRepo;

    @GetMapping
    public String equipment(Model model) {

        Iterable<String> goodsName = goodsRepo
                .findAllOnlyNameByCategory(
                        Category.ОБОРУДОВАНИЕ
                );
        model.addAttribute("goods_name", goodsName);

        Iterable<Condition> conditions = conditionRepo.findAll();
        model.addAttribute("conditions", conditions);

        Iterable<Equipment> equipment = equipmentRepo.findAllWithLazy();
        model.addAttribute("goods_equipment", equipment);

        return "storageEquipment";
    }

    @PostMapping("add_equipment")
    public String addEquipment(
            @RequestParam String goods_name,
            @RequestParam String condition_name,
            @RequestParam String inventory_number,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String barcode
    ) {

        Equipment equipment = new Equipment();
        equipment.setCondition(
                conditionRepo.findByName(condition_name)
                        .orElseThrow()
        );
        equipment.setGood(
                goodsRepo.findByName(goods_name)
                        .orElseThrow()
        );
        equipment.setInventoryNumber(inventory_number);

        equipmentRepo.save(equipment);

        return "redirect:/storage/equipment";
    }
}
