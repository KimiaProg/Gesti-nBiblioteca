package negocio;

import java.util.List;

import negocio.model.Libro;

public interface NegocioInterface {

	/**
	 * Devulve el catalogo
	 * @return
	 */
	public List<Libro> getCatalogoNegocio();

	/**
	 * Añade un libro en el catalogo
	 * @param libro
	 * @return
	 */
	public boolean add(Libro libro);

	/**
	 * Borra un libro del catalogo
	 * @param libro
	 * @return
	 */
	public boolean delete(Libro libro);

	/**
	 * Actualiza un libro en el catalogo
	 * @param libro
	 * @return
	 */
	public boolean update(Libro libro);
	
	/**
	 * 
	 * @param fichero
	 * @return
	 */
	public boolean save(String fichero);
	
	/**
	 * 
	 * @param fichero
	 * @return
	 */
	public boolean load(String fichero);
}
