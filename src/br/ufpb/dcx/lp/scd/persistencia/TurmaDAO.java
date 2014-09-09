package br.ufpb.dcx.lp.scd.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import br.ufpb.dcx.lp.scd.model.Disciplina;
import br.ufpb.dcx.lp.scd.model.HorarioAula;
import br.ufpb.dcx.lp.scd.model.Turma;
import br.ufpb.dcx.lp.scd.model.SCDFacade;

public class TurmaDAO extends DAOAbstrato {

	private static List<Turma> listaTurmas;
	private static Map<Disciplina,Turma> mapTurmas;
	
	private boolean sobrescrever = false;

	public TurmaDAO(File file)
			throws ErroPersistencia {
		super(file);
		carregarTurmas();
	}

	public void gravarTurma(Turma turma) throws ErroPersistencia {

		BufferedWriter out = getWriter(!sobrescrever);
		try {
			out.append(getLinhaParaTurma(turma));
		} catch (IOException e) {
			throw new ErroPersistencia(e);
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				throw new ErroPersistencia("Não foi possível fechar o arquivo",
						e);
			}
		}

		this.listaTurmas.add(turma);
		this.mapTurmas.put(turma.getNumero(), turma);
	}

	private String getLinhaParaTurma(Turma turma) {
		StringBuffer linha = new StringBuffer();
		linha.append(turma.getDisciplina() + ";");
		linha.append(turma.getNumero() + "/n");
		
		return linha.toString();
	}

	private void carregarTurmas() throws ErroPersistencia {
		listaTurmas = new ArrayList<Turma>();
		mapTurmas = new HashMap<String, Turma>();

		BufferedReader reader = getReader();

		String linha = "";
		try {
			while ((linha = reader.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(linha, ";");
				String numero = tokens.nextToken();
				String dia = tokens.nextToken();
				String horaInicio = tokens.nextToken();
				String minInicio = tokens.nextToken();
				String horaFim = tokens.nextToken();
				String minFim = tokens.nextToken();
				Disciplina disciplina = scd.getDisciplina(codigo);
				Turma novaTurma = new Turma(disciplina,numero);
				
				
				listaTurmas.add(novaTurma);
				mapTurmas.put(disciplina, novaTurma);
			}
		} catch (IOException e) {
			throw new ErroPersistencia(e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				throw new ErroPersistencia("Erro ao fechar o arquivo", e);
			}
		}

	}

	private void gravarTurma() throws ErroPersistencia {
		if (listaTurmas.isEmpty())
			return;

		BufferedWriter out = getWriter(sobrescrever);

		try {
			for (Turma turma: listaTurmas) {
				out.append(getLinhaParaTurma(turma));
			}
		} catch (IOException e) {
			throw new ErroPersistencia(e);
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				throw new ErroPersistencia("Não foi possível fechar o arquivo",
						e);
			}
		}

	}

	private String getLinhaParaDisciplina(Turma turma) {
		StringBuffer linha = new StringBuffer();
		linha.append(turma.getDisciplina() + ";");
		linha.append(turma.getNumero() + "/n");
		return linha.toString();
	}

	public Turma getTurma(String numero) {
		return this.mapTurmas.get(numero);
	}

	public void removerTurma(String numero) throws ErroPersistencia {
		if (!mapTurmas.containsKey(numero))
			throw new ErroPersistencia("numero inexistente:" + numero);
		
		Turma removida = mapTurmas.remove(numero);
		this.listaTurmas.remove(removida);
		
		this.gravarTurma();
	}

	public static List<Turma> getTurmas(){
		return listaTurmas;
	}

	public boolean existeTurma(String numero) {
		return this.mapTurmas.containsKey(numero);
	}
	
}

