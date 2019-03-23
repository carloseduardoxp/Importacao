import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.domain.ContaImportacao;

public class ProcessadoraConta {
	
	public List<ContaImportacao> processaConta(String arquivo) throws IOException,ParseException,FileNotFoundException{
		LeituraArquivo leitura = new LeituraArquivo();
		List<ContaImportacao> listaConta = new ArrayList<>();		
		List<String> listaString = leitura.lerArquivo(arquivo);
		//TODO implementar
		String cabecalho = listaString.get(0);
		listaString.remove(0);
		for (String linha: listaString) {
			listaConta.add(getLinhaConta(linha));
		}
		return listaConta;
	}

	private ContaImportacao getLinhaConta(String linha) throws ParseException {
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
		ProcessadoraConta processadora = new ProcessadoraConta();
		List<ContaImportacao> contas = 
				processadora.processaConta(dir+"Conta_20140220.txt");
		System.out.println(contas);		
	}

}
