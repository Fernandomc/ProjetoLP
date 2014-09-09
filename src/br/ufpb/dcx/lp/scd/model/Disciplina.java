package br.ufpb.dcx.lp.scd.model;

import java.util.ArrayList;

public class Disciplina{
	
	private String nome;
	private String ementa;
	private String ch;
	private String codigo;
	private ArrayList<Turma> turmas;
	
	public Disciplina(String nome, String ementa, String ch, String codigo) {
		this.nome = nome;
		this.ementa = ementa;
		this.ch = ch;
		this.codigo = codigo;
		this.turmas = new ArrayList<Turma>();
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	

	public String toString(){
		StringBuffer str = new StringBuffer();
		str.append("Nome:"+this.nome+"\n");
		str.append("Codigo: "+this.codigo+"\n");
		str.append("Carga Horária: "+this.ch+"\n");
		str.append("Ementa: "+this.ementa+"\n");
		return str.toString();
	}
	
	public boolean equals(Object d){
		if(!(d instanceof Disciplina))
			return false;
		Disciplina disciplina2 = (Disciplina)d;
		return this.nome.equals(disciplina2.nome) && 
			   this.codigo.equals(disciplina2.codigo);
	}
	public void addTurma(Turma turma){
		turmas.add(turma);
	}

}
