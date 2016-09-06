package xmlUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import jaxB.akt.Akt;
import jaxB.amandman.Amandman;

public class xmlCheck {
	
	private static xmlCheck instance = null;
	
	public static xmlCheck getInstance(){
		if(instance == null)
			instance = new xmlCheck();
		return instance;
	}
	
	public xmlCheck(){}
	
	public Response CheckAct(Akt akt, String path) throws SAXException, JAXBException, FileNotFoundException{
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		
		StreamSource schemaAkt = new StreamSource(getClass().getResourceAsStream("/schema/akt.xsd"));
		
		Schema schema = sf.newSchema(schemaAkt);
		JAXBContext context = JAXBContext.newInstance(Akt.class);
		
		Marshaller marsh = context.createMarshaller();
		marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marsh.setSchema(schema);
		
		marsh.marshal(akt, new FileOutputStream(path));
		
		return Response.status(200).entity("OK").build();
		
	}
	
	public Response CheckAmendment(Amandman amandman, String path) throws SAXException, JAXBException, FileNotFoundException{
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			

			StreamSource schemaAmandman = new StreamSource(getClass().getResourceAsStream("/schema/amandman.xsd"));
			

			

			
			Schema schema = sf.newSchema(schemaAmandman);
			
			JAXBContext context = JAXBContext.newInstance(Amandman.class);
			
			Marshaller marsh = context.createMarshaller();
			marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marsh.setSchema(schema);
	        marsh.marshal(amandman, new FileOutputStream(path));
	        
	        return Response.status(200).entity("OK").build();
		}

}

