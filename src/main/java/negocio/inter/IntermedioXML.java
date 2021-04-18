package negocio.inter;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import negocio.imple.ImpleXML;

public class IntermedioXML {

	public static void salvar(String fichero) throws IOException, TransformerException, ParserConfigurationException {
		ImpleXML.salvar(fichero);
	}

	public static void cargar(String fichero) throws ParserConfigurationException, SAXException, IOException {
		ImpleXML.cargar(fichero);
		
	}
}
