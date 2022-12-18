package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.SubDAO;
import com.cursach.filmprodvider.dao.VoiceDAO;
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

    @GetMapping("/addvoice")
    public String addGenre(Model model) {
        return "voices/addvoice";
    }
    @PostMapping("/addvoice")
    public String addGenre(Model model, HttpServletRequest request) {
        String title = request.getParameter("title");
        String lang = request.getParameter("lang");


        voiceDAO.add(title, lang);

        return "redirect:/voices";
    }

    @GetMapping("/deletevoice")
    public String deleteVoice(Model model) {
        return "voices/deletevoice";
    }
    @PostMapping("/deletevoice")
    public String deleteVoice(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");

        voiceDAO.delete(id);
        return "redirect:/voices";
    }
}