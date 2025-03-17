package com.casacultural.cinema.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.casacultural.cinema.model.Filme;
import org.springframework.stereotype.Repository;

@Repository
public class FilmeRepository {

    private final List<Filme> filmes = new ArrayList<>();
    private Long proximoId = 1L;

    public FilmeRepository() {
        salvar(new Filme(1L, "Interestelar", "Um grupo de astronautas viaja...", "Ficção Científica", 2014));
        salvar(new Filme(2L, "Pulp Fiction", "As vidas de dois assassinos...", "Crime", 1994));
    }

    public Filme salvar(Filme filme) {
        if (filme.getId() == null) {
            filme.setId(proximoId++);
        }
        filmes.add(filme);
        return filme;
    }

    public Filme buscarPorId(Long id) {
        for(int i = 0; i < filmes.size(); i++){
         if   (filmes.get(i).getId() == id) {
            return filmes.get(i);
        }
        }
        
        
        
        return null ;
    }

    public List<Filme> buscarTodos() {
        return filmes;
    }
}
