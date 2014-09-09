package br.ufpb.dcx.lp.scd.persistencia;

import java.io.File;

public class GerenteDAO {
	
	private File dataDir;
	private DisciplinaDAO disciplinaDAO;
	

	public GerenteDAO(File dataDir) throws ErroPersistencia{
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		this.dataDir = dataDir;
		disciplinaDAO = new DisciplinaDAO(new File(dataDir.getPath()+"/disciplina.txt"));
		
		//profDAO = new ProfessorDAO(new File(dataDir.getPath()+"/professor.txt"));
	}

	
	
	public DisciplinaDAO getDisciplinaDAO(){
		return disciplinaDAO;
	}



//	public ProfessorDAO getProfessorDAO(){
//		return profDAO;
//	}
	
	
	
	

}
