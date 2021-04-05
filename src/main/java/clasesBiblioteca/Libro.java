package clasesBiblioteca;


import java.util.Comparator;

public class Libro implements Comparable<Libro>, Comparator<Libro> {

	private String titulo;
	private String isbn;
	private Genero genero;
	private String autor;
	private Integer paginas;

	public Libro() {

	}

	public Libro(String titulo, String isbn, Genero genero, String autor, Integer paginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.genero = genero;
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "[titulo=" + titulo + ", isbn=" + isbn + ", genero=" + genero + ", autor=" + autor + ", paginas="
				+ paginas + "]";
	}

	public String toStringFile() {
		return titulo + "," + isbn + "," + genero + "," + autor + "," + paginas;
	}

	@Override
	public boolean equals(Object libro) {
		Libro libro1 = (Libro) libro;
		return this.isbn.equalsIgnoreCase(libro1.isbn);

	}

	@Override
	public int compareTo(Libro libro) {
		int devolver = 0;

		if (titulo.compareToIgnoreCase(libro.titulo) == 0) {
			devolver= compare(this,libro);
		} else {
			devolver = titulo.compareToIgnoreCase(libro.titulo);
		}
		return devolver;
	}

	@Override
	public int compare(Libro libro1, Libro libro2) {
		return libro1.getPaginas() - libro2.getPaginas();
	}

}