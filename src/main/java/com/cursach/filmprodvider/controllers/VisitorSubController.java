package com.cursach.filmprodvider.controllers;

import com.cursach.filmprodvider.dao.SubDAO;
import com.cursach.filmprodvider.dao.VisitorSubDAO;
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
@RequestMapping("/subsofvisitors")
public class VisitorSubController {

    private final VisitorSubDAO visitorSubDAO;

    @Autowired
    public VisitorSubController(final VisitorSubDAO visitorSubDAO) {
        this.visitorSubDAO = visitorSubDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("subsofvisitors", visitorSubDAO.index());
        return "subsofvisitors/allsubsofvisitors";
    }

    @GetMapping("/addsubofvisitor")
    public String addGenre(Model model) {
        return "subsofvisitors/addsubofvisitor";
    }
    @PostMapping("/addsubofvisitor")
    public String addGenre(Model model, HttpServletRequest request) {
        String subId = request.getParameter("subid");
        String visitorId = request.getParameter("visitorid");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String status = request.getParameter("status");



        visitorSubDAO.add(subId, visitorId, start, end, status);

        return "redirect:/subsofvisitors";
    }

    @GetMapping("/deletesubofvisitor")
    public String deleteSubOfVisitor(Model model) {
        return "subsofvisitors/deletesubofvisitor";
    }
    @PostMapping("/deletesubofvisitor")
    public String deleteSubOfVisitor(Model model, HttpServletRequest request) {
        String subid = request.getParameter("subid");
        String visitorid = request.getParameter("visitorid");


        visitorSubDAO.delete(subid, visitorid);
        return "redirect:/subsofvisitors";
    }
}
