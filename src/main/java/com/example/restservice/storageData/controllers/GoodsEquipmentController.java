package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Category;
import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.storageData.storageDomain.*;
import com.example.restservice.storageData.storageRepos.ConditionRepo;
import com.example.restservice.storageData.storageRepos.EquipmentRepo;
import com.example.restservice.storageData.storageRepos.GoodsRepo;
import com.example.restservice.storageData.storageRepos.PrefixInventoryNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/storage/equipment")
public class GoodsEquipmentController {

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private ElementRepo elementRepo;
    @Autowired
    private PrefixInventoryNumberRepo prefixInventoryNumberRepository;

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

        model.addAttribute("inv_number_prefix",
                prefixInventoryNumberRepository.findAll());
        return "storageEquipment";
    }

    @PostMapping("add_equipment")
    public String addEquipment(
            @RequestParam String goods_name,
            @RequestParam String condition_name,
            @RequestParam String inv_number_prefix,
            @RequestParam String inventory_number,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String barcode
    ) {

        PrefixInventoryNumber prefixInventoryNumber =
                prefixInventoryNumberRepository
                        .findByPrefix(inv_number_prefix)
                        .orElseThrow();

        Equipment equipment = new Equipment();
        equipment.setCondition(
                conditionRepo.findByName(condition_name)
                        .orElseThrow()
        );
        equipment.setGood(
                goodsRepo.findByName(goods_name)
                        .orElseThrow()
        );
        equipment.setPrefixInventoryNumber(prefixInventoryNumber);
        equipment.setInventoryNumber(inventory_number);

        equipmentRepo.save(equipment);

        return "redirect:/storage/equipment";
    }
}
