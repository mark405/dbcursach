package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.SubDAO;
import com.cursach.filmprodvider.dao.VisitorSubDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mark
 */
@Controller
@RequestMapping("/visitorsubs")
public class VisitorSubController {

    private final VisitorSubDAO visitorSubDAO;

    @Autowired
    public VisitorSubController(final VisitorSubDAO visitorSubDAO) {
        this.visitorSubDAO = visitorSubDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("visitorsubs", visitorSubDAO.index());
        return "subsofvisitors/allsubsofvisitors";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }
}
