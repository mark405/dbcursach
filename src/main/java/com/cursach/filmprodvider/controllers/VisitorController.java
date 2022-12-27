package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.GenreDAO;
import com.cursach.filmprodvider.dao.VisitorDAO;
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

    @GetMapping("/addvisitor")
    public String addGenre(Model model) {
        GenreDAO genreDAO = new GenreDAO();
        model.addAttribute("genres", genreDAO.index());
        return "visitors/addvisitor";
    }
    @PostMapping("/addvisitor")
    public String addGenre(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String genre = request.getParameter("genre");

        System.out.println(genre);

        visitorDAO.add(name, surname, genre);

        return "redirect:/visitors";
    }

    @GetMapping("/deletevisitor")
    public String deleteVisitor(Model model) {
        model.addAttribute("visitors", visitorDAO.index());
        return "visitors/deletevisitor";
    }
    @PostMapping("/deletevisitor")
    public String deleteVisitor(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");

        visitorDAO.delete(id);
        return "redirect:/visitors";
    }
}
