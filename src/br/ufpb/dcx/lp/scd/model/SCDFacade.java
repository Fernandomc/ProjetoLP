package br.ufpb.dcx.lp.scd.model;

import java.util.Collection;

import br.ufpb.dcx.lp.scd.persistencia.ErroPersistencia;
import br.ufpb.dcx.lp.scd.persistencia.GerenteDAO;
import br.ufpb.dcx.lp.scd.persistencia.DisciplinaDAO;
import br.ufpb.dcx.lp.scd.persistencia.TurmaDAO;


public class SCDFacade {

	private DisciplinaDAO disciplinaDAO;
	private TurmaDAO turmaDAO;


	public SCDFacade(GerenteDAO persistencia) throws ErroPersistencia {
		disciplinaDAO = persistencia.getDisciplinaDAO();
		}

	public Disciplina getDisciplina(String codigo) {
		return disciplinaDAO.getDisciplina(codigo);
	}

	public void addDisciplina(Disciplina disciplina) {
		if (disciplinaDAO.existeDisciplina(disciplina.getCodigo()))
			throw new SCDRuntimeException(
					"Já existe uma disciplina com este codigo:" + disciplina.getCodigo());

		try {
			disciplinaDAO.gravarDisciplina(disciplina);
		} catch (ErroPersistencia e) {
			throw new SCDRuntimeException(e);
		}
	}

	public boolean existeCodigo(String codigo) {
		return disciplinaDAO.existeDisciplina(codigo);
	}
	public boolean existeNumero(String numero) {
		return turmaDAO.existeTurma(numero);
	}

	public Collection<Disciplina> getDisciplinas() {
		return disciplinaDAO.getDisciplinas();
	}

	public void removerDisciplina(Disciplina disciplina) {
		try {
			disciplinaDAO.removerDisciplina(disciplina.getCodigo());
		} catch (ErroPersistencia e) {
			throw new SCDRuntimeException(e);
		}
	}

	public void removerTurma(Turma turma) {
		try {
			turmaDAO.removerTurma(turma.getNumero());
		} catch (ErroPersistencia e) {
			throw new SCDRuntimeException(e);
		}
	}

	public Turma getTurma(String numero) {
		return turmaDAO.getTurma(numero);
	}
	public Collection<Turma> getTurmas() {
		return TurmaDAO.getTurmas();
	}
}