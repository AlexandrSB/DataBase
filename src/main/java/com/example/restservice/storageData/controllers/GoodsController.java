package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Category;
import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.equipmentData.equipmentRepos.ProxyRepo;
import com.example.restservice.storageData.storageDomain.*;
import com.example.restservice.storageData.storageRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/storage")
public class GoodsController {

    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private ContragentRepo contragentRepo;

    @Autowired
    private StorageRepo storageRepo;

    @Autowired
    private WorkshopRepo workshopRepo;

    @Autowired
    private QuantityAccountRepo quantityAccountRepo;

    @Autowired
    private ProxyRepo proxyRepo;


    @GetMapping("/goods")
    public String showGoods(Model model) {

        Iterable<Good> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);

        Iterable<Element> elements_name = elementRepo.findAllOnlyName();
        model.addAttribute("elements_name", elements_name);

        return "storageGoods";
    }

    @GetMapping("/goods/{id}")
    public String goodsView(
            Model model,
            @PathVariable String id
    ) {

        Long elementId = Long.valueOf(id);
        Good good = goodsRepo.findById(elementId).orElseThrow();
        model.addAttribute("good", good);

        Element element = elementRepo.findById(elementId)
                .orElseThrow();

        if (element.getCategory() == Category.ОБОРУДОВАНИЕ) {
            return "storageGoodsEquipment";
        } else {
            Iterable<Proxy> proxies = proxyRepo.findByElement(element.getId());
            model.addAttribute("proxies", proxies);
            return "storageGoodsParcel";
        }

    }

    @GetMapping("/arrival")
    public String arrivalGoods(
            Model model
    ) {

        Iterable<Good> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);

        Iterable<Contragent> contragents = contragentRepo.findAll();
        model.addAttribute("contragents", contragents);

        Iterable<Storage> storages = storageRepo.findAll();
        model.addAttribute("storages", storages);

        Iterable<QuantityAccount> quantityAccount = quantityAccountRepo.findAll();
        model.addAttribute("quantities", quantityAccount);

        Iterable<Proxy> proxies = proxyRepo.findAll();
        model.addAttribute("proxies", proxies);

        return "arrival";
    }

    @GetMapping("/expense")
    public String expenseGoods(
            Model model
    ) {

        Iterable<String> goodsNames = goodsRepo.getGoodsNames();
        model.addAttribute("goods_names", goodsNames);

        Iterable<Workshop> workshops = workshopRepo.findAll();
        model.addAttribute("workshops", workshops);

        Iterable<Storage> storages = storageRepo.findAll();
        model.addAttribute("storages", storages);

        Iterable<QuantityAccount> quantityAccount = quantityAccountRepo.findAll();
        model.addAttribute("quantities", quantityAccount);

        Iterable<Proxy> proxies = proxyRepo.findAll();
        model.addAttribute("proxies", proxies);

        return "expense";
    }

    @PostMapping("goods/in_repair")
    public String moveGoodInRepair(
            @RequestParam String elem_id
    ) {

        Long equip_id = Long.valueOf(elem_id);

        Equipment equipment = equipmentRepo
                .findById(equip_id)
                .orElseThrow();

        Condition condition = conditionRepo.findById(2L).orElseThrow();
        equipment.setCondition(condition);
        equipmentRepo.save(equipment);

        return "redirect:/storage/equipment";
    }

    @PostMapping("exportEquipment")
    public String exportEquipment() {

        Set<Good> goodSet = new HashSet<>();

        Iterable<Proxy> proxies = proxyRepo.findAll();

        for (Proxy ep: proxies) {
            Good good = new Good();
            good.setId(ep.getId());
            good.setName(ep.getName());
            good.setCategory(ep.getCategory());
            goodSet.add(good);
        }

        goodsRepo.saveAll(goodSet);

        return "redirect:/storage/goods";
    }

}