package negocio;

import java.util.ArrayList;
import java.util.List;

import negocio.model.Libro;
import negocio.model.NegocioInterface;

public class Negocio implements NegocioInterface {

	private static List<Libro> catalogo = new ArrayList<>();
	private static Negocio instance = null;

	private Negocio() {

	}

	public static Negocio getInstance() {
		if (instance == null) {
			instance = new Negocio();
		}
		return instance;
	}

	public List<Libro> getCatalogoNegocio() {
		return catalogo;
	}

	public void setCatalogoNegocio(List<Libro> catalogo) {
		Negocio.catalogo = catalogo;
	}

	public void add(Libro libro) {
		catalogo.add(libro);
	}

	public void delete(Libro libro) {
		catalogo.remove(libro);
	}

	@Override
	public void update(Libro libro) {
		for(Libro l: catalogo) {
			if(l.getIsbn()== libro.getIsbn()) {
				int pos = catalogo.indexOf(l);
				catalogo.set(pos, libro);
			}
		}
		
	}

}
