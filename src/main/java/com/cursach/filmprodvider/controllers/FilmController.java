package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.FilmDAO;
import com.cursach.filmprodvider.dao.FilmVoiceDAO;
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
@RequestMapping("/films")
public class FilmController {
    private final FilmDAO filmDAO;

    @Autowired
    public FilmController(final FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("films", filmDAO.index());
        return "films/allfilms";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }
}
