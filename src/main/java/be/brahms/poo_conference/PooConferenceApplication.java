package be.brahms.poo_conference;

import be.brahms.poo_conference.Topic.Topic;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        /**
         * This method creates a `Conference` object, serializes it into an XML string,
         * and writes the XML content into a file called `conference.xml`.
         * It handles any exceptions during the process by printing the stack trace.
         *
         * Steps:
         * - Create a list of `Guest` objects.
         * - Create a `Conference` object using the list of guests and other attributes.
         * - Configure the `XmlMapper` to support `LocalDateTime` and enable formatted (indented) output.
         * - Serialize the `Conference` object into an XML string.
         * - Write the XML string to the console and to a file called "conference.xml".
         *
         * @throws Exception if an error occurs during serialization or file writing.
         */

        try {
            // Create an ArrayList to store the guests who will attend the conference.
            ArrayList<Guest> guests = new ArrayList<>();

            // Add a new guest to the list with the name "Bob Sull" and skills in IT and Environment.
            // The skills are stored as a list of Topics (enumeration values).
            guests.add(new Guest("Bob", "Sull", new ArrayList<>(List.of(Topic.IT, Topic.ENVIRONMENT))));

            // Create a new `Conference` object.
            Conference conf = new Conference("Conférence low emission IT", "2024-09-02T18:00:00", Topic.IT, 30.0, guests);

            // Create a new XmlMapper object, which is used for serializing Java objects to XML format.
            XmlMapper xmlMapper = new XmlMapper();

            // Register the JavaTimeModule with XmlMapper to handle Java 8 date/time classes
            // like LocalDateTime during serialization/deserialization.
            xmlMapper.registerModule(new JavaTimeModule());

            // Enable pretty-printing (indentation) in the XML output to make it easier to read.
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Serialize the `Conference` object into an XML string.
            // The `writeValueAsString` method converts the object to XML format as a string.
            String xml = xmlMapper.writeValueAsString(conf);
            System.out.println(xml);

            // Write the XML representation of the `Conference` object to a file named "conference.xml".
            // The `writeValue` method takes a File object as a target and writes the XML data into it.
            xmlMapper.writeValue(new File("conference.xml"), conf);
            System.out.println("La conférence a été écrite dans le fichier conference.xml");

        } catch (Exception e) {
            // If any exception occurs during the process, it will be caught here,
            // and the stack trace will be printed to help diagnose the error.
            e.printStackTrace();
        }

        /**
         * This class demonstrates how to serialize a `Conference` object to JSON format using Jackson.
         * It adds guest details to a conference, converts the object to JSON format, and writes it to a file.
         */

        try {
            // Create a list of guests
            ArrayList<Guest> guests = new ArrayList<>();
            // Add guest details to the list
            guests.add(new Guest("Bob", "Sull", new ArrayList<>(List.of(Topic.ENVIRONMENT, Topic.ENERGY))));
            guests.add(new Guest("Boby", "Skull", new ArrayList<>(List.of(Topic.IT, Topic.ENERGY))));

            // Create a Conference object with title, date, topic, price, and list of guests
            Conference conf = new Conference("Conference Energy", "2024-09-03T18:00:00", Topic.ENVIRONMENT, 0d, guests);

            // Initialize the Jackson ObjectMapper for handling JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Register the JavaTimeModule to handle Java 8 and more date and time formats (LocalDateTime)
            objectMapper.registerModule(new JavaTimeModule());

            // Enable pretty-printing for JSON output
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Serialize the Conference object to a JSON string
            String json = objectMapper.writeValueAsString(conf);
            System.out.println(json);

            // Write the JSON representation of the Conference object to a file named "conference.json"
            objectMapper.writeValue(new File("conference.json"), conf);
            System.out.println("La conférence a été écrite dans le fichier conference.json");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
