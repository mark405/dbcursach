package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.FilmDAO;
import com.cursach.filmprodvider.dao.FilmSubDAO;
import com.cursach.filmprodvider.dao.SubDAO;
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

    @GetMapping("/addfilmsub")
    public String addGenre(Model model) {
        FilmDAO filmDAO = new FilmDAO();
        SubDAO subDAO = new SubDAO();
        model.addAttribute("films", filmDAO.index());
        model.addAttribute("subs", subDAO.index());

        return "filmsubs/addfilmsub";
    }

    @PostMapping("/addfilmsub")
    public String addGenre(Model model, HttpServletRequest request) {
        String filmID = request.getParameter("filmid");
        String subID = request.getParameter("subid");


        filmSubDAO.add(filmID, subID);
        System.out.println(filmID);
        return "redirect:/filmsubs";
    }

    @GetMapping("/deletefilmsub")
    public String deleteFilmSub(Model model) {
        FilmDAO filmDAO = new FilmDAO();
        SubDAO subDAO = new SubDAO();
        model.addAttribute("films", filmDAO.index());
        model.addAttribute("subs", subDAO.index());
        return "filmsubs/deletefilmsub";
    }

    @PostMapping("/deletefilmsub")
    public String deleteGenre(Model model, HttpServletRequest request) {
        String filmid = request.getParameter("filmid");
        String subid = request.getParameter("subid");


        filmSubDAO.delete(filmid, subid);
        return "redirect:/filmsubs";
    }
}

