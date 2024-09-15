package be.brahms.poo_conference;

import be.brahms.poo_conference.Topic.Topic;

import java.util.ArrayList;

public class Guest {

    //Variables
    private String firstname;
    private String lastname;
    private ArrayList<Topic> topics;

    //Constructor without params
    public Guest() {}

    //Constructor with params
    public Guest(String firstname, String lastname, ArrayList<Topic> topics) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.topics = topics;
    }

    public Guest(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    //Generate Getters and Setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    public boolean hasTopic(Topic topic) {
        return topics.contains(topic);
    }

    //ToString
    @Override
    public String toString(){
        return "firstname" + firstname + ", " +
               "lastname" + lastname + ", " +
               "topics" + "<< " + topics + ">>";
    }
}
