package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.ProducerDAO;
import com.cursach.filmprodvider.dao.ScriptWriterDAO;
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

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }
}
