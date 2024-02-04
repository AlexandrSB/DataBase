package com.example.restservice.storageData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.Proxy;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.equipmentData.equipmentRepos.ProxyRepo;
import com.example.restservice.storageData.storageDomain.*;
import com.example.restservice.storageData.storageRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

//        Map<String, String> mapOfGoods = new HashMap<>();
//        List<Map<String, String>> listOfGoods = new ArrayList<>();
//        String elem_type;
//        String gd_elem;

////        for (Good good : goods) {
////            mapOfGoods.put("id", String.valueOf(good.getId()));
////            mapOfGoods.put("name", good.getName());
//////            gd_elem = elementRepo.findById(
//////                    Long.valueOf(
//////                            good.getExternalEquipId()
////                    )
////            ).get().getElementType().getType();


//            mapOfGoods.put("type", gd_elem);

//        }
//        model.addAttribute("mapOfGoods", mapOfGoods);

        return "storageGoods";
    }

    @GetMapping("/goods/{id}")
    public String goodsView(
            Model model,
            @PathVariable String id
    ) {

        Long thisId = Long.valueOf(id);
        Good good = goodsRepo.findById(thisId).orElseThrow();
        model.addAttribute("good", good);

        if (good.getIsEquipment()) {
            return "storageGoodsEquipment";
        } else {
            Element element = elementRepo.findById(thisId).orElseThrow();
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

//    @PostMapping("add_goods")
//    public String addGoogs(
//            @RequestParam String element_name,
//            @RequestParam(required = false) String description,
//            @RequestParam(required = false) String inventory_number,
//            @RequestParam(required = false) String barcode,
//            @RequestParam String condition_name,
//            Model model
//    ) {
//        if (element_name.isEmpty()) {
//            return "storageGoods";
//        }
//
//        Condition condition =
//                conditionRepo.findByName(condition_name).get();
//
//        Element element =
//                elementRepo.findByName(element_name).get();
//
//        Equipment equipment = new Equipment();
//
////        Good good = new Good();
////        good.setName( element.getName().trim() );
////        good.setExternalEquipId( element.getId() );
////        goodsRepo.save(good);
//
//        Good good = goodsRepo.findByName(element_name)
//                .orElse(new Good());
//        good.setName(element.getName().trim());
//        good.setExternalEquipId(element.getId());
//        goodsRepo.save(good);
//
//        if (!inventory_number.isEmpty() &&
//                inventory_number.length() > 5) {
////            equipment.setId( good.getId() );
//            equipment.setInventoryNumber(inventory_number);
//            equipment.setGood(good);
//            equipment.setCondition(condition);
//            equipmentRepo.save(equipment);
////            good.setEquipment( equipment );
//        }
//
////        goodsRepo.save(good);
//
//        return "redirect:/storage/goods";
//    }

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

        Set<Good> goods = new HashSet<>();


        Iterable<Element> equipment = elementRepo.findAllEquipment();

        for (Element e : equipment) {
            Good good = new Good();
            good.setId(e.getId());
            good.setName(e.getName());
            good.setIsEquipment(true);
            goods.add(good);
        }

        goodsRepo.saveAll(goods);

        return "redirect:/storage/goods";
    }

    @PostMapping("exportParcels")
    public String exportParcels() {

        Set<Good> goods = new HashSet<>();

        Iterable<Element> parcels = elementRepo.findAllParcels();

        for (Element e : parcels) {
            Good good = new Good();
            good.setId(e.getId());
            good.setName(e.getName());
//            good.setExternalEquipId(e.getId());
            goods.add(good);
        }

        goodsRepo.saveAll(goods);


        return "redirect:/storage/goods";
    }
}