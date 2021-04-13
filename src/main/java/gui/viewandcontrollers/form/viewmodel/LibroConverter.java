package gui.viewandcontrollers.form.viewmodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import negocio.model.Genero;
import negocio.model.Libro;

public class LibroConverter {

	public static Libro toLibro(LibroViewModel viewModelLibro) {
		return new Libro(viewModelLibro.getTitulo().toString(), viewModelLibro.getIsbn().toString(),
				Genero.getGenero(viewModelLibro.getGenero().toString()), viewModelLibro.getAutor().toString(),
				viewModelLibro.getPaginas().getValue());
	}

	public static LibroViewModel toLibroViewModel(Libro libro) {
		return new LibroViewModel(new SimpleStringProperty(libro.getTitulo()),
				new SimpleStringProperty(libro.getIsbn()), new SimpleObjectProperty<Genero>(libro.getGenero()),
				new SimpleStringProperty(libro.getAutor()), new SimpleIntegerProperty(libro.getPaginas()));
	}
}
