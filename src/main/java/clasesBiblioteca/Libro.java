package clasesBiblioteca;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Libro{

	private SimpleStringProperty titulo;
	private SimpleStringProperty isbn;
	private SimpleObjectProperty<Genero> genero;
	private SimpleStringProperty autor;
	private SimpleIntegerProperty paginas;

	public Libro() {

	}

	public Libro(String titulo, String isbn, Genero genero, String autor, Integer paginas) {
		this.titulo = new SimpleStringProperty(titulo);
		this.autor = new SimpleStringProperty(autor);
		this.isbn = new SimpleStringProperty(isbn);
		this.genero = new SimpleObjectProperty<Genero>(genero);
		this.paginas = new SimpleIntegerProperty(paginas);
	}


	public SimpleStringProperty getTitulo() {
		return titulo;
	}

	public void setTitulo(SimpleStringProperty titulo) {
		this.titulo = titulo;
	}

	public SimpleStringProperty getIsbn() {
		return isbn;
	}

	public void setIsbn(SimpleStringProperty isbn) {
		this.isbn = isbn;
	}

	public SimpleObjectProperty<Genero> getGenero() {
		return genero;
	}

	public void setGenero(SimpleObjectProperty<Genero> genero) {
		this.genero = genero;
	}

	public SimpleStringProperty getAutor() {
		return autor;
	}

	public void setAutor(SimpleStringProperty autor) {
		this.autor = autor;
	}

	public SimpleIntegerProperty getPaginas() {
		return paginas;
	}

	public void setPaginas(SimpleIntegerProperty paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "[titulo=" + titulo + ", isbn=" + isbn + ", genero=" + genero + ", autor=" + autor + ", paginas="
				+ paginas + "]";
	}

	

	

}