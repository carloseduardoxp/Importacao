import java.text.ParseException;

import model.domain.Lote;

public interface ProcessadorLinha<E extends Lote> {
	
	public E getLinha(String linha) throws ParseException;

}
