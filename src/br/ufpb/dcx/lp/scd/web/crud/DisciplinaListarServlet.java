package br.ufpb.dcx.lp.scd.web.crud;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpb.dcx.lp.scd.model.SCDFacade;
import br.ufpb.dcx.lp.scd.model.Disciplina;
import br.ufpb.dcx.lp.scd.web.CommonServlet;


@WebServlet("/disciplina.listar")
public class DisciplinaListarServlet extends CommonServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<Disciplina> disciplinas = scd.getDisciplinas();
		request.setAttribute("disciplinas",disciplinas);
		encaminhar("/interno/disciplina.listar.jsp",request,response);
	}

}
