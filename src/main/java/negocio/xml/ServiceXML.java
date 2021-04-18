package negocio.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import negocio.Negocio;
import negocio.model.Libro;


public class ServiceXML{
	private static Document doc;
	
	public static void load(String fichero) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory mySaxParserF= SAXParserFactory.newInstance();
		SAXParser mySaxPars = mySaxParserF.newSAXParser(); 
		File file = new File(fichero);
		mySaxPars.parse(file, new XMLHandler());
		
	}
	
	public static void save(String fichero) throws IOException, TransformerException, ParserConfigurationException {
		
		generadorDoc();
		generadorXML(fichero);
		
	}
	
	
	
	
	private static void generadorDoc() throws ParserConfigurationException {
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder DB = fact.newDocumentBuilder();
		doc = DB.newDocument();
		
		Element libros = doc.createElement("libros"); 
		doc.appendChild(libros);
		for( Libro l : Negocio.getInstance().getCatalogoNegocio()) {
			Element libro = doc.createElement("libro"); 
			libros.appendChild(libro);
			
			Element titulo = doc.createElement("titulo");
			libro.appendChild(titulo);
			titulo.appendChild(doc.createTextNode(l.getTitulo()));
			
			Element isbn = doc.createElement("isbn"); 
			libro.appendChild(isbn);
			isbn.appendChild(doc.createTextNode(l.getIsbn()));
			
			Element autor = doc.createElement("autor"); 
			libro.appendChild(autor);
			autor.appendChild(doc.createTextNode(l.getAutor()));
			
			Element genero = doc.createElement("genero"); 
			libro.appendChild(genero);
			genero.appendChild(doc.createTextNode(l.getGenero().toString()));
			
			Element paginas = doc.createElement("paginas"); 
			libro.appendChild(paginas);
			paginas.appendChild(doc.createTextNode(l.getPaginas().toString()));
		}
		
	}
	
	
	
	
	private static void generadorXML(String fichero) throws IOException, TransformerException  {
		TransformerFactory fact = TransformerFactory.newInstance();
		Transformer trans = fact.newTransformer();
		
		Source fuente = new DOMSource(doc);
		File file = new File(fichero);
		
		FileWriter write = new FileWriter(file);
		PrintWriter print = new PrintWriter(write);
		Result res = new StreamResult(print);
		
		trans.transform(fuente, res);
		
	}

}
