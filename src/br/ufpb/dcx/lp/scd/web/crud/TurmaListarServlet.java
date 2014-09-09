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
import br.ufpb.dcx.lp.scd.model.Turma;
import br.ufpb.dcx.lp.scd.web.CommonServlet;


@WebServlet("/turma.listar")
public class TurmaListarServlet extends CommonServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<Turma> turmas = scd.getTurmas();
		request.setAttribute("turmas",turmas);
		encaminhar("/interno/turma.listar.jsp",request,response);
	}

}
