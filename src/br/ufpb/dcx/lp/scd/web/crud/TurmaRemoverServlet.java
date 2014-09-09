package br.ufpb.dcx.lp.scd.web.crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpb.dcx.lp.scd.model.Turma;
import br.ufpb.dcx.lp.scd.web.CommonServlet;


@WebServlet("/turma.remover")
public class TurmaRemoverServlet extends CommonServlet {

	private static final long serialVersionUID = -8464361959786560888L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numero = request.getParameter("numero");
		
		String msg = "";
		if(!scd.existeNumero(numero))
			msg = "Não existe uma disciplina com este codigo: "+numero;
		else{
			Turma t = scd.getTurma(numero);
			scd.removerTurma(t);
			msg = "Turmaa removida com sucesso!";
		}
		redirecionar("/turma.listar?msg="+msg,response);
			
	}

}
