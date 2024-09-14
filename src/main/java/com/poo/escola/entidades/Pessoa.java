package com.poo.escola.entidades;

import java.time.LocalDate;

public abstract class Pessoa {

    public static int countMatricula = 1001;

    private int matricula;
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private String telefone;
    private String email;
    private String senha;

    public Pessoa(int matricula, String cpf, String nome, LocalDate dataNascimento, Endereco endereco, String telefone,
            String email, String senha) {
        this.matricula = countMatricula;
        countMatricula ++;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Pessoa(){
        this.matricula = countMatricula;
        countMatricula ++;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf == null || cpf.isEmpty() || !isValidCpf (cpf)){
            System.out.println("CPF invalido!");
        }else{
            this.cpf = cpf;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha == null || senha.isEmpty() || !isValidSenha(senha)){
            System.out.println("Senha invalida!");
        }else{
            this.senha = senha;
        }
    }
    private boolean isValidCpf(String cpf){
        if(cpf.length() != 11){
            return false;
        }else{
            return true;    
        }
    }
    private boolean isValidSenha(String senha){
        if(senha.length() < 8){
            return false;
        }else{
            return true;    
        }
    }

    @Override
    public String toString() {
        return "Pessoa [matricula=" + matricula + ", cpf=" + cpf + ", nome=" + nome + ", dataNascimento="
                + dataNascimento + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", senha="
                + senha + "]";
    }
}
