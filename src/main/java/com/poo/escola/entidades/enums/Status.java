package com.poo.escola.entidades.enums;

public enum Status {
    APROVADO ("Aprovado"),
    REPROVADO ("Reprovado"),
    EM_RECUPERACAO ("Em Recuperação");

    private final String nomePorExtenso;

    Status(String nomePorExtenso){
        this.nomePorExtenso = nomePorExtenso;
    }

    public String getNomePorExtenso() {
        return nomePorExtenso;
    }
    
}
