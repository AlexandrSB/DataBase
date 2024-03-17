package com.example.restservice.storageData.controllers;

import com.example.restservice.storageData.storageDomain.*;
import com.example.restservice.storageData.storageRepos.ContragentRepo;
import com.example.restservice.storageData.storageRepos.GoodsTrackingDateRepo;
import com.example.restservice.storageData.storageRepos.GoodsTrackingFromContragentRepo;
import com.example.restservice.storageData.storageRepos.StorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Controller
@RequestMapping("/storage/goods_tracking_from_contragent")
public class GoodsTrackingFromContragentController {

    @Autowired
    private GoodsTrackingFromContragentRepo goodsTrackingFromContragentRepo;

    @Autowired
    private ContragentRepo contragentRepo;

    @Autowired
    private StorageRepo storageRepo;

    @Autowired
    private GoodsTrackingDateRepo goodsTrackingDateRepo;

    @GetMapping("/{id}")
    public String newGoodsTrackingFromContragent(
            @PathVariable String id,
            Model model
    ) {

        Iterable<Contragent> contragents = contragentRepo.findAll();
        model.addAttribute("contragents", contragents);

        Iterable<Storage> storages = storageRepo.findAll();
        model.addAttribute("storages", storages);

        model.addAttribute("tracking_id", id);

        return "newGoodsTrackingFromContragent";
    }

//    @PostMapping("{id}")
//    public String trackingFromContragentToStorage(
//            @RequestParam String path,
//            @RequestParam String id,
//            @RequestParam String contragent_name,
//            @RequestParam String storage_name,
//            Model model
//    ) {
//        Long trackingId = Long.valueOf(id);
//        GoodsTrackingFromContragent goodsTrackingFromContragent =
//                goodsTrackingFromContragentRepo
//                        .findById(trackingId)
//                        .get();
//        Storage storage = storageRepo.findByName(storage_name).get();
//        Contragent contragent = contragentRepo.findByName(contragent_name).get();
//        GoodsTrackingDate goodsTrackingDate = new GoodsTrackingDate();
//
//        goodsTrackingDate.setCreatedOn(ZonedDateTime.now(ZoneId.systemDefault()));
//        goodsTrackingDateRepo.save(goodsTrackingDate);
//
//        goodsTrackingFromContragent.setGoodsTrackingDate(goodsTrackingDate);
//        goodsTrackingFromContragent.setStorage(storage);
//        goodsTrackingFromContragent.setContragent(contragent);
//        goodsTrackingFromContragent.setTypeOfGoodsMovement(TypeOfGoodsMovement.ARRIVAL);
//
//        goodsTrackingFromContragentRepo.save(goodsTrackingFromContragent);
//
//        return "redirect:/storage/contragents_party";
//    }
}
