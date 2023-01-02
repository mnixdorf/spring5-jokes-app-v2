package guru.springframework.jokeapplication.controllers;

import guru.springframework.jokeapplication.services.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokesService jokesService;

    @Autowired //constructor: not required but better for readability
    public JokeController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model){

        model.addAttribute("joke", jokesService.getJoke());

        return "index";
    }
}
