package com.example.home.model;

public class AnimaisExtintosModel {
    private int id;            // ID do animal extinto
    private String nome;       // Nome do animal extinto
    private String sobre;      // Descrição sobre o animal extinto
    private int classe;        // Classe do animal (como mamífero, réptil, etc.)
    private int existentes;    // Número de animais existentes
    private String estado;     // Estado do animal (extinto, em extinção, etc.)

    // Construtor padrão
    public AnimaisExtintosModel() {
    }

    // Construtor com todos os campos
    public AnimaisExtintosModel(int id, String nome, String sobre, int classe, int existentes, String estado) {
        this.id = id;
        this.nome = nome;
        this.sobre = sobre;
        this.classe = classe;
        this.existentes = existentes;
        this.estado = estado;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public int getExistentes() {
        return existentes;
    }

    public void setExistentes(int existentes) {
        this.existentes = existentes;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
