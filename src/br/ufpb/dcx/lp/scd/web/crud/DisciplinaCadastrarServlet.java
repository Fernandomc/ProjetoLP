package br.ufpb.dcx.lp.scd.web.crud;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpb.dcx.lp.scd.model.SCDFacade;
import br.ufpb.dcx.lp.scd.model.Disciplina;
import br.ufpb.dcx.lp.scd.web.CommonServlet;

@WebServlet("/disciplina.cad")
public class DisciplinaCadastrarServlet extends CommonServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		encaminhar("/interno/disciplina.cadastrar.jsp",request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("camponome");
		String ementa = request.getParameter("campoementa");
		String ch = request.getParameter("campoch");
		String codigo = request.getParameter("campocodigo");
				

		HashMap<String,String> msgErro = new HashMap<String,String>();
		String destino =  "";
		
		if(nome == null || nome.length() == 0)
			msgErro.put("camponome","Nome inválido");
		
		if(ementa == null || ementa.length() == 0)
			msgErro.put("campoementa","Ementa inválida");
	
		if(ch == null || ch.length() < 0 || ch.length() > 2)
			msgErro.put("campoch", "Carga Horária inválida");

		if(codigo == null || codigo.length() < 0 || codigo.length() > 5)
			msgErro.put("campocodigo", "Código inválido");

		
		if(msgErro.isEmpty() && scd.existeCodigo(codigo))
			msgErro.put("geral","Já existe uma disciplina cadastrada com este codigo: ("+codigo+").");
			
		if(!msgErro.isEmpty()){
			request.setAttribute("msgErro", msgErro);
			destino = "/interno/disciplina.cadastrar.jsp";
			encaminhar(destino,request,response);
		}else{
			Disciplina novaDisciplina = new Disciplina(nome,ementa,ch,codigo);
			scd.addDisciplina(novaDisciplina);
			redirecionar(destino,response);
		}
	}

}
