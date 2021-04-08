package negocio;

import java.util.ArrayList;
import java.util.List;

import negocio.model.Libro;

public class Negocio {

	private static List<Libro> catalogo = new ArrayList<>();
	private static Negocio instance=null;
	
	private Negocio() {
		
	}
	
	public static Negocio getInstance() {
		if(instance==null) {
			instance=new Negocio();
		}
		return instance;
	}

	public static List<Libro> getCatalogoNegocio() {
		return catalogo;
	}

	public static void setCatalogoNegocio(List<Libro> catalogo) {
		Negocio.catalogo = catalogo;
	}
	
	public static void add(Libro libro) {
		catalogo.add(libro);
	}
	public static void delete(Libro libro) {
		catalogo.remove(libro);
	}

}
