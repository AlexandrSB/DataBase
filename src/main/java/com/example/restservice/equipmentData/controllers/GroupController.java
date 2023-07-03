package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Groups;
import com.example.restservice.equipmentData.equipmentRepos.EquipmentRepo;
import com.example.restservice.equipmentData.equipmentRepos.GroupsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GroupController {
    @Autowired
    private GroupsRepo groupsRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;


    @GetMapping("/groups")
    public String showGroups(Model model) {

        Iterable<Groups> groups = groupsRepo.findAll();
        model.addAttribute("gr", groups);

        return "groups";
    }

    @PostMapping("/addGroup")
    public String addGroup(
            @RequestParam String groupName,
            Model model) {

        Groups newGroup = new Groups(groupName);
        groupsRepo.save(newGroup);

        Iterable<Groups> groups = groupsRepo.findAll();
        model.addAttribute("gr", groups);

        return "groups";
    }
}
