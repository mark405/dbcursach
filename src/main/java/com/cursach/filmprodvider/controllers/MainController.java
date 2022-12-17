package com.cursach.filmprodvider.controllers;

/**
 * @author mark
 */
import com.cursach.filmprodvider.dao.QueryDAO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final QueryDAO queryDAO;
    private String res;

    public MainController(final QueryDAO queryDAO) {
        this.queryDAO = queryDAO;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @PostMapping("/")
    public String homeSubmit(Model model, HttpServletRequest request) {
        String SQL = request.getParameter("val");

        res = queryDAO.execute(SQL);

        model.addAttribute("result", res);


        return "index";
    }

}
