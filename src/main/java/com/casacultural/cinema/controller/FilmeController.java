package com.casacultural.cinema.controller;

import com.casacultural.cinema.model.Filme;
import com.casacultural.cinema.repository.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/filmes")

public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/lista")
    public String listarFilmes(Model model) {
        List<Filme> filmes = filmeRepository.buscarTodos();
        System.out.println("Filmes encontrados: " + filmes); // Debug
        model.addAttribute("filmes", filmes);
        return "lista";
    }

    @GetMapping("/cadastro")
    public String formularioCadastro(Model model) {
        model.addAttribute("filme", new Filme());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarFilme(Filme filme) {
        filmeRepository.salvar(filme);
        return "redirect:/filmes";
    }

    @GetMapping("/{id}")
    public String detalhesFilme(@PathVariable Long id, Model model) {
        Filme filme = filmeRepository.buscarPorId(id);
        model.addAttribute("filme", filme);
        return "detalhes";
    }

}
