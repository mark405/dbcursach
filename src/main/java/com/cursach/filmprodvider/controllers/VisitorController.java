package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.GenreDAO;
import com.cursach.filmprodvider.dao.VisitorDAO;
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
@RequestMapping("/visitors")
public class VisitorController {

    private final VisitorDAO visitorDAO;

    @Autowired
    public VisitorController(final VisitorDAO visitorDAO) {
        this.visitorDAO = visitorDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("visitors", visitorDAO.index());
        return "visitors/allvisitors";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }
}
