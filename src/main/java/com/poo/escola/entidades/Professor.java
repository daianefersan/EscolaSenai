package com.poo.escola.entidades;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Date;
import java.util.List;

import com.poo.escola.entidades.enums.Status;

public class Professor extends Pessoa{
    private LocalDate adimissaoData;
    private Double salario;

    public static List<Professor> professorList = new ArrayList<Professor>();

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

    public static List<Professor> getProfessorList() {
        return professorList;
    }

    public static void matriculaProfessor(){
        System.out.println(" -- Registrando um novo professor -- ");
        System.out.println("Nome: ");
        Scanner leia = new Scanner (System.in);
        String nome = leia.nextLine();
        Professor professor = new Professor();
        professor.setNome(nome);
        Professor.professorList.add(professor);
    }

    public static void atualizaProfessor(){
        if (!Professor.professorList.isEmpty()) {
            System.out.println("Lista de Professores: ");
            mostrarListaProfessor();
            System.out.println("Digite o número do índice de PROFESSOR a ser atualizado: ");
            Scanner leia = new Scanner(System.in);
            int professorIndice = leia.nextInt() - 1;
            if (professorIndice >= 0 && professorIndice < Professor.professorList.size()){
                Professor professorAtualizar = Professor.professorList.get(professorIndice);
                System.out.println("Digite um novo nome: ");
                leia.nextLine();
                String novoNome = leia.nextLine();
                professorAtualizar.setNome(novoNome);
                System.out.println("Professor atualizado com sucesso!");
            } else {
                System.out.println("Número de Professor Invalido!");
            }
        } else {
            System.out.println("Ainda nao existem professores registrados!");
        }    

    }

    public static void removeProfessor(){
        if (!Professor.professorList.isEmpty()) {
            System.out.println("Lista de Professores: ");
            mostrarListaProfessor();
            System.out.println("Digite o número do índice de PROFESSOR a ser removido: ");
            Scanner leia = new Scanner(System.in);
            int professorIndice = leia.nextInt() - 1;
            if (professorIndice >= 0 && professorIndice < Professor.professorList.size()){
                Professor.professorList.remove (professorIndice);
                System.out.println("Professor removido com sucesso!");
            } else {
                System.out.println("Número de Professor Invalido!");
            }
        } else {
            System.out.println("Ainda nao existem professores registrados!");
        }    

    }

    public static void mostrarListaProfessor(){
        if (!Professor.professorList.isEmpty()){
            System.out.println("Lista de Professores: ");
            for (Professor p : professorList){
                System.out.println((professorList.index0f(p)) + "- " + p.getNome() + " / salario: " + p.getSalario() + "/ email:  " + p.getEmail() + " / data de admissao: " + p.getDataAdmissao());
            }
        } else {
            System.out.println("Ainda nao existem professores registrados!");
        }
    }

    public static void alimentaProfessor(){
        Professor professor1 = new Professor();
        professor1.setNome("Arthur");
        professor1.setSalario(3200.00);
        professor1.setEmail("arthurG@gmail.com");
        professor1.setAdimissaoData(new LocalDate());
        professorList.add(professor1);

        Professor professor2 = new Professor();
        professor2.setNome("Roni");
        professor2.setSalario(3200.00);
        professor2.setEmail("roni@gmail.com");
        professor2.setAdimissaoData(new LocalDate());
        professorList.add(professor2);

        Professor professor3 = new Professor();
        professor3.setNome("Pedro");
        professor3.setSalario(3200.00);
        professor3.setEmail("pedroG@gmail.com");
        professor3.setAdimissaoData(new LocalDate());
        professorList.add(professor3);

        Professor professor4 = new Professor();
        professor4.setNome("Lucas");
        professor4.setSalario(3200.00);
        professor4.setEmail("lucasG@gmail.com");
        professor4.setAdimissaoData(new LocalDate());
        professorList.add(professor4);
    }

    public static void atribuiNota() {
        System.out.println("Atribuindo Nota");
        Aluno.mostrarListaAluno();
        System.out.println("Digite o número do aluno para atribuir nota: ");
        Scanner leia = new Scanner(System.in);
        int alunoIndex = leia.nextInt() - 1;
        if (alunoIndex >= 0 && alunoIndex <= Aluno.getAlunoList().size()) {
            Disciplina.mostrarDisciplinaList();
            System.out.println("Okay, agora digite o numero da disciplina que deseja atribuir nota: ");
            int disciplineIndex = leia.nextInt() - 1;
            if (disciplineIndex >= 0 && disciplineIndex <= Disciplina.getDisciplinaList().size()) {
                Nota nota1 = new Nota();
                System.out.println("Qual a nota do aluno: ");
                Double takeNote1 = leia.nextDouble();
                nota1.setNota(alunoIndex);(takeNota1);
                nota1.setAluno(Aluno.getAlunoList().get(alunoIndex));
                nota1.setDiscipline(Disciplina.getDisciplinaList().get(disciplineIndex));
                Nota.notaList.add(nota1);
                Nota.salvaNotaNoArquivo();
            }

        } else {
            System.out.println("Numero de aluno invalido \n");
        }

    }


}
