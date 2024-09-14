package com.poo.escola.entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Nota {
    private double nota;
    private Aluno aluno;
    private Disciplina disciplina;

    public static List<Nota> notaList = new ArrayList<Nota>();

    public Nota(int nota, Aluno aluno, Disciplina disciplina) {
        this.nota = nota;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota( double nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public static void setNotaList(List<Nota> notaList) {
        Nota.notaList = notaList;
    }
    
    public static List<Nota> getNotaList() {
        return notaList;
    }

    public static void salvaNotaNoArquivo() {

        File file = new File("notes.txt");
        System.out.println("Saving notes to file: " + file.getAbsolutePath());
        if (!file.canWrite()) {
            System.out.println("No write permission to the file. Trying to grant write permission...");
            file.setWritable(true); // Grant write permission to the file
        }
        if (file.exists()) {
            file.delete(); // Delete the file if it already exists
        }
        try {
            file.createNewFile(); // Create a new file
        } catch (IOException e) {
            System.err.println("Error creating new file: " + e.getMessage());
            return; // Exit the method if there's an error creating the file
        }
        try (FileWriter writer = new FileWriter("notes.txt", true)) {
            for (Nota nota : notaList) {
                writer.write(nota.getAluno().getEmail() + "," + nota.getDisciplina().getNomeDisciplina() + "," + nota.getNota() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void carregaNotaDoArquivo(){
            File file = new File("notes.txt");
        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }

        notaList.clear(); // Clear the list before loading new data

        try (BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void processLine(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            System.out.println("Invalid line format: " + line);
            return;
        }

        Aluno aluno = Aluno.getAlunoPorEmail(parts[0]);
        Disciplina disciplina = Disciplina.getDisciplinaPorNome(parts[1]);

        if (aluno != null && disciplina != null) {
            try {
                Double nota = Double.parseDouble(parts[2]);
                Nota notaObjeto = new Nota();
                notaObjeto.setAluno(aluno);
                notaObjeto.setDisciplina(disciplina);
                notaObjeto.setNota(nota);
                aluno.addNota(notaObjeto);
                disciplina.addNota(notaObjeto);
                Nota.getNotaList().add(notaObjeto);
            } catch (NumberFormatException e) {
                System.out.println("Formato de nota invalida: " + parts[2]);
            }
        } else {
            System.out.println("Erro ao carregar a nota: Aluno ou disciplina nao encontrados.");
        }
    }

}