package be.brahms.poo_conference.Serialize;

import be.brahms.poo_conference.Conference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class Utility {

    public static void saveToFile(Conference conference, String filePath) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File(filePath), conference);
        System.out.printf("Data saved to file: %s\n", filePath);
    }

    public static Conference loadFromFile(String filePath) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(new File(filePath), Conference.class);
    }

}
