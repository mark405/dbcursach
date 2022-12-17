package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.GenreDAO;
import com.cursach.filmprodvider.dao.SubDAO;
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
@RequestMapping("/subs")
public class SubController {

    private final SubDAO subDAO;

    @Autowired
    public SubController(final SubDAO subDAO) {
        this.subDAO = subDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("subs", subDAO.index());
        return "subs/allsubs";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }
}