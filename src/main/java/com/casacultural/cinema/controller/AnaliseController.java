
package com.casacultural.cinema.controller;

import com.casacultural.cinema.model.Analise;
import com.casacultural.cinema.model.Filme;
import com.casacultural.cinema.repository.AnaliseRepository;
import com.casacultural.cinema.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/analises")
public class AnaliseController {
      @Autowired
    private AnaliseRepository analiseRepository;
    
    @Autowired
    private FilmeRepository filmeRepository;

    @PostMapping("/filme/{filmeId}")
    public String adicionarAnalise(
            @PathVariable Long filmeId,
            @RequestParam("textoAnalise") String textoAnalise,
            @RequestParam("nota") Double nota) {
        
        Filme filme = filmeRepository.buscarPorId(filmeId);
        
        if (filme != null) {
            Analise analise = new Analise();
            analise.setFilme(filme);
            analise.setTextoAnalise(textoAnalise);
            analise.setNota(nota);
            
            analiseRepository.salvar(analise);
}
            return "redirect:/filmes/" + filmeId;
    }
}

