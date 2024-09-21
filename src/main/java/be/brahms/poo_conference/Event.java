package be.brahms.poo_conference;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.LocalDateTime;

/**
 * The Event class represents an event with a title and a specific date/time.
 * It uses Jackson annotations for XML serialization and deserialization.
 * The date is formatted in the pattern "yyyy-MM-dd'T'HH:mm:ss".
 */
public class Event {

    /**
     * The title or description of the event.
     * This field is serialized as an XML attribute with the name "title".
     */
    @JacksonXmlProperty(isAttribute = true, localName = "title")
    private String text;

    /**
     * The date and time of the event.
     * This field is serialized as an XML attribute with the name "date"
     * and follows the format "yyyy-MM-dd'T'HH:mm:ss".
     */
    @JacksonXmlProperty(isAttribute = true, localName = "date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateEvent;

    /**
     * Constructs a new Event with the given title and date/time.
     *
     * @param text      the title or description of the event
     * @param dateEvent the date and time of the event
     */
    public Event(String text, LocalDateTime dateEvent) {
        this.text = text;
        this.dateEvent = dateEvent;
    }

    /**
     * Gets the title or description of the event.
     * @return the event title
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the title or description of the event.
     * @param text the new event title
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the date and time of the event.
     * @return the event's date and time
     */
    public LocalDateTime getDateEvent() {
        return dateEvent;
    }

    /**
     * Sets the date and time of the event.
     * @param dateEvent the new date and time of the event
     */
    public void setDateEvent(LocalDateTime dateEvent) {
        this.dateEvent = dateEvent;
    }

    /**
     * Returns a string representation of the Event object.
     * @return a string representation of the event, including its title and date/time.
     */
    @Override
    public String toString() {
        return "Event{" +
                "text='" + text + '\'' +
                ", dateEvent=" + dateEvent +
                '}';
    }
}
