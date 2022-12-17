package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.GenreDAO;
import com.cursach.filmprodvider.dao.ProducerDAO;
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

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }
}
