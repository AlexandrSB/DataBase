package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Group;
import com.example.restservice.equipmentData.equipmentRepos.EquipmentRepo;
import com.example.restservice.equipmentData.equipmentRepos.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GroupController {
    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;


    @GetMapping("/groups")
    public String showGroups(Model model) {

        Iterable<Group> groups = groupRepo.findAll();
        model.addAttribute("gr", groups);

        return "groups";
    }

    @PostMapping("/addGroup")
    public String addGroup(
            @RequestParam String groupName,
            @RequestParam String parentGroup,
            Model model) {

        Group newGroup = new Group(groupName);
        newGroup.setParent( groupRepo.getById(Long.valueOf(parentGroup)) );
        groupRepo.save( newGroup );

        Iterable<Group> groups = groupRepo.findAll();
        model.addAttribute("gr", groups);

        return "groups";
    }
}
