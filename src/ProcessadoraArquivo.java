import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ProcessadoraArquivo<E> {
	
	private ProcessadorLinha<E> processa;

	public ProcessadoraArquivo(ProcessadorLinha<E> processa) {
		this.processa = processa;
	}

	public List<E> processaArquivo(String arquivo) 
			throws IOException,ParseException,FileNotFoundException{
		LeituraArquivo leitura = new LeituraArquivo();
		List<E> listaConta = new ArrayList<>();		
		List<String> listaString = leitura.lerArquivo(arquivo);
		//TODO implementar
		String cabecalho = listaString.get(0);
		listaString.remove(0);
		for (String linha: listaString) {
			listaConta.add(processa.getLinha(linha));
		}
		return listaConta; 		
	}

}