package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.FilmDAO;
import com.cursach.filmprodvider.dao.GenreDAO;
import com.cursach.filmprodvider.dao.ProducerDAO;
import com.cursach.filmprodvider.dao.ScriptWriterDAO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/addfilm")
    public String addGenre(Model model) {
        GenreDAO genreDAO = new GenreDAO();
        ProducerDAO producerDAO = new ProducerDAO();
        ScriptWriterDAO scriptWriterDAO = new ScriptWriterDAO();
        model.addAttribute("genres", genreDAO.index());
        model.addAttribute("producers", producerDAO.index());
        model.addAttribute("scriptwriters", scriptWriterDAO.index());

        return "films/addfilm";
    }

    @PostMapping("/addfilm")
    public String addGenre(Model model, HttpServletRequest request) {
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String duration = request.getParameter("duration");
        String year = request.getParameter("year");
        String rating = request.getParameter("rating");
        String cash = request.getParameter("cash");
        String episodes = request.getParameter("episodes");
        String seasons = request.getParameter("seasons");
        String producer = request.getParameter("producer");
        String scriptwriter = request.getParameter("scriptwriter");
        String description = request.getParameter("description");


        filmDAO.add(title, genre, duration, year, rating, cash, episodes, seasons, producer, scriptwriter, description);

        return "redirect:/films";
    }

    @GetMapping("/deletefilm")
    public String deleteFilm(Model model) {
        model.addAttribute("films", filmDAO.index());
        return "films/deletefilm";
    }

    @PostMapping("/deletefilm")
    public String deleteFilm(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");

        filmDAO.delete(id);
        return "redirect:/films";
    }

    @GetMapping("/sortedbyratefilms")
    public String sortByRating(Model model) {
        model.addAttribute("films", filmDAO.sortByRating());
        return "films/allfilms";
    }

    @GetMapping("/sortedbydescratefilms")
    public String sortByDescRating(Model model) {
        model.addAttribute("films", filmDAO.sortByDescRating());
        return "films/allfilms";
    }

    @GetMapping("/sortedbycashfilms")
    public String sortByCash(Model model) {
        model.addAttribute("films", filmDAO.sortByCash());
        return "films/allfilms";
    }

    @GetMapping("/sortedbydesccashfilms")
    public String sortByDescCash(Model model) {
        model.addAttribute("films", filmDAO.sortByDescCash());
        return "films/allfilms";
    }
}
