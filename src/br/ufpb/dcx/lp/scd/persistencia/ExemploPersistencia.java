package br.ufpb.dcx.lp.scd.persistencia;

import java.io.File;
import java.util.Scanner;

import br.ufpb.dcx.lp.scd.model.Disciplina;

public class ExemploPersistencia {

	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Informe o diretório dos arquivos");
			System.exit(0);
		}
		File base = new File(args[0]);
		if(!base.exists()){
			System.out.println("O diretório "+args[0]+" não existe!");
			System.exit(0);
		}
		
		base.mkdir();

		
		Scanner in = new Scanner(System.in);
		
		
		DisciplinaDAO disciplinaDAO = null;
		try {
			GerenteDAO gerente = new GerenteDAO(base);

			disciplinaDAO = gerente.getDisciplinaDAO();

			System.out.println("CadastrarUsuario?");
			String opcao = in.nextLine();
			if (opcao.equals("sim")) {
				
				System.out.println("Nome:");
				String nome = in.nextLine();
				System.out.println("Ementa:");
				String ementa = in.nextLine();
				System.out.println("Carga Horária:");
				String ch = in.nextLine();
				System.out.println("Código:");
				String codigo = in.nextLine();
				Disciplina disciplina = new Disciplina(nome,ementa,ch,codigo);
				disciplinaDAO.gravarDisciplina(disciplina);
			}

			listarDisciplinas(disciplinaDAO);

			System.out.println("Deseja excluir algum usuario?");
			opcao = in.nextLine();
			if (opcao.equals("sim")) {
				System.out.println("Digite o login:");
				disciplinaDAO.removerDisciplina(in.nextLine());
				System.out.println("Listagem atualizada:");
				listarDisciplinas(disciplinaDAO);

			}
		} catch (ErroPersistencia e) {
			e.printStackTrace();
		}
	}

	private static void listarDisciplinas(DisciplinaDAO uper) {
		System.out.println("********************");
		System.out.println("Usuarios cadastrados:");
		for (Disciplina d : uper.getDisciplinas()) {
			System.out.println(d);
		}

	}

}
