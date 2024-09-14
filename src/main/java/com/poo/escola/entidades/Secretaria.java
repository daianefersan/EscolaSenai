package com.poo.escola.entidades;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;

public class Secretaria extends Pessoa {
    
    private String email;
    private String senha;

    public static List<Secretaria> secretaria = new ArrayList<Secretaria>();

    public static void secretariaMenuAluno(){
        int opcaoA = 8;

        do{
            System.out.println("\n -- MENU --");
            System.out.println("O que voce deseja fazer?");
            System.out.println("1 - Registrar novo estudante");
            System.out.println("2 - Atualizar estudante");
            System.out.println("3 - Deletar estudante");
            System.out.println("4 - Listar estudantes");
            System.out.println("0 - Sair\n");
            System.out.println("Digite uma opcao: ");
            Scanner leia = new Scanner(System.in);
            try{

                opcaoA = leia.nextInt();
                System.out.println("\n");

                switch (opcaoA) {
                    case 1: 
                        Aluno.matriculaAluno();
                        break;
                    case 2: 
                        Aluno.atualizaAluno();
                        break;
                    case 3: 
                        Aluno.removeAluno();
                        break;
                    case 4: 
                        Aluno.mostrarListaAluno();
                        break;
                    case 0: 
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opcao Invalida!");
                        break;

                }
            }catch (InputMismatchException e) {
                System.out.println("Por favor, digite uma das opcoes do menu!");
            }        
        }while (opcaoA != 0);
    }

    public static void secretariaMenuProfessor(){
        int opcaoP = 8;

        do{
            System.out.println("\n -- MENU --");
            System.out.println("O que voce deseja fazer?");
            System.out.println("1 - Registrar novo professor");
            System.out.println("2 - Atualizar professor");
            System.out.println("3 - Deletar professor");
            System.out.println("4 - Listar professores");
            System.out.println("0 - Sair\n");
            System.out.println("Digite uma opcao: ");
            Scanner leia = new Scanner(System.in);
            try{

                opcaoP = leia.nextInt();
                System.out.println("\n");

                switch (opcaoP) {
                    case 1: 
                        Professor.matriculaProfessor();
                        break;
                    case 2: 
                        Professor.atualizaProfessor();
                        break;
                    case 3: 
                        Professor.removeProfessor();
                        break;
                    case 4: 
                        Professor.mostrarListaProfessor();
                        break;
                    case 0: 
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opcao Invalida!");
                        break;

                }
            }catch (InputMismatchException e) {
                System.out.println("Por favor, digite uma das opcoes do menu!");
            }        
        }while (opcaoP != 0);
    }

    public void alimentaSecretaria (){
        Secretaria secretaria1 = new Secretaria();
        secretaria1.setEmail("sc@gmail.com");
        secretaria1.setSenha("sc@!1973");
        secretaria.add(secretaria1);

    }

    public static List<Secretaria> getSecretaria(){
        return secretaria;
    }
}

