package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.ProducerDAO;
import com.cursach.filmprodvider.dao.ScriptWriterDAO;
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
@RequestMapping("/scriptwriters")
public class ScriptWriterController {

    private final ScriptWriterDAO scriptWriterDAO;

    @Autowired
    public ScriptWriterController(final ScriptWriterDAO scriptWriterDAO) {
        this.scriptWriterDAO = scriptWriterDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("scriptwriters", scriptWriterDAO.index());
        return "scriptwriters/allscriptwriters.html";
    }

    @GetMapping("/addscriptwriter")
    public String addGenre(Model model) {
        return "scriptwriters/addscriptwriter";
    }
    @PostMapping("/addscriptwriter")
    public String addGenre(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        scriptWriterDAO.add(name, surname);

        return "redirect:/scriptwriters";
    }

    @GetMapping("/deletescriptwriter")
    public String deleteScriptWriter(Model model) {
        model.addAttribute("scriptwriters", scriptWriterDAO.index());
        return "scriptwriters/deletescriptwriter";
    }
    @PostMapping("/deletescriptwriter")
    public String deleteProducer(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");

        scriptWriterDAO.delete(id);
        return "redirect:/scriptwriters";
    }
}
