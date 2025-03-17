
package com.casacultural.cinema.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.casacultural.cinema.model.Analise;
import com.casacultural.cinema.model.Filme;
import org.springframework.stereotype.Repository;

@Repository
public class AnaliseRepository {
    private final Map<Long, Analise> analises = new HashMap<>();
    private Long proximoId = 1L;
    
    public Analise salvar(Analise analise) {
        if (analise.getId() == null) {
            analise.setId(proximoId++);
}
  Filme filme = analise.getFilme();
        filme.adicionarAnalise(analise);
        
        analises.put(analise.getId(), analise);
        return analise;
    }

    public List<Analise> buscarAnalisesPorFilme(Long filmeId) {
        List<Analise> analisesPorFilme = new ArrayList<>();
        
        for (Analise analise : analises.values()) {
            if (analise.getFilme().getId().equals(filmeId)) {
                analisesPorFilme.add(analise);
            }
        }
        
        return analisesPorFilme;
    }
   }