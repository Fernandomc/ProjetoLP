/**
 * Universidade Federal da Para&iacute;ba
 * Depto. Ci&ecirc;ncias Exatas - Campus IV - CCAE
 * @author Rodrigo Rebou&ccedil;as de Almeida (http://rodrigor.com)
 * 03/08/2014
 */

package br.ufpb.dcx.lp.scd.model;

public class SCDRuntimeException extends RuntimeException {
	
	public SCDRuntimeException(String msg){
		super(msg);
	}
	
	public SCDRuntimeException(Throwable e){
		super(e);
	}
	
	public SCDRuntimeException(String msg, Throwable e){
		super(msg,e);
	}

}
