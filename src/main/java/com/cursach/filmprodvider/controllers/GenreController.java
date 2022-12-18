package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.GenreDAO;
import com.cursach.filmprodvider.models.Genre;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping
//    public String deleteGenre(Model model, HttpServletRequest request) {
//        String id = request.getParameter("id");
//        req.get
//        System.out.println(id);
//        genreDAO.delete(id);
//        return "redirect:/genres";
//    }

    @GetMapping("/addgenre")
    public String addGenre(Model model) {
        return "genres/addgenre";
    }
    @PostMapping("/addgenre")
    public String addGenre(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");

        genreDAO.add(name);
        System.out.println(name);
        return "redirect:/genres";
    }

    @GetMapping("/deletegenre")
    public String deleteGenre(Model model) {
        return "genres/deletegenre";
    }
    @PostMapping("/deletegenre")
    public String deleteGenre(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");

        genreDAO.delete(id);
        return "redirect:/genres";
    }


}
