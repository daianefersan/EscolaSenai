package com.poo.escola.entidades;

import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import com.poo.escola.entidades.enums.Status;

public class Aluno extends Pessoa {
    private LocalDate dataMatricula;
    private String curso;
    private static Status status;

    public static List<Nota> notaList = new ArrayList<Nota>();

    public List<Nota> getNotaList() {
        return notaList;
    }

    public void addNota(Nota nota) {
        this.notaList.add(nota);
    }
    
    public static List<Aluno> alunoList = new ArrayList<Aluno>();

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
        return "Aluno [dataMatricula=" + dataMatricula + ", curso=" + curso + "]";
    }

    public static void matriculaAluno(){
        System.out.println(" -- Registrando um novo aluno -- ");
        System.out.println("Nome: ");
        Scanner leia = new Scanner (System.in);
        String nome = leia.nextLine();
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        Aluno.alunoList.add(aluno);
    }

    public static void atualizaAluno(){
        if (!Aluno.alunoList.isEmpty()) {
            System.out.println("Lista de Alunos: ");
            mostrarListaAluno();
            System.out.println("Digite o número do índice de ALUNO a ser atualizado: ");
            Scanner leia = new Scanner(System.in);
            int alunoIndice = leia.nextInt() - 1;
            if (alunoIndice >= 0 && alunoIndice < Aluno.alunoList.size()){
                Aluno alunoAtualizar = Aluno.alunoList.get(alunoIndice);
                System.out.println("Digite um novo nome: ");
                leia.nextLine();
                String novoNome = leia.nextLine();
                alunoAtualizar.setNome(novoNome);
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Número de Aluno Invalido!");
            }
        } else {
            System.out.println("Ainda nao existemAlunos registrados!");
        }    

    }

    public static void removeAluno(){
        if (!Aluno.alunoList.isEmpty()) {
            System.out.println("Lista de Alunos: ");
            mostrarListaAluno();
            System.out.println("Digite o número do índice de ALUNO a ser removido: ");
            Scanner leia = new Scanner(System.in);
            int alunoIndice = leia.nextInt() - 1;
            if (alunoIndice >= 0 && alunoIndice < Aluno.alunoList.size()){
                Aluno.alunoList.remove (alunoIndice);
                System.out.println("Alunor removido com sucesso!");
            } else {
                System.out.println("Número de Aluno Invalido!");
            }
        } else {
            System.out.println("Ainda nao existem Alunos registrados!");
        }    

    }

    public static void mostrarListaAluno(){
        if (!Aluno.alunoList.isEmpty()){
            System.out.println("Lista de Alunos: ");
            for (Aluno a : alunoList){
                System.out.println((alunoList.indice0f(a)) + "- " + a.getNome() + " / data de matricula: " + a.getDataMatricula() + "/ email:  " + a.getEmail() + " / curso: " + a.getCurso());
            }
        } else {
            System.out.println("Ainda nao existem alunos registrados!");
        }
    }

    public static void alimentaAluno(){
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Luan");
        aluno1.setDataMatricula(new LocalDate());
        aluno1.setEmail("luanG@gmail.com");
        aluno1.setCurso("Desenvolvimento de Software");
        alunoList.add(aluno1);

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Carlos");
        aluno2.setDataMatricula(new LocalDate());
        aluno2.setEmail("carlosG@gmail.com");
        aluno2.setCurso("Desenvolvimento de Software");
        alunoList.add(aluno2);

        Aluno aluno3 = new Aluno();
        aluno3.setNome("Marcos");
        aluno3.setDataMatricula(new LocalDate());
        aluno3.setEmail("marcosG@gmail.com");
        aluno3.setCurso("Desenvolvimento de Software");
        alunoList.add(aluno3);

    }    

    public static List<Aluno> getAlunoList(){
        return alunoList;
    }

    public static Aluno getAlunoPorEmail(String email){
        for (Aluno aluno : alunoList){
            if (aluno.getEmail().equals(email)){
                return aluno;
            }
        }
        return null;
    }
}