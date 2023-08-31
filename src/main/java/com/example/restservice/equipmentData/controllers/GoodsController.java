package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.storageData.storageDomain.Condition;
import com.example.restservice.storageData.storageDomain.Good;
import com.example.restservice.storageData.storageRepos.ConditionRepo;
import com.example.restservice.storageData.storageRepos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/storage/goods")
public class GoodsController {

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @GetMapping("/")
    public String showGoods(Model model) {

        Iterable<Good> goods = goodsRepo.findAll();
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

        Good gs = new Good();
        gs.setName( elementRepo.findByName(elem).get().getName().trim() );

        goodsRepo.save(gs);

        return "redirect:/goods";
    }
}