package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.equipmentData.equipmentRepos.EquipmentRepo;
import com.example.restservice.storageData.storageDomain.Goods;
import com.example.restservice.storageData.storageRepos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoodsController {

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private ElementRepo elementRepo;

    @GetMapping("/goods")
    public String showGoods(Model model) {

        Iterable<Goods> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);

        Iterable<Element> elements = elementRepo.findAll();
        model.addAttribute("elem", elements);

        return "goods";
    }

    @PostMapping("add_goods")
    public String addGoogs(
            @RequestParam String elem,
            @RequestParam String description,
            Model model
    ) {
        Goods goods = new Goods();
        goods.setName(elem);
        goods.setDescription(description);

        goodsRepo.save(goods);

        return "goods";
    }
}