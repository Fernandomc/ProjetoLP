package br.ufpb.dcx.lp.scd.model;
import java.util.*;

public class Turma {
	
	ArrayList<HorarioAula> horarios;
	private Disciplina disciplina;
	private String numero;
	
	public Turma(Disciplina disciplina,String numero) {
		this.disciplina = disciplina;
		this.numero = numero;
		this.horarios = new ArrayList<HorarioAula>();
	}

	public ArrayList<HorarioAula> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<HorarioAula> horarios) {
		this.horarios = horarios;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void addHorario(HorarioAula horario){
		horarios.add(horario);
	}

}
