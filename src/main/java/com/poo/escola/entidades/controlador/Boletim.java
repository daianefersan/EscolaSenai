package com.poo.escola.entidades.controlador;

import com.poo.escola.entidades.enums.Status;
import com.poo.escola.entidades.Aluno;
import com.poo.escola.entidades.Disciplina;
import com.poo.escola.entidades.Nota;


public interface Boletim {

    public void imprimeBoletim(Aluno aluno, Nota nota, Status status, Disciplina disciplina);

}
