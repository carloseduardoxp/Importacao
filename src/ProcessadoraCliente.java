import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.domain.ClienteImportacao;

public class ProcessadoraCliente implements ProcessadorLinha<ClienteImportacao> {
	
	@Override
	public ClienteImportacao getLinha(String linha) throws ParseException {
		ClienteImportacao cliente = new ClienteImportacao();
		cliente.setTipo(linha.charAt(1));
		cliente.setCpf(linha.substring(2,13));
		cliente.setNome(linha.substring(13,43).trim());
		cliente.setEndereco(linha.substring(43,73).trim());
		cliente.setBairro(linha.substring(73,103).trim());
		cliente.setCidade(linha.substring(103,133).trim());
		cliente.setEstado(linha.substring(133,135));
		String dataCadastro = linha.substring(135,143);
		String horaCadastro = linha.substring(143,149);
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy hhmmss");
		cliente.setDataHoraCadastro(sdf.parse(dataCadastro+" "+horaCadastro));
		return cliente;
	}
	
	public static void main(String args[]) throws Exception {
		String dir = System.getProperty("user.dir") + "/arquivos/";
		ProcessadoraArquivo<ClienteImportacao> processadora = 
				new ProcessadoraArquivo<>(new ProcessadoraCliente());
		List<ClienteImportacao> clientes = 
				processadora.processaArquivo(dir+"Cliente_20140220.txt");
		System.out.println(clientes);		
	}

	
	

}
