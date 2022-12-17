package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.SubDAO;
import com.cursach.filmprodvider.dao.VoiceDAO;
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
@RequestMapping("/voices")
public class VoiceController {

    private final VoiceDAO voiceDAO;

    @Autowired
    public VoiceController(final VoiceDAO voiceDAO) {
        this.voiceDAO = voiceDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("voices", voiceDAO.index());
        return "voices/allvoices";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        return null;
    }
}