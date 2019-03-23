import java.text.ParseException;

public interface ProcessadorLinha<E> {
	
	public E getLinha(String linha) throws ParseException;

}
