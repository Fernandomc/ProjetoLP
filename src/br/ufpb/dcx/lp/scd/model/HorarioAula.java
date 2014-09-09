package br.ufpb.dcx.lp.scd.model;

public class HorarioAula {
	
	private String dia;
	private int horaInicio;
	private int minInicio;
	private int horaFim;
	private int minFim;
	
	public HorarioAula(String dia, int horaInicio, int minInicio, int horaFim,int minFim) {
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.minInicio = minInicio;
		this.horaFim = horaFim;
		this.minFim = minFim;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getMinInicio() {
		return minInicio;
	}

	public void setMinInicio(int minInicio) {
		this.minInicio = minInicio;
	}

	public int getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}

	public int getMinFim() {
		return minFim;
	}

	public void setMinFim(int minFim) {
		this.minFim = minFim;
	}

}
