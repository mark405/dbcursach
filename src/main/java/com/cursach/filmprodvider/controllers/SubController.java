package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.GenreDAO;
import com.cursach.filmprodvider.dao.SubDAO;
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

    @GetMapping("/addsub")
    public String addGenre(Model model) {
        return "subs/addsub";
    }
    @PostMapping("/addsub")
    public String addGenre(Model model, HttpServletRequest request) {
        String type = request.getParameter("type");
        String price = request.getParameter("price");

        subDAO.add(type, Double.parseDouble(price));

        return "redirect:/subs";
    }

    @GetMapping("/deletesub")
    public String deleteSub(Model model) {
        model.addAttribute("subs", subDAO.index());
        return "subs/deletesub";
    }
    @PostMapping("/deletesub")
    public String deleteProducer(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");

        subDAO.delete(id);
        return "redirect:/subs";
    }
}