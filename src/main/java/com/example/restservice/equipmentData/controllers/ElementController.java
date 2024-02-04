package com.example.restservice.equipmentData.controllers;

import com.example.restservice.equipmentData.equipmentDomain.*;
import com.example.restservice.equipmentData.equipmentRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/element")
public class ElementController {

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private ElementsCompositeRepo elementsCompositeRepo;

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private UnitRepo unitRepo;

    @Autowired
    private AttributeValueRepo attributeValueRepo;

    @Autowired
    private GroupRepo groupRepo;

    @Autowired
    private GroupRecursiveRepo groupRecursiveRepo;

    @Autowired
    private ProxyRepo proxyRepo;

    @Autowired
    private ElementTypeRepo elementTypeRepo;


    @ModelAttribute
    public void addAttributes(Model model) {

        model.addAttribute("group", groupRecursiveRepo.findAll());

        Iterable<Element> elements = elementRepo.findAll();
        model.addAttribute("elements", elements);

    }

    @GetMapping
    public String AllElements(Model model) {

        Iterable<Element> elements = elementRepo.findAll();
        model.addAttribute("elements", elements);

        return "allElements";
    }

    @GetMapping("/{group_id}")
    public String showElements(
            @PathVariable String group_id,
            Model model) {

        Long id = Long.valueOf(Optional.of(group_id).get());
        Set<Group> groups = new HashSet<>();
        List<Group> groups_breadcrumb = new LinkedList<>();

        Optional<Group> group_optional = groupRepo.findById(id);
        Group group = group_optional.get();

        if (id != 0) {
            groups.addAll(groupRepo.findAllByParentId(group.getId()));
            while (group.getId() != 0) {
                groups_breadcrumb.add(group.getParent());
                group = group.getParent();
            }
            Collections.reverse(groups_breadcrumb);
        } else {
            groups.addAll(groupRepo.findAllByParentId(0L));
        }

        Iterable<ElementType> elementTypes = elementTypeRepo.findAll();
        model.addAttribute("elements_type", elementTypes);

        model.addAttribute("nav_breadcrumb", groups_breadcrumb);
        model.addAttribute("nav", groups);
        model.addAttribute("my_group", group_optional.get());

        return "element";
    }

    @GetMapping("/view/{elem_id}")
    public String showElement(
            @PathVariable String elem_id,
            Model model
    ) {

        Element elem = elementRepo.findById(Long.valueOf( elem_id ))
                .orElseThrow();
        model.addAttribute( "elem", elem );

//        Iterable<ElementsComposite> ecSource = elem.get().getElementsSource();
//        Set<Element> elements_destination = new HashSet<>();
//        for (ElementsComposite ec : ecSource) {
//            elements_destination.add( ec.getElement_destination() );
//        }
        Iterable<String> elements_source =
                elementRepo.findElementSource(elem.getId());
        model.addAttribute("elem_source", elements_source);

//        Iterable<ElementsComposite> ecDestination = elem.get()
//                .getElementsDestination();
//        Set<Element> elements_source = new HashSet<>();
//        for (ElementsComposite ec : ecDestination) {
//            elements_source.add( ec.getElement_source() );
//        }
        Iterable<String> elements_destination =
                elementRepo.findElementDestination(elem.getId());
        model.addAttribute("elem_destination", elements_destination);

        Set<Group> groups = new HashSet<>();
        groups.addAll( groupRepo.findAllByParentId( 0L ));
        model.addAttribute( "nav", groups );

        Iterable<Proxy> proxies_select = proxyRepo.findAll();
        model.addAttribute("proxies_select", proxies_select);

        Iterable<Proxy> proxies = elem.getProxies();
        model.addAttribute("proxies", proxies);

        Iterable<Attribute> attributes = attributeRepo.findAll();
        model.addAttribute( "attributes", attributes );

        Iterable<Unit> units = unitRepo.findAll();
        model.addAttribute( "units", units );

        Iterable<AttributeValue> attributeValues = attributeValueRepo.findAll();
        model.addAttribute( "attributeValues", attributeValues );

        return "compView";
    }

    @PostMapping("add_element")
    public String addElement(
//            @RequestParam( required = false ) String proxy_name,
            @RequestParam(value = "is_equipment", required = false) String is_equipment,
            @RequestParam String group_name,
            @RequestParam String elementName,
            @RequestParam String description,
            @RequestParam String element_type,
            Model model) {

        List<Group> groups_breadcrumb = new LinkedList<>();

        ElementType elementType = elementTypeRepo.findByType(element_type).get();

        Group group = Optional.ofNullable(
                groupRepo.findByGroupName(group_name).get(0)
        ).get();
        model.addAttribute("my_group", group );

        Element elem = new Element();
        elem.setName( elementName.trim() );
        elem.setDescription( description.trim() );
        elem.addGroup( group );
        elem.setElementType( elementType );
        if(is_equipment != null) {
            elem.setIsEquipment(true);
        } else {
            elem.setIsEquipment(false);
        }
        elementRepo.save( elem );

        return "redirect:/element/" + group.getId();
    }

    @PostMapping("/view/add_attribute")
    private String addAttribute(
            @RequestParam String thisElementId,
            @RequestParam String proxy_name,
            Model model
    ) {

        Optional<Proxy> proxy = proxyRepo.findByName( proxy_name );
        Optional<Element> element = elementRepo.findById(
                Long.valueOf(thisElementId)
        );
        element.get().addProxy(proxy.get());
        elementRepo.save( element.get() );

        return "redirect:/element/view/" + thisElementId;
    }

    @PostMapping("/view/link_elements")
    private String linkElements(
            @RequestParam String element_destination,
            @RequestParam String element_source_id,
            @RequestParam String proxy_name,
            Model model
    ) {

        Element elementDestination =
                 elementRepo.findByName( element_destination )
                         .get();
        Element elementSource =
                elementRepo.findById(Long.valueOf( element_source_id ))
                        .get();
        Proxy proxy = proxyRepo.findByName(proxy_name).get();

        ElementsComposite elementsComposite = new ElementsComposite();
        elementsComposite.setElement_source( elementSource );
        elementsComposite.setElement_destination( elementDestination );
        elementsComposite.setProxy(proxy);
        elementsCompositeRepo.save( elementsComposite );

        return "redirect:/element/view/" + element_source_id;
    }
}