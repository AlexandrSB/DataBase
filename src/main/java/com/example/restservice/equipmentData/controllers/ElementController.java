package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.Element;
import com.example.restservice.equipmentData.equipmentDomain.Group;
import com.example.restservice.equipmentData.equipmentRepos.AttributeRepo;
import com.example.restservice.equipmentData.equipmentRepos.ElementRepo;
import com.example.restservice.equipmentData.equipmentRepos.GroupRecursiveRepo;
import com.example.restservice.equipmentData.equipmentRepos.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;

@Controller
@RequestMapping("/element")
public class ElementController {

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private GroupRecursiveRepo groupRecursiveRepo;


    @ModelAttribute
    public void addAttributes(Model model) {

        model.addAttribute("group", groupRecursiveRepo.findAll());

        Iterable<Element> elements = elementRepo.findAll();
        model.addAttribute("elements", elements);

    }

    @GetMapping("/{group_id}")
    public String showElements(
        @PathVariable String group_id,
        Model model) {

        Long id = Long.valueOf(Optional.of( group_id ).get());
        Set<Group> groups = new HashSet<>();
        List<Group> groups_breadcrumb = new LinkedList<>();

        Optional<Group> group_optional = groupRepo.findById( id );
        Group group = group_optional.get();

        if (id != 0) {
            groups.addAll(groupRepo.findAllByParentId( group.getId() ));
            while (group.getId() != 0) {
                groups_breadcrumb.add( group.getParent() );
                group = group.getParent();
            }
            Collections.reverse( groups_breadcrumb );
        } else {
            groups.addAll( groupRepo.findAllByParentId( 0L ));
        }

        model.addAttribute("nav_breadcrumb", groups_breadcrumb );
        model.addAttribute("nav", groups );
        model.addAttribute("my_group", group_optional.get() );

        return "element";
    }

    @GetMapping("/view/{elem_id}")
    public String showElement(
            @PathVariable String elem_id,
            Model model
    ) {

        Optional<Element> elem = elementRepo.findById(Long.valueOf( elem_id ));
        model.addAttribute("elem", elem.get() );

        Set<Group> groups = new HashSet<>();
        groups.addAll( groupRepo.findAllByParentId( 0L ));
        model.addAttribute("nav", groups );

        return "compView";
    }

    @PostMapping("add_element")
    public String addElement(
            @RequestParam String group_name,
            @RequestParam String elementName,
            @RequestParam String description,
            Model model) {

        Optional<Group> group = Optional.ofNullable(
                groupRepo.findByGroupName(group_name).get(0)
        );
        model.addAttribute("my_group", group.get());

        Element elem = new Element();
        elem.setName( elementName.trim() );
        elem.setDescription( description.trim() );
        elem.addGroup( group );
        elementRepo.save( elem );

        return "element";
    }

//    @PostMapping("/view/{elem_id}")
//    private String viewElement(
//            @PathVariable String elem_id,
//            Model model
//    ) {
//
//        Optional<Element> elem = elementRepo.findById( Long.valueOf( elem_id ));
//        model.addAttribute( "elem", elem.get() );
//
//        return "element";
//    }

    @PostMapping("/view/link_elements")
    private String linkElements(
            @RequestParam String elementName,
            @RequestParam String thisElement,
            Model model
    ) {

        Optional<Element> elementDestination =
                Optional.of( elementRepo.findByName( elementName ));

        Optional<Element> thisElem = elementRepo.findById(Long.valueOf(thisElement));
        model.addAttribute( "elem", thisElem.get() );

        thisElem.get().addElementDesination( elementDestination );
//        elementDestination.get().addElementSource( thisElem );
        elementRepo.save( thisElem.get() );
//        elementRepo.save( elementDestination.get() );

        return "compView";
    }
}
