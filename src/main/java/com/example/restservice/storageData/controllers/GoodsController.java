package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.equipmentData.equipmentRepos.EquipmentRepo;
import com.example.restservice.storageData.storageDomain.Condition;
import com.example.restservice.storageData.storageDomain.Goods;
import com.example.restservice.storageData.storageRepos.ConditionRepo;
import com.example.restservice.storageData.storageRepos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class GoodsController {

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @GetMapping("/goods")
    public String showGoods(Model model) {

        Iterable<Goods> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);

        Iterable<Element> elements = elementRepo.findAll();
        model.addAttribute("elements", elements);

        Iterable<Condition> conditions = conditionRepo.findAll();
        model.addAttribute("conditions", conditions);

        return "goods";
    }

    @PostMapping("add_goods")
    public String addGoogs(
            @RequestParam String elem,
            @RequestParam( required = false ) String description,
            @RequestParam String inventoryNumber,
            @RequestParam String barcode,
            @RequestParam String condition,
            Model model
    ) {
        if ( elem.isEmpty() ) {
            return "goods";
        }

        Goods gs = new Goods();
        gs.setName( elementRepo.findByName(elem).getName().trim() );

        goodsRepo.save(gs);

        Iterable<Goods> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);

        Iterable<Element> elements = elementRepo.findAll();
        model.addAttribute("elements", elements);

        Iterable<Condition> conditions = conditionRepo.findAll();
        model.addAttribute("conditions", conditions);

        return "goods";
    }
}