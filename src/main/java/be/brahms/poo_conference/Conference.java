package be.brahms.poo_conference;

import be.brahms.poo_conference.Exception.MissingTopicException;
import be.brahms.poo_conference.Topic.Topic;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The {@code Conference} class represents an event of type conference.
 * It extends the {@link Event} class and implements the {@link Applicable} interface
 * A conference is associated with a topic ({@link Topic}), a price, and list of guests.
 */
public class Conference extends Event implements Applicable{

    /**
     * The topic of the conference
     */
    private Topic topic;
    /**
     * The entrance price for the conference
     */
    private double price;
    /**
     * The list of guests attending the conference.
     */
    private ArrayList<Guest> guests;

    /**
     * Constructs a new {@code Conference} instance with a topic, a price, and a list of guests.
     *
     * @param text          the title of the event
     * @param dateEvent     the date and time of the event as a string
     * @param topic         the topic of the conference
     * @param price         the entrance price for the conference
     * @param guests        the list of guests attending the conference
     */
    public Conference(String text, String dateEvent, Topic topic, double price, ArrayList<Guest> guests) {
        super(text, LocalDateTime.parse(dateEvent));
        this.topic = topic;
        this.price = price;
        this.guests = new ArrayList<>();
    }

    /**
     * Constructs a new {@code Conference} instance with a topic, a price, without guests.
     *
     * @param text          the title of the event
     * @param dateEvent     the date and time of the event as a string
     * @param topic         the topic of the conference
     * @param price         the entrance price for the conference
     */
    public Conference(String text, String dateEvent, Topic topic, double price) {
        super(text, LocalDateTime.parse(dateEvent));
        this.topic = topic;
        this.price = price;
        this.guests = new ArrayList<>();
    }

    /**
     * Constructs a new {@code Conference} instance with only a price, without topic or guests.
     *
     * @param text          the title of the event
     * @param dateEvent     the date and time of the event as a string
     * @param price         the entrance price for the conference
     */
    public Conference(String text, String dateEvent, double price ) {
        super(text, LocalDateTime.parse(dateEvent));
        this.price = price;
        this.guests = new ArrayList<>();
    }

    /**
     * Constructs a new {@code Conference} instance with only title and date event.
     *
     * @param text          the title of the event
     * @param dateEvent     the date and time of the event as a string
     */
    public Conference(String text, String dateEvent) {
        this(text, dateEvent, 0d);
    }

    /**
     * Retrieves the list of guests attending the conference.
     *
     * @return the list of guests.
     */
    public ArrayList<Guest> getGuests() {
        return guests;
    }

    /**
     * Sets the list of guests attending the conference.
     *
     * @param guests the new list of guests
     */
    public void setGuests(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    /**
     * Retrieves the topic of the conference.
     *
     * @return the topic of the conference.
     */
    public Topic getTopic() {
        return topic;
    }

    /**
     * Sets the topic of the conference.
     *
     * @param topic the new topic of the conference.
     */
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    /**
     * Retrieves the entrance price of the conference.
     *
     * @return the entrance price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the entrance price of the conference.
     *
     * @param price the new entrance price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns a string representation of the conference.
     *
     * @return a string representing the conference, including its topic, price and guest list
     */
    @Override
    public String toString() {
        return "Conference{" +
                "topic=" + topic +
                ", price=" + price +
                ", guests=" + guests +
                '}';
    }

    /**
     * Applies the invitations of a guest to the conference based on their topic of expertise
     * If no topic is defined, the guest is accepted.
     * If a topic is defined, the guest must have this topic in their areas of expertise.
     *
     * @param g the guest to add the conference.
     * @return {@code true} if the guest was added, {@code false} otherwise.
     * @throws MissingTopicException if the guest does not have the required topic
     */
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
            throw new MissingTopicException("The guest doesn't have required this topic: " + topic);
        }
    }
}
