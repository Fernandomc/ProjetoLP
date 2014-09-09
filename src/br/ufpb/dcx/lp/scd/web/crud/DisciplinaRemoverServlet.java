package br.ufpb.dcx.lp.scd.web.crud;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpb.dcx.lp.scd.model.Disciplina;
import br.ufpb.dcx.lp.scd.web.CommonServlet;


@WebServlet("/disciplina.remover")
public class DisciplinaRemoverServlet extends CommonServlet {

	private static final long serialVersionUID = -8464361959786560888L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		
		String msg = "";
		if(!scd.existeCodigo(codigo))
			msg = "Não existe uma disciplina com este codigo: "+codigo;
		else{
			Disciplina d = scd.getDisciplina(codigo);
			scd.removerDisciplina(d);
			msg = "Disciplina removida com sucesso!";
		}
		redirecionar("/disciplina.listar?msg="+msg,response);
			
	}

}
