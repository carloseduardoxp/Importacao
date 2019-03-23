import java.text.ParseException;
import java.util.List;

import model.domain.ContaImportacao;

public class ProcessadoraConta implements ProcessadorLinha<ContaImportacao> {
	
	@Override
	public ContaImportacao getLinha(String linha) throws ParseException {
		ContaImportacao conta = new ContaImportacao();
		conta.setTipo(linha.charAt(1));
		conta.setCpf(linha.substring(2,13));						
		conta.setValorLimite(new Double(linha.substring(13,25)) / 100d);
		String dia = linha.substring(25,27);
		if (!dia.equals("__")) {
			conta.setDiaVencimentoFatura(new Integer(dia));	
		} else {
			conta.setDiaVencimentoFatura(null);
		}
		conta.setNumeroConta(linha.substring(27,33));
		return conta;
	}
	
	public static void main(String args[]) throws Exception {
		String dir = System.getProperty("user.dir") + "/arquivos/";
		ProcessadoraArquivo<ContaImportacao> processadora = 
				new ProcessadoraArquivo<>(new ProcessadoraConta());
		List<ContaImportacao> contas = 
				processadora.processaArquivo(dir+"Conta_20140220.txt");
		System.out.println(contas);	
	}

	

}
