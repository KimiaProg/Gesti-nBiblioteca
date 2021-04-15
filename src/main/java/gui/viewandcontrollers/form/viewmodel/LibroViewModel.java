package gui.viewandcontrollers.form.viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Pair;
import negocio.Negocio;
import negocio.model.Genero;

public class LibroViewModel {

	private Negocio negocio = Negocio.getInstance();

	private final StringProperty titulo= new SimpleStringProperty();
	private final StringProperty isbn= new SimpleStringProperty();
	private final ObjectProperty<Pair<String, String>> genero = new SimpleObjectProperty();
	private final StringProperty autor= new SimpleStringProperty();
	private final IntegerProperty paginas = new SimpleIntegerProperty();

	public LibroViewModel() {
		setGenero(new Pair(Genero.FICCION.toString(), Genero.FICCION.toString()));
	}

	public LibroViewModel(String titulo, String isbn, String genero,
			String autor, Integer paginas) {
		setTitulo(titulo);
		setIsbn(isbn);
		setGenero(new Pair<String, String>(genero,genero));
		setAutor(autor);
		setPaginas(paginas);
	}

	public StringProperty getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo.set(titulo);
	}

	public StringProperty getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn.set(isbn);
	}

	public ObjectProperty<Pair<String, String>> getGenero() {
		return (ObjectProperty<Pair<String, String>>) genero;
	}

	public void setGenero(Pair<String, String> genero) {
		this.genero.set(genero);
	}

	public StringProperty getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor.set(autor);
	}

	public IntegerProperty getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas.set(paginas);
	}

	@Override
	public String toString() {
		return "[titulo=" + titulo + ", isbn=" + isbn + ", genero=" + genero + ", autor=" + autor + ", paginas="
				+ paginas + "]";
	}

	public boolean create() {
		return negocio.add(LibroConverter.toLibro(this));
	}

	public boolean update() {
		return negocio.update(LibroConverter.toLibro(this));
	}

}
