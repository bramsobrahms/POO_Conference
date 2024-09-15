package be.brahms.poo_conference;

import be.brahms.poo_conference.Exception.MissingTopicException;
import be.brahms.poo_conference.Topic.Topic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ConferenceTest {

    private Conference conferenceWithTopic;
    private Conference conferenceWithoutTopic;
    private Guest guestWithTopic;
    private Guest guestWithoutTopic;

    @BeforeEach
    void SetUp() {
        conferenceWithTopic = new Conference("Junit", "2024-09-02T18:00", Topic.IT, 30d);
        conferenceWithoutTopic = new Conference("Chill", "2024-09-02T18:00");
        guestWithTopic = new Guest("John", "Snowden", new ArrayList<>(List.of(Topic.IT)));
        guestWithoutTopic = new Guest("Bob", "Square", new ArrayList<>(List.of(Topic.ENVIRONMENT)));
    }

    @Test
    void testConstructor() {

        Conference conference = new Conference("Conference low emission IT", "2024-09-02T18:00", Topic.IT, 30d);

        //Check if all data are correct
        assertEquals("Conference low emission IT", conference.getText());
        assertEquals("2024-09-02T18:00", conference.getDateEvent().toString());
        assertEquals(Topic.IT, conference.getTopic());
        assertEquals(30d, conference.getPrice());
    }

    @Test
    void testConstructorWithoutPrice() {

        Conference conference = new Conference("Conference low emission IT", "2024-09-02T18:00");

        //Check if the conference is free
        assertEquals(0d, conference.getPrice());
    }

    @Test
    void testConferenceImplementApplicable() {

        Conference conference = new Conference("Conference low emission IT", "2024-09-02T18:00", Topic.IT, 30d);

        //Check if interface is implemented on the conference's class
        assertInstanceOf(Applicable.class, conference);
    }

    @Test
    void testMissingTopicException() {
        // Test if the exception is thrown when the guest does not have the required topic
        try {
            conferenceWithTopic.apply(guestWithoutTopic);
            fail("MissingTopicException should have been thrown");
        } catch (MissingTopicException e) {
            assertEquals("The guest doesn't have required this topic: " + Topic.IT, e.getMessage());
        }
    }

    @Test
    void testApplyWithTopic() {
        //Test if the guest can apply when they have required topic
        assertTrue(conferenceWithTopic.apply(guestWithTopic));
        assertTrue(conferenceWithTopic.getGuests().contains(guestWithTopic));
    }

    @Test
    void testApplyWithoutTopic() {
        //Test if the guest can apply to a conference without a specific topic
        assertTrue(conferenceWithoutTopic.apply(guestWithTopic));
        assertTrue(conferenceWithoutTopic.getGuests().contains(guestWithTopic));
    }

}