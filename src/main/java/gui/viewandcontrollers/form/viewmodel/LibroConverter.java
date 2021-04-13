package gui.viewandcontrollers.form.viewmodel;

import negocio.model.Genero;
import negocio.model.Libro;

public class LibroConverter {

	public static Libro toLibro(LibroViewModel viewModelLibro) {
		return new Libro(viewModelLibro.getTitulo().toString(), viewModelLibro.getIsbn().toString(),
				Genero.getGenero(viewModelLibro.getGenero().toString()), viewModelLibro.getAutor().toString(),
				viewModelLibro.getPaginas().getValue());
	}

	public static LibroViewModel toLibroViewModel(Libro libro) {
		return new LibroViewModel(libro.getTitulo(),libro.getIsbn(),libro.getGenero().toString(),libro.getAutor(),libro.getPaginas());
	}
}
