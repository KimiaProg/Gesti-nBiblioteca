package negocio.imple;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import negocio.model.Libro;
import negocio.xml.ServiceXML;
import negocio.xml.XMLHandler;

public class ImpleXML {
	
	public static void salvar(String fichero) throws IOException, TransformerException, ParserConfigurationException {
		ServiceXML.save(fichero);
	}

	public static void cargar(String fichero) throws ParserConfigurationException, SAXException, IOException {
		ServiceXML.load(fichero);
		
	}
	
}







