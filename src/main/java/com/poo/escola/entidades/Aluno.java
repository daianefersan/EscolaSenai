package com.poo.escola.entidades;

import java.time.LocalDate;
import java.util.Date;

public class Aluno extends Pessoa{
    private LocalDate dataMatricula;
    private String curso;
    private Status status;
    
    public Aluno(int matricula, String cpf, String nome, Date dataNascimento, Endereco endereco, String telefone,
            String email, String senha, LocalDate dataMatricula, String curso, Status status) {
        super(matricula, cpf, nome, dataNascimento, endereco, telefone, email, senha);
        this.dataMatricula = dataMatricula;
        this.curso = curso; 
        this.status = status;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Aluno [dataMatricula=" + dataMatricula + ", curso=" + curso + ", status=" + status.getNomePorExtenso() + "]";
    }    
    
}
