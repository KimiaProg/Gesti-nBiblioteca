package gui.viewandcontrollers.form.viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import negocio.Negocio;
import negocio.model.Genero;

public class LibroViewModel {

		private Negocio negocio= Negocio.getInstance();


		private StringProperty titulo;
		private StringProperty isbn;
		private ObjectProperty<Genero> genero;
		private StringProperty autor;
		private IntegerProperty paginas;

		public LibroViewModel() {

		}

		


		public LibroViewModel(StringProperty titulo, StringProperty isbn, ObjectProperty<Genero> genero,
				StringProperty autor, IntegerProperty paginas) {
			super();
			this.titulo = titulo;
			this.isbn = isbn;
			this.genero = genero;
			this.autor = autor;
			this.paginas = paginas;
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




		public ObjectProperty<Genero> getGenero() {
			return genero;
		}




		public void setGenero(Genero genero) {
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
			negocio.add(LibroConverter.toLibro(this));
			return false;
			
		}
		
		public boolean update() {
			return false;
			
		}

	}

