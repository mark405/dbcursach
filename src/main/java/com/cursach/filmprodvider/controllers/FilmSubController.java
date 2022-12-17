package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.FilmSubDAO;
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
@RequestMapping("/filmsubs")
public class FilmSubController {

    private final FilmSubDAO filmSubDAO;

    @Autowired
    public FilmSubController(final FilmSubDAO filmSubDAO) {
        this.filmSubDAO = filmSubDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("filmsubs", filmSubDAO.index());
        return "filmsubs/allfilmsubs";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }
}

