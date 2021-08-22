import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivo {

	public BufferedReader abrirArquivo(String arquivo) throws FileNotFoundException {
		//teste 
		File file = new File(arquivo);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		return br;
		
		// novo comentário
	}
	
	public List<String> lerArquivo(String arquivo) throws FileNotFoundException,IOException {
		BufferedReader br = abrirArquivo(arquivo);
		List<String> lista = new ArrayList<>();
		//lendo arquivo
		while (br.ready()) {
			lista.add(br.readLine());
		}
		return lista;
	}
	
	public static void main(String args[]) throws IOException,FileNotFoundException {
		LeituraArquivo la = new LeituraArquivo();
		String dir = System.getProperty("user.dir") + "/arquivos/";
		List<String> lista = la.lerArquivo(dir+"Cliente_20140220.txt");
		System.out.println(lista);
		
	}

}
