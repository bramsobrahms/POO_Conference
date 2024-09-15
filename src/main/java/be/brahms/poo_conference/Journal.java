package be.brahms.poo_conference;

import java.util.ArrayList;

public class Journal {

    // Variable
    private ArrayList<Event> events;

    // Generate Getters and Setters
    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    // ToString
    @Override
    public String toString() {
        return "Journal{" +
                "events=" + events +
                '}';
    }

}
