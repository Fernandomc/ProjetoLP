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

public class DisciplinaDAO extends DAOAbstrato {

	private List<Disciplina> listaDisciplinas;
	private Map<String, Disciplina> mapDisciplinas;
	
	private boolean sobrescrever = false;

	public DisciplinaDAO(File file)
			throws ErroPersistencia {
		super(file);
		carregarDisciplinas();
	}

	public void gravarDisciplina(Disciplina disciplina) throws ErroPersistencia {

		BufferedWriter out = getWriter(!sobrescrever);
		try {
			out.append(getLinhaParaDisciplina(disciplina));
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

		this.listaDisciplinas.add(disciplina);
		this.mapDisciplinas.put(disciplina.getCodigo(), disciplina);
	}

	private void carregarDisciplinas() throws ErroPersistencia {
		listaDisciplinas = new ArrayList<Disciplina>();
		mapDisciplinas = new HashMap<String, Disciplina>();

		BufferedReader reader = getReader();

		String linha = "";
		try {
			while ((linha = reader.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(linha, ";");
				String nome = tokens.nextToken();
				String ementa = tokens.nextToken();
				String ch = tokens.nextToken();
				String codigo = tokens.nextToken();
				Disciplina nova = new Disciplina(nome,ementa,ch,codigo);
				
				listaDisciplinas.add(nova);
				mapDisciplinas.put(codigo, nova);
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

	private void gravarDisciplina() throws ErroPersistencia {
		if (listaDisciplinas.isEmpty())
			return;

		BufferedWriter out = getWriter(sobrescrever);

		try {
			for (Disciplina disciplina : listaDisciplinas) {
				out.append(getLinhaParaDisciplina(disciplina));
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

	private String getLinhaParaDisciplina(Disciplina disciplina) {
		StringBuffer linha = new StringBuffer();
		linha.append(disciplina.getNome() + ";");
		linha.append(disciplina.getEmenta() + ";");
		linha.append(disciplina.getCh() + ";");
		linha.append(disciplina.getCodigo() + "\n");
		
		return linha.toString();
	}

	public Disciplina getDisciplina(String codigo) {
		return this.mapDisciplinas.get(codigo);
	}

	public void removerDisciplina(String codigo) throws ErroPersistencia {
		if (!mapDisciplinas.containsKey(codigo))
			throw new ErroPersistencia("Codigo inexistente:" + codigo);
		
		Disciplina removida = mapDisciplinas.remove(codigo);
		this.listaDisciplinas.remove(removida);
		
		this.gravarDisciplina();
	}

	public List<Disciplina> getDisciplinas(){
		return listaDisciplinas;
	}

	public boolean existeDisciplina(String codigo) {
		return this.mapDisciplinas.containsKey(codigo);
	}
	
}

