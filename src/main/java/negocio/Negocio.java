package negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import negocio.inter.IntermedioXML;
import negocio.model.Libro;

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

	@Override
	public List<Libro> getCatalogoNegocio() {
		return catalogo;
	}

	@Override
	public boolean add(Libro libro) {
		return catalogo.add(libro);
	}

	@Override
	public boolean delete(Libro libro) {
		return catalogo.remove(libro);
	}

	@Override
	public boolean update(Libro libro) {
		boolean devolver = false;
		for (Libro l : catalogo) {
			if (l.getIsbn().equals(libro.getIsbn())) {
				int pos = catalogo.indexOf(l);
				catalogo.set(pos, libro);
				devolver = true;
				break;
			}
		}
		return devolver;
	}

	@Override
	public boolean save(String fichero)  {
			try {
				IntermedioXML.salvar(fichero);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
	}

	@Override
	public boolean load(String fichero){
		try {
			IntermedioXML.cargar(fichero);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	
}
