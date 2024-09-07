package com.poo.escola.entidades;

import java.util.Date;

public class Aluno extends Pessoa{
    private Date dataMatricula;
    private String curso;
    private Nota nota;
    
    public Aluno(int matricula, String cpf, String nome, Date dataNascimento, Endereco endereco, String telefone,
            String email, String senha, Date dataMatricula, String curso, Nota nota) {
        super(matricula, cpf, nome, dataNascimento, endereco, telefone, email, senha);
        this.dataMatricula = dataMatricula;
        this.curso = curso;
        this.nota = nota;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
    
}
