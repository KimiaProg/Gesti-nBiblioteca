package negocio.xml;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import negocio.Negocio;
import negocio.model.Genero;
import negocio.model.Libro;

public class XMLHandler extends DefaultHandler {
	private Libro lib;
	StringBuilder myStringB = new StringBuilder();

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		myStringB.append(new String(ch, start, length));
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "titulo":
			lib.setTitulo(myStringB.toString());
			break;
		case "isbn":
			lib.setIsbn(myStringB.toString());
			break;
		case "autor":
			lib.setAutor(myStringB.toString());
			break;
		case "genero":
			lib.setGenero(Genero.getGenero(myStringB.toString()));
			break;
		case "paginas":
			lib.setPaginas(Integer.parseInt(myStringB.toString()));
			break;
		case "libro":
			Negocio.getInstance().add(lib);
			break;
		}

		super.endElement(uri, localName, qName);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) {
		case "libro":
			lib = new Libro();
			break;
		default:
			myStringB.delete(0, myStringB.length());
		}
		super.startElement(uri, localName, qName, attributes);
	}
}
