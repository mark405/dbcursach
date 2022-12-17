package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.GenreDAO;
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
@RequestMapping("/genres")
public class GenreController {

    private final GenreDAO genreDAO;

    @Autowired
    public GenreController(final GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("genres", genreDAO.index());
        return "genres/allgenres";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }
}
