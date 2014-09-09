package br.ufpb.dcx.lp.scd.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufpb.dcx.lp.scd.model.SCDFacade;


public abstract class CommonServlet extends HttpServlet {


	protected SCDFacade scd;
	protected ServletContext context;

	
	public void init(ServletConfig config) throws ServletException {
		this.context = config.getServletContext();
		this.scd = (SCDFacade)context.getAttribute("scd");
	}
	
	public void encaminhar(String pagina, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	public void redirecionar(String pagina, HttpServletResponse response) throws IOException{
		response.sendRedirect(context.getContextPath()+pagina);
	}
}
