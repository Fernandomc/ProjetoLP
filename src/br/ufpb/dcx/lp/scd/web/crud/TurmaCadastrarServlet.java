package br.ufpb.dcx.lp.scd.web.crud;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpb.dcx.lp.scd.model.*;

import br.ufpb.dcx.lp.scd.web.CommonServlet;

@WebServlet("/turma.cad")
public class TurmaCadastrarServlet extends CommonServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		encaminhar("/interno/turma.cadastrar.jsp",request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numero = request.getParameter("camponumero");
		String dia = request.getParameter("campodia");
		String codigoDisciplina = request.getParameter("campoCodigoDaDisciplina");
		int horaInicio = Integer.parseInt(request.getParameter("campoHoraInicio"));
		int minInicio = Integer.parseInt(request.getParameter("campoMinInicio"));
		int horaFim = Integer.parseInt(request.getParameter("campoHoraFim"));
		int minFim = Integer.parseInt(request.getParameter("campoMinFim"));
		
		
		
		
		HashMap<String,String> msgErro = new HashMap<String,String>();
		String destino =  "";
		if(numero == null || numero.length() == 0)
			msgErro.put("camponumero","Número da turma inválido");
		
		if(codigoDisciplina  == null || codigoDisciplina.length() == 0)
			msgErro.put("campoCodigoDaDisciplina","Disciplina inválido");
	
		if(horaInicio < 0 || horaInicio > 23)
			msgErro.put("campoHoraInicio", "Horário incial inválido");

		if(minInicio < 0 || minInicio > 59)
			msgErro.put("campoMinInicio", "Minuto inicial inválido");
		
		if(horaFim < 0 || horaFim > 23 || horaFim < horaInicio)
			msgErro.put("campoHoraFim", "Hora final inválido");
		
		if(minFim < 0 || minFim > 59 || minFim > minInicio)
			msgErro.put("campoMinFim", "Minuto final inválido");

			
		if(!msgErro.isEmpty()){
			request.setAttribute("msgErro", msgErro);
			destino = "/interno/turma.cadastrar.jsp";
			encaminhar(destino,request,response);
		}else{
			Disciplina disciplina = scd.getDisciplina(codigoDisciplina);
			HorarioAula horario = new HorarioAula(dia,horaInicio,minInicio,horaFim,minFim);
			Turma novaTurma = new Turma(disciplina,numero);
			novaTurma.addHorario(horario);
			disciplina.addTurma(novaTurma);
			redirecionar(destino,response);
		}
	}

}
