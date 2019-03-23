package model.domain;

public class ContaImportacao extends Arquivo {
	
	private char tipo;
	
	private String cpf;
	
	private Double valorLimite;
	
	private Integer diaVencimentoFatura;
	
	private String numeroConta;

	public ContaImportacao() {
		super();
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getValorLimite() {
		return valorLimite;
	}

	public void setValorLimite(Double valorLimite) {
		this.valorLimite = valorLimite;
	}

	public Integer getDiaVencimentoFatura() {
		return diaVencimentoFatura;
	}

	public void setDiaVencimentoFatura(Integer diaVencimentoFatura) {
		this.diaVencimentoFatura = diaVencimentoFatura;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	@Override
	public String toString() {
		return "ContaImportacao [tipo=" + tipo + ", cpf=" + cpf + ", valorLimite=" + valorLimite
				+ ", diaVencimentoFatura=" + diaVencimentoFatura + ", numeroConta=" + numeroConta + "]";
	}
	
	
	
	

}
