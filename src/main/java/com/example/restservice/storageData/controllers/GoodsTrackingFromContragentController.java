package com.example.restservice.storageData.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storage/goods_tracking_from_contragent")
public class GoodsTrackingFromContragentController {

    @GetMapping("/{id}")
    public String newGoodsTrackingFromContragent(
            @PathVariable String id,
            Model model
    ) {


        return "newGoodsTrackingFromContragent";
    }
}
