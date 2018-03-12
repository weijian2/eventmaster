package com.example.daniel.eventmaster;

/**
 * Created by daniel on 3/11/18.
 */

public class Event {
    /**
     * fields for an event.
     */
    private String title;
    private String address;
    private String content;

    /**
     * constructor
     * @param title String representation of name of this event.
     * @param address String representation of address of this event.
     * @param content String representation of content of this event.
     */
    public Event(String title, String address, String content) {
        this.title = title;
        this.address = address;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }
}
