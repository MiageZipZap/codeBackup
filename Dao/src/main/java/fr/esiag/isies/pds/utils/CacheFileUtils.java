package fr.esiag.isies.pds.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

/**
 * Utils class permit to create, update, delete and read a cache file. This file
 * is used when database is out of service.
 * 
 * @author PFR
 *
 */
public class CacheFileUtils {

	/**
	 * Name of cache file (intern at the DAO Project)
	 */
	public static final String cacheFileName = "cache.xml";

	/**
	 * Static class
	 */
	private CacheFileUtils() {
	}

	/**
	 * Add one element (item) in the cache file This method create a file if the
	 * cache file dont' exist
	 * 
	 * @param item
	 * @return
	 * @throws FileNotFoundException 
	 * @throws JAXBException
	 */
	public static boolean add(TypeRefInfra item) throws FileNotFoundException {
		File f = new File(cacheFileName);

		// create file if it doesn't exist
		if (!f.exists()) {
			if (!createCacheFile(f)) {
				return false;
			}
		}
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(TypeRefInfra.class);
//			OutputStream xmlCacheFile = new PrintStream();
//			Unmarshaller unmarshaller = jc.createUnmarshaller();
//			JAXBElement<TypeRefInfra> je1 = unmarshaller.unmarshal(
//					xmlCacheFile, TypeRefInfra.class);
			TypeRefInfra typeRefInfra = item;
			JAXBElement<TypeRefInfra> je2 = new JAXBElement<TypeRefInfra>(
					new QName("typeRefInfra"), TypeRefInfra.class, typeRefInfra);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			PrintStream printStream = new PrintStream(f);
			marshaller.marshal(je2, printStream);
			return true;
		} catch (JAXBException e) {
			// TODO LOGGER
			e.printStackTrace();
			return false;
		}

		// Transform object in xml format
		// put in the cache file
		// return true if no errors
	}

	/**
	 * Create cache File if it doesn't exist.
	 * 
	 * @param cacheFile
	 * @return true if it's OK and false otherwise
	 */
	private static boolean createCacheFile(File cacheFile) {
		try {
			return cacheFile.createNewFile();
		} catch (IOException e) {
			// TODO LOGGER
			return false;
		}
	}

	/**
	 * Delete cache file
	 * 
	 * @return true if it's OK and false otherwise
	 */
	public static boolean delete() {
		File f = new File(cacheFileName);
		return f.delete();
	}

	/**
	 * Read all "T" object which are in this cache file
	 * 
	 * @param clazz
	 * @return List of T Object
	 */
	public static <T> List<T> read(Class clazz) {
		// Return all object of type clazz
		// why handle with multi object (type in infrastructure...)
		// => we manage just an id ? or all object ? see later
		return null;
	}
}
