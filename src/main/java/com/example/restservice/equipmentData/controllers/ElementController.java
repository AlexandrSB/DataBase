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

        model.addAttribute("my_group",
                groupRepo
                .findById(0L)
                .orElseThrow()
        );

        return "allElements";
    }

    @GetMapping("/{group_id}")
    public String showElements(
            @PathVariable String group_id,
            Model model) {

        Long groupId = Long.valueOf(group_id);
        Set<Group> groups = new HashSet<>();
        List<Group> groups_breadcrumb = new LinkedList<>();

        Group group= groupRepo.findById(groupId)
                .orElseThrow();
        Group myGroup = groupRepo.findById(groupId)
                .orElseThrow();

        if (groupId != 0) {
            groups.addAll(groupRepo.findAllByParentId(group.getId()));
            while (group.getId() != 0) {
                groups_breadcrumb.add(group.getParent());
                group = group.getParent();
            }
            Collections.reverse(groups_breadcrumb);
        } else {
            groups.addAll(groupRepo.findAllByParentId(0L));
        }

        Iterable<ElementType> elementTypes = elementTypeRepo.findByGroup(myGroup);
        model.addAttribute("elements_type", elementTypes);

        Iterable<Category> categories =
                List.of(Category.values());
        model.addAttribute("categories", categories);

        model.addAttribute("nav_breadcrumb", groups_breadcrumb);
        model.addAttribute("nav", groups);
        model.addAttribute("my_group", myGroup);

        return "element";
    }

    @GetMapping("/view/{elem_id}")
    public String viewElement(
            @PathVariable String elem_id,
            Model model
    ) {

        Element elem = elementRepo.findById(Long.valueOf( elem_id ))
                .orElseThrow();
        model.addAttribute( "elem", elem );

        Iterable<String> elements_source =
                elementRepo.findElementSource(elem.getId());
        model.addAttribute("elem_source", elements_source);

        Iterable<String> elements_destination =
                elementRepo.findElementDestination(elem.getId());
        model.addAttribute("elem_destination", elements_destination);

        Iterable<Proxy> proxies = elem.getProxies();
        model.addAttribute("proxies", proxies);

        return "element_viewElement";
    }

    @GetMapping("/edit/{elem_id}")
    public String editElement(
            @PathVariable String elem_id,
            @RequestParam(required = false) String proxy_category,
            Model model
    ) {

        Element elem = elementRepo.findById(Long.valueOf( elem_id ))
                .orElseThrow();
        model.addAttribute( "elem", elem );

        model.addAttribute("element_category",
                Category.values());
        model.addAttribute("element_type",
                elementTypeRepo.findAll());

        Iterable<Proxy> proxies = elem.getProxies();
        model.addAttribute("proxies", proxies);

        if (proxy_category == null) {
            Iterable<Proxy> pr = proxyRepo.findAll();
            model.addAttribute("proxies_select", pr);
        } else {
            Iterable<Proxy> proxies_select = proxyRepo
                    .findAllByCategory(Category.valueOf(proxy_category));
            model.addAttribute("proxies_select", proxies_select);
        }

        return "element_editElement";
    }

    @PostMapping("/add_element")
    public String addElement(
//            @RequestParam( required = false ) String proxy_name,
            @RequestParam String this_category,
            @RequestParam String element_name,
            @RequestParam String description,
            @RequestParam String group_name,
            @RequestParam String element_type,
            Model model) {

        Category category = Category.valueOf(this_category);
        List<Group> groups_breadcrumb = new LinkedList<>();

        ElementType elementType = elementTypeRepo.findByType(element_type).get();

        Group group = groupRepo
                .findByName(group_name)
                .get(0);
        model.addAttribute("my_group", group );

        Element elem = new Element();
        elem.setName( element_name.trim() );
        elem.setDescription( description.trim() );
        elem.addGroup( group );
        elem.setElementType( elementType );
        elem.setCategory(category);

        elementRepo.save( elem );

        return "redirect:/element/" + group.getId();
    }

    @PostMapping("/edit/add_attribute")
    private String addAttribute(
            @RequestParam String path,
            @RequestParam String thisElementId,
            @RequestParam String proxy_name,
            Model model
    ) {

        Proxy proxy = proxyRepo
                .findByName( proxy_name )
                .orElseThrow();
        Element element = elementRepo
                .findById(
                Long.valueOf(thisElementId)
        )
                .orElseThrow();
        element.addProxy(proxy);
        elementRepo.save(element);

        if (proxy.getModule() == null) {
            proxy.setModule(element);
        }
        proxyRepo.save(proxy);

        return "redirect:" + path;
    }

    @PostMapping("/edit/link_elements")
    private String linkElements(
            @RequestParam String path,
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

        if (element_destination.equals(elementSource)) {
            return "redirect:" + path;
        }

        ElementsComposite elementsComposite = new ElementsComposite();
        elementsComposite.setElement_source( elementSource );
        elementsComposite.setElement_destination( elementDestination );
        elementsComposite.setProxy(proxy);
        elementsCompositeRepo.save( elementsComposite );

        return "redirect:" + path;
    }

    @PostMapping("/edit/changeElementName")
    private String changeElementName(
            @RequestParam String path,
            @RequestParam String element_id,
            @RequestParam String element_name
    ) {
        if (element_name.isBlank()) {
            return "redirect:" + path;
        }

        Long elementId = Long.valueOf(element_id);

        Element element = elementRepo.findById(elementId)
                .orElseThrow();
        element.setName(element_name);
        elementRepo.save(element);

        return "redirect:" + path;
    }

    @PostMapping("/edit/changeElementType")
    private String changeElementType(
            @RequestParam String path,
            @RequestParam String element_id,
            @RequestParam String element_type
    ) {
        Long elementId = Long.valueOf(element_id);

        ElementType elementType = elementTypeRepo
                .findByType(element_type)
                .orElseThrow();

        Element element = elementRepo.findById(elementId)
                .orElseThrow();
        element.setElementType(elementType);
        elementRepo.save(element);

        return "redirect:" + path;
    }

    @PostMapping("/edit/changeElementCategory")
    private String changeElementCategory(
            @RequestParam String path,
            @RequestParam String element_id,
            @RequestParam String element_category
    ) {
        Long elementId = Long.valueOf(element_id);

        Category category = Category.valueOf(element_category);

        Element element = elementRepo.findById(elementId)
                .orElseThrow();
        element.setCategory(category);
        elementRepo.save(element);

        return "redirect:" + path;
    }

    @PostMapping("/edit/changeElementDescription")
    private String changeElementDescription(
            @RequestParam String path,
            @RequestParam String element_id,
            @RequestParam String description
    ) {
        if (description.isBlank()) {
            return "redirect:" + path;
        }

        Long elementId = Long.valueOf(element_id);

        Element element = elementRepo.findById(elementId)
                .orElseThrow();
        element.setDescription(description);
        elementRepo.save(element);

        return "redirect:" + path;
    }
}