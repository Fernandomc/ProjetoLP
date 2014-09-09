package br.ufpb.dcx.lp.scd.web;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.ufpb.dcx.lp.scd.model.SCDFacade;
import br.ufpb.dcx.lp.scd.persistencia.ErroPersistencia;
import br.ufpb.dcx.lp.scd.persistencia.GerenteDAO;


@WebListener
public class SCDContextListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent event)  {
    	
		File dataDir = new File(event.getServletContext().getRealPath("/WEB-INF") + "/data");
		
		//Mando imprimir no log do tomcat o dataDir,
		//apenas para referência quando estivermos testando
		event.getServletContext().log("DataDIR: "+dataDir);
		
		
    	
    	SCDFacade scd = null;

		try {
			GerenteDAO gerenteDAO = new GerenteDAO(dataDir);
			scd = new SCDFacade(gerenteDAO);
		} catch (ErroPersistencia e) {
			event.getServletContext().log("Erro na inicialização!",e);
		}
    	event.getServletContext().setAttribute("scd",scd);
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // Nada, por enquanto
    }
	
}
