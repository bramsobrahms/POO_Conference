package be.brahms.poo_conference.Serialize;

import be.brahms.poo_conference.Conference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

/**
 * The {@code Utility} class provides methods to dave and load {@link Conference} objects
 * from and to XML files. It uses the {@link XmlMapper} class from the Jackson library
 * for serialization and deserialization.
 */
public class Utility {

    /**
     * Saves a {@link Conference} object to an XML file at the specified file path.
     * The {@code Conference} object is serialized into an XML format.
     *
     * @param conference the {@code Conference} object to be saved
     * @param filePath the path of the file where the object will be saved
     * @throws IOException if an I/O error occurs during writing to the file
     */
    public static void saveToFile(Conference conference, String filePath) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File(filePath), conference);
        System.out.printf("Data saved to file: %s\n", filePath);
    }

    /**
     * Loads a {@link Conference} object from an XML file located at the specified fill path.
     * The XML data is deserialized into a {@code Conference} object.
     *
     * @param filePath the path of the file from which the {@code Conference} object will be loaded
     * @return the {@code Conference} object loaded from the XML file
     * @throws IOException if an I/O error occurs during reading from the file
     */
    public static Conference loadFromFile(String filePath) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(new File(filePath), Conference.class);
    }

}
