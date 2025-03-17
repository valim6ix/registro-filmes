
package com.casacultural.cinema.model;


public class Analise { 
    private Long id;
    private Filme filme;
    private String textoAnalise;
    private Double nota; 

    public Analise() {
    }

    public Analise(Long id, Filme filme, String textoAnalise, Double nota) {
        this.id = id;
        this.filme = filme;
        this.textoAnalise = textoAnalise;
        this.nota = nota;
    }
       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getTextoAnalise() {
        return textoAnalise;
    }

    public void setTextoAnalise(String textoAnalise) {
        this.textoAnalise = textoAnalise;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
