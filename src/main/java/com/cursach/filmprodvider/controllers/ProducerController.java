package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.GenreDAO;
import com.cursach.filmprodvider.dao.ProducerDAO;
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
@RequestMapping("/producers")
public class ProducerController {

    private final ProducerDAO producerDAO;

    @Autowired
    public ProducerController(final ProducerDAO producerDAO) {
        this.producerDAO = producerDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("producers", producerDAO.index());
        return "producers/allproducers";
    }

    @GetMapping("/addproducer")
    public String addGenre(Model model) {
        return "producers/addproducer";
    }
    @PostMapping("/addproducer")
    public String addGenre(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        producerDAO.add(name, surname);

        return "redirect:/producers";
    }

    @GetMapping("/deleteproducer")
    public String deleteProducer(Model model) {
        model.addAttribute("producers", producerDAO.index());
        return "producers/deleteproducer";
    }
    @PostMapping("/deleteproducer")
    public String deleteProducer(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");

        producerDAO.delete(id);
        return "redirect:/producers";
    }

}
