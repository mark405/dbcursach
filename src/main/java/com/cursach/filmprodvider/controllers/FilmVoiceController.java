package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.FilmVoiceDAO;
import com.cursach.filmprodvider.dao.VoiceDAO;
import com.cursach.filmprodvider.models.FilmVoice;
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
@RequestMapping("/filmvoices")
public class FilmVoiceController {

    private final FilmVoiceDAO filmVoiceDAO;

    @Autowired
    public FilmVoiceController(final FilmVoiceDAO filmVoiceDAO) {
        this.filmVoiceDAO = filmVoiceDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("filmvoices", filmVoiceDAO.index());
        return "filmvoices/allfilmvoices";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }
}