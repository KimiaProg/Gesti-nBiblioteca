package negocio.model;

import java.util.List;

public interface negocioInterface {

	public List<Libro> getCatalogoNegocio();

	public void setCatalogoNegocio(List<Libro> catalogo);

	public void add(Libro libro);

	public void delete(Libro libro);

	public void update(Libro libro);
}
