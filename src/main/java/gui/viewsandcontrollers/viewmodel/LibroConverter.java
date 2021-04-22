package gui.viewsandcontrollers.viewmodel;

import negocio.model.Genero;
import negocio.model.Libro;

public class LibroConverter {

	public static Libro toLibro(LibroViewModel viewModelLibro) {
		return new Libro(viewModelLibro.getTitulo().getValue(), viewModelLibro.getIsbn().getValue(),
				Genero.getGenero(viewModelLibro.getGenero().getValue()), viewModelLibro.getAutor().getValue(),
				viewModelLibro.getPaginas().getValue());
	}

	public static LibroViewModel toLibroViewModel(Libro libro) {
		return new LibroViewModel(libro.getTitulo(),libro.getIsbn(),libro.getGenero().toString(),libro.getAutor(),libro.getPaginas());
	}
}
