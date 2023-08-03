package com.example.restservice.storageData.controllers;

import com.example.restservice.storageData.storageRepos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GoodsController {

    @Autowired
    private GoodsRepo goodsRepo;
}
