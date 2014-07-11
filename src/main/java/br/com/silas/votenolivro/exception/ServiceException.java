package br.com.silas.votenolivro.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -3511002127012569518L;

	private String mensagem;
	private String[] argumentos;
	
	public ServiceException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public ServiceException(String mensagem, String[] argumentos) {
		this.mensagem = mensagem;
		this.argumentos = argumentos;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String[] getArgumentos() {
		return argumentos;
	}
}