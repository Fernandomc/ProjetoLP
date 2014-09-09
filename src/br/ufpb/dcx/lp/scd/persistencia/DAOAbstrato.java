package br.ufpb.dcx.lp.scd.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DAOAbstrato {
	
	protected File arquivo;

	public DAOAbstrato(File file) throws ErroPersistencia{
		this.arquivo = file;
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new ErroPersistencia(e);
			}
	}
	
	protected BufferedWriter getWriter(boolean append) throws ErroPersistencia{
		try {
			return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo,append),"UTF-8"));
		} catch (IOException e) {
			throw new ErroPersistencia(e);
		}
	}
	
	public BufferedReader getReader() throws ErroPersistencia{
		try{
			return new BufferedReader(new InputStreamReader(new FileInputStream(arquivo),"UTF-8"));
		}catch(IOException e){
			throw new ErroPersistencia(e);
		}
	}
	

}
