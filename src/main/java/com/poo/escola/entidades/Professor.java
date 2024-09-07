package com.poo.escola.entidades;

import java.util.Date;

public class Professor extends Pessoa{
    private Date adimissaoData;
    private Double salario;

    public Professor(int matricula, String cpf, String nome, Date dataNascimento, Endereco endereco, String telefone,
            String email, String senha, Date adimissaoData, Double salario) {
        super(matricula, cpf, nome, dataNascimento, endereco, telefone, email, senha);
        this.adimissaoData = adimissaoData;
        this.salario = salario;
    }

    public Date getAdimissaoData() {
        return adimissaoData;
    }

    public void setAdimissaoData(Date adimissaoData) {
        this.adimissaoData = adimissaoData;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
}
