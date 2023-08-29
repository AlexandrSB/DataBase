package com.example.restservice.storageData.controllers;

import com.example.restservice.storageData.storageDomain.Contragent;
import com.example.restservice.storageData.storageRepos.ContragentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContragentController {

    @Autowired
    private ContragentRepo contragentRepo;

    @ModelAttribute
    private void addAttribute(Model model) {
        Iterable<Contragent> contragents = contragentRepo.findAll();
        model.addAttribute("contragents", contragents);
    }

    @GetMapping("/contragent")
    public String showContragent(Model model) {

        return "contragent";
    }

    @PostMapping("add_contragent")
    public String addContragent(
            @RequestParam String name,
            @RequestParam String description
            ) {

        Contragent contragent = new Contragent();
        contragent.setName(name);
        contragent.setDescription(description);

        contragentRepo.save(contragent);

        return "redirect:/contragent";
    }
}
