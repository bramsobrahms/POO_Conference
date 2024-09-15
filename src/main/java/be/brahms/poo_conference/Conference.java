package be.brahms.poo_conference;

import be.brahms.poo_conference.Exception.MissingTopicException;
import be.brahms.poo_conference.Topic.Topic;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Conference extends Event implements Applicable{

    //Variables
    private Topic topic;
    private double price;
    private ArrayList<Guest> guests;

    //Constructor with params
    public Conference(String text, String dateEvent, Topic topic, double price, ArrayList<Guest> guests) {
        super(text, LocalDateTime.parse(dateEvent));
        this.topic = topic;
        this.price = price;
        this.guests = new ArrayList<>();
    }

    public Conference(String text, String dateEvent, Topic topic, double price) {
        super(text, LocalDateTime.parse(dateEvent));
        this.topic = topic;
        this.price = price;
        this.guests = new ArrayList<>();
    }

    public Conference(String text, String dateEvent, double price ) {
        super(text, LocalDateTime.parse(dateEvent));
        this.price = price;
        this.guests = new ArrayList<>();
    }

    public Conference(String text, String dateEvent) {
        this(text, dateEvent, 0d);
    }

    //Generate Getters and Setters
    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //ToString
    @Override
    public String toString() {
        return "Conference{" +
                "topic=" + topic +
                ", price=" + price +
                ", guests=" + guests +
                '}';
    }

    @Override
    public Boolean apply(Guest g) {

        if(topic == null ) {
            guests.add(g);
            return true;
        }

        if(g.hasTopic(topic)) {
            guests.add(g);
            return true;
        } else {
            throw new MissingTopicException("The guest doesn't have require this topic: " + topic);
        }
    }
}
