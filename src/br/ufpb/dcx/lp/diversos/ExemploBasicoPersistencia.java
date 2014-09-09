package br.ufpb.dcx.lp.diversos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ExemploBasicoPersistencia {

	public static void main(String[] args) {

		try {
			// exemplo1();
			// exemplo2();
		 lerPF();
			for (PessoaFisica pf : listarPFs()) {
				System.out.println(pf.getNome());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void exemplo1() throws IOException {
		File arq = new File("/Users/rodrigor/Desktop/teste.txt");
		FileWriter out = new FileWriter(arq);

		out.write("Alou!áéíç");
		out.close();

	}

	public static void exemplo2() throws IOException {
		File arq = new File("/Users/rodrigor/Desktop/teste2.txt");
		FileOutputStream out = new FileOutputStream(arq);

		out.write("alou!áéíç".getBytes());
		out.close();

	}

	public static void lerPF() throws IOException {
		Scanner in = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.println("###### " + (i + 1));
			System.out.println("Digite seu nome:");
			String nome = in.nextLine();
			System.out.println("Digite seu cpf:");
			String cpf = in.nextLine();
			gravarPF(new PessoaFisica(nome, cpf));

		}

	}

	public static void gravarPF(PessoaFisica pf) throws IOException {
		File arq = new File("/Users/rodrigor/Desktop/PessoasFisicas.txt");
		FileWriter out = new FileWriter(arq, true);

		StringBuffer linhaPF = new StringBuffer();
		linhaPF.append(pf.getNome() + ";");
		linhaPF.append(pf.getCpf() + "\n");
		out.write(linhaPF.toString());
		out.close();
	}

	public static List<PessoaFisica> listarPFs() throws IOException {
		File arq = new File("/Users/rodrigor/Desktop/PessoasFisicas.txt");
		List<PessoaFisica> pfs = new ArrayList<PessoaFisica>();
		BufferedReader reader = new BufferedReader(new FileReader(arq));
		String line = "";

		while ((line = reader.readLine()) != null) {

			try {
				StringTokenizer tokens = new StringTokenizer(line, ";");
				String nome = tokens.nextToken();
				String cpf = tokens.nextToken();
				if(tokens.hasMoreElements()){
					throw new Exception("Arquivo Corrompido!");
				}
				PessoaFisica pf = new PessoaFisica(nome, cpf);
				pfs.add(pf);
			} catch (Exception e) {
				reader.close();
				throw new IOException("O arquivo está corrompido!", e);
			} 

		}

		reader.close();
		return pfs;
	}

}
