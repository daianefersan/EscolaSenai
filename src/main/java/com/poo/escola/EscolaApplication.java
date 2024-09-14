package com.poo.escola;

import com.poo.escola.entidades.Aluno;
import com.poo.escola.entidades.Disciplina;
import com.poo.escola.entidades.Menu;
import com.poo.escola.entidades.Professor;
import com.poo.escola.entidades.Secretaria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscolaApplication {

	public static void main(String[] args)  {
		SpringApplication.run(EscolaApplication.class, args);

		Disciplina.alimentaDisciplina();
		Secretaria.alimentaSecretaria();
		Aluno.alimentaAluno();
		Professor.alimentaProfessor();
		Menu.menuFinal();

		//na hora de escolher o indice, lembre-se numero 1 pra indice 0 e assim por diante.
		//depois de umas 3 horas pra descobrir o erro do por que o arquivo nao era lido
		//descobrimos que era pq chama name na gravação e na leitura chamava email
		//porem ele nao queria ler tambem por que faltava chamar o this.notes que tava errado
		//3 horas de pensamento e ranger de dentes por pouca coisa, e tambem tinha que instanciar lista
		//de notas tanto em disciplina quanto em aluno.

	}

}