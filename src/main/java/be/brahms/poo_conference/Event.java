package be.brahms.poo_conference;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.LocalDateTime;

public class Event {
    // Variables
    @JacksonXmlProperty(isAttribute = true, localName = "title")
    private String text;
    @JacksonXmlProperty(isAttribute = true, localName = "date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateEvent;

    //Constructor with params
    public Event(String text, LocalDateTime dateEvent) {
        this.text = text;
        this.dateEvent = dateEvent;
    }

    // Generates Getters and Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(LocalDateTime dateEvent) {
        this.dateEvent = dateEvent;
    }

    //ToString
    @Override
    public String toString() {
        return "Event{" +
                "text='" + text + '\'' +
                ", dateEvent=" + dateEvent +
                '}';
    }
}
