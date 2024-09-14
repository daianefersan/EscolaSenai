package com.poo.escola.entidades;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nomeDisciplina;

    private List<Nota> notaList = new ArrayList<>();

    public List<Nota> getNotaList() {
        return notaList;
    }

    public void addNota(Nota nota) {
        this.notaList.add(nota);
    }

    public static List<Disciplina> disciplinaList = new ArrayList <Disciplina> ();

    public static Disciplina getDisciplinaPorNome(String name) {
        for (Disciplina discipline : disciplinaList) {
            if (discipline.getNomeDisciplina().equals(nome)) {
                return disciplina;
            }
        }
        return null;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public static List<Disciplina> getDisciplinasList(){
        return disciplinaList;
    }

    public static void mostrarDisciplinaList(){
        if(!Disciplina.disciplinaList.isEmpty()){
            System.out.println("Lista Disciplina");
            for (Disciplina d : disciplinaList){
                System.out.println((disciplinaList.indexOf(d))+ "- " + d.getNomeDisciplina());
            }
        }else {
            System.out.println("Não há registros de disciplinas\n");
        }
    }

    public static void setDisciplinaList(List<Disciplina> disciplinaList) {
        Disciplina.disciplinaList = disciplinaList;
    }
    
    public static void alimentaDisciplina(){
        Disciplina disciplina1 = new Disciplina();
        disciplina1.setNomeDisciplina("Java");
        disciplinaList.add(disciplina1);

        Disciplina disciplina2 = new Disciplina();
        disciplina2.setNomeDisciplina("Logica de Programacao");
        disciplinaList.add(disciplina2);

        Disciplina disciplina3 = new Disciplina();
        disciplina3.setNomeDisciplina("Banco de Dados");
        disciplinaList.add(disciplina3);
    }
}
