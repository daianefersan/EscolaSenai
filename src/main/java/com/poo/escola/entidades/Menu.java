package com.poo.escola.entidades;

import java.util.Scanner;

import com.poo.escola.entidades.enums.Status;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static com.poo.escola.entidades.Aluno.getAlunoPorEmail;

public class Menu {

    private static Status status; 
    private static String usuarioLogado = null;
    private static String funcaoUsuario = null;

    public static void imprimeBotelim(String usuarioLogado) {
        Aluno student = getAlunoPorEmail(usuarioLogado);

        if (aluno != null){
            System.out.println("Boletim do ALuno: ");
            System.out.println("Nome: " + student.getNome());
            System.out.println("Email: " + student.getEmail());

            Nota.carregaNotaDoArquivo();

            List<Nota> alunoNota = new ArrayList<>();
            for(Nota nota : Nota.getNotaList()){
                if (nota.getAluno().equals(aluno)){
                    alunoNota.add(nota);
                }
            }
            Nota nota1 = aluno.getNota();
            if (!alunoNota.isEmpty()){

                for (Nota nota : alunoNota){
                    if (nota.getNota() >= 6 ){
                        status= Status.APROVADO;
                        break;
                    }else if (nota1.getNota() < 3){
                        status= Status.REPROVADO;
                        break;
                    }else if (nota.getNota() >= 3){
                        status= Status.EM_RECUPERACAO;
                        break;
                    }
                }
                System.out.println("Status: " + status.getStatus());
                System.out.println("Nota: ");
                for (Nota nota : alunoNota){
                    System.out.println("Disciplina: " + nota.getDisciplina());
                    System.out.println("Nota: " + nota.getNota());
                }
            }else {
                System.out.println("Notas nao encontradas");
            }
        }else {
            System.out.println("Estudante nao encontrado");
        }
    }


    public static void login() {
        Scanner leia = new Scanner(System.in);
        System.out.println("-- Bem-vindo ao sistema, entre com o seu login! --");
        System.out.println("Email: ");
        String usuarioEmail = leia.nextLine();
        System.out.println("Senha: ");
        String senha = leia.nextLine();


        for(Secretaria s : Secretaria.getSecretaria()) {
            if (usuarioEmail.equals(s.getEmail()) && senha.equals(s.getSenha())) {
                usuarioLogado = usuarioEmail;
                funcaoUsuario = "Secretaria";
                System.out.println("Login realizado com sucesso. (Secretaria)!");
            }
        }
        for (Professor p: Professor.getProfessorList()) {
            if (usuarioEmail.equals(p.getEmail()) &&senha.equals(p.getSenha())){
                usuarioLogado = usuarioEmail;
                funcaoUsuario = "Professor";
                System.out.println("Login realizado com sucesso. (Professor)!");
            }
        }

        for (Aluno a : Aluno.getAlunoList()) {
            if (usuarioEmail.equals(a.getEmail()) && senha.equals(a.getSenha())) {
                usuarioLogado = usuarioEmail;
                funcaoUsuario = "Aluno";
                System.out.println("Login realizado com sucesso. (Aluno)!");
            }
        }
        if(usuarioEmail.isEmpty() || senha.isEmpty()){
            System.out.println("Usuario ou senha invalidos");
            usuarioLogado = null;
            funcaoUsuario = null;
        }
    }


    public static void menuFinal(){
        int opcaoM = 8;
        if (usuarioLogado == null){
            System.out.println("Você precisa estar logado.");
            login();
        }

        do {
            System.out.println("\n -- MENU --");
            System.out.println("O que voce deseja fazer?");
            if (funcaoUsuario.equals("Secretaria")){
                System.out.println("1 - Menu Aluno");
                System.out.println("2 - Menu Professor");

            }else if (funcaoUsuario.equals("Teacher")){
                System.out.println("1 - Imprime Boletim");
                System.out.println("2 - Atribuir Nota");
            }else if (funcaoUsuario.equals("Aluno")){
                System.out.println("1 - Imprime Boletim");
            }    
            System.out.println("0 - Sair\n");
            System.out.println("Digite uma opcao: ");
            Scanner leia = new Scanner(System.in);

            try{

                opcaoM = leia.nextInt();
                System.out.println("\n");

                switch (opcaoM) {
                    case 1: 
                        if (funcaoUsuario.equals("Secretaria")) {
                            Secretaria.secretariaMenuAluno();
                        }else if (funcaoUsuario.equals("Professor")) {
                            System.out.println("O Boletim foi impresso.");
                        }else if (funcaoUsuario.equals("Aluno")){
                            System.out.println("Imprimindo Boletim");
                        }
                        break;  
                    case 2: 
                     if (funcaoUsuario.equals("Secretaria")) {
                            Secretaria.secretariaMenuProfessor();
                        }else if (funcaoUsuario.equals("Professor")) {
                            System.out.println("Insira as notas");
                        }
                        break;  
                    case 0: 
                        System.out.println("Saindo...");
                        usuarioLogado = null;
                        funcaoUsuario = null;
                        break;
                    default:
                        System.out.println("Opcao Invalida!");
                        break;

                }
            }catch (InputMismatchException e) {
                System.out.println("Por favor, digite uma das opcoes do menu!");
            }        
        }while (opcaoM != 0);
    }
}