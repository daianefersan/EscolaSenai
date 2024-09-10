package com.poo.escola.entidades;

import java.time.LocalDate;
import java.util.Date;

public class Professor extends Pessoa{
    private LocalDate adimissaoData;
    private Double salario;

    public Professor(int matricula, String cpf, String nome, Date dataNascimento, Endereco endereco, String telefone,
            String email, String senha, LocalDate adimissaoData, Double salario) {
        super(matricula, cpf, nome, dataNascimento, endereco, telefone, email, senha);
        this.adimissaoData = adimissaoData;
        this.salario = salario;
    }

    public LocalDate getAdimissaoData() {
        return adimissaoData;
    }

    public void setAdimissaoData(LocalDate adimissaoData) {
        this.adimissaoData = adimissaoData;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
}
