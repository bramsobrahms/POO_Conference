package be.brahms.poo_conference;

import be.brahms.poo_conference.Topic.Topic;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PooConferenceApplication {

    public static void main(String[] args) throws Exception {

        try {
            // Créer un exemple de conférence
            ArrayList<Guest> guests = new ArrayList<>();
            guests.add(new Guest("Bob", "Sull", new ArrayList<>(List.of(Topic.IT, Topic.ENVIRONMENT))));
            Conference conf = new Conference("Conférence low emission IT", "2024-09-02T18:00:00", Topic.IT, 30.0, guests);

            // Configurer ObjectMapper pour le XML
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Sérialiser l'objet Conference en XML
            String xml = xmlMapper.writeValueAsString(conf);
            System.out.println(xml);

            xmlMapper.writeValue(new File("conference.xml"), conf);
            System.out.println("La conférence a été écrite dans le fichier conference.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
