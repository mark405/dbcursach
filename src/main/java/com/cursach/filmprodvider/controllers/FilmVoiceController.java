package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.FilmVoiceDAO;
import com.cursach.filmprodvider.dao.VoiceDAO;
import com.cursach.filmprodvider.models.FilmVoice;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/addfilmvoice")
    public String addGenre(Model model) {
        return "filmvoices/addfilmvoice";
    }

    @PostMapping("/addfilmvoice")
    public String addGenre(Model model, HttpServletRequest request) {
        String filmId = request.getParameter("filmid");
        String voiceId = request.getParameter("voiceid");


        filmVoiceDAO.add(filmId, voiceId);

        return "redirect:/filmvoices";
    }

    @GetMapping("/deletefilmvoice")
    public String deleteFilmVoice(Model model) {
        return "filmvoices/deletefilmvoice";
    }
    @PostMapping("/deletefilmvoice")
    public String deleteFilmVoice(Model model, HttpServletRequest request) {
        String filmid = request.getParameter("filmid");
        String voiceid = request.getParameter("voiceid");


        filmVoiceDAO.delete(filmid, voiceid);
        return "redirect:/filmvoices";
    }
}