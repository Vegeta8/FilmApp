package ua.may.filmapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.may.filmapp.dao.FilmDAO;
import ua.may.filmapp.models.Film;

import javax.validation.Valid;

@Controller
@RequestMapping("/films")
public class FilmController {

    private final FilmDAO filmDAO;

    @Autowired
    public FilmController(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    @GetMapping()
    public String list(Model model) {
        model.addAttribute("films", filmDAO.list());
        return "films/list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("film", filmDAO.show(id));
        return "films/show";
    }

    @GetMapping("/new")
    public String newFilm(Model model) {
       model.addAttribute("film", new Film());

        return "films/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("film") @Valid Film film,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "films/new";

        filmDAO.addFilm(film);
        return "redirect:/films";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("film", filmDAO.show(id));
        return "films/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("film") @Valid Film film, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "films/edit";
        filmDAO.update(id, film);
        return "redirect:/films";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        filmDAO.delete(id);
        return "redirect:/films";
    }
}
