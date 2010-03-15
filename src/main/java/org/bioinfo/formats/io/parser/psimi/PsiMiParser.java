package org.bioinfo.formats.io.parser.psimi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class PsiMiParser {

	private final static String PSIMI_CONTEXT = "org.bioinfo.formats.io.parser.psimi.jaxb";
	
	public static void saveXMLInfo(Object obj, String filename) throws FileNotFoundException, JAXBException {
		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(PSIMI_CONTEXT);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(obj, new FileOutputStream(filename));	
	}

	/**
	 * Checks if XML info file exists and loads it
	 * @throws JAXBException 
	 * @throws IOException
	 */
	public static Object loadXMLInfo(String filename) throws JAXBException {
		Object obj = null;
		JAXBContext jaxbContext = JAXBContext.newInstance(PSIMI_CONTEXT);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		obj =  unmarshaller.unmarshal(new File(filename));
		return obj;
	}
}
