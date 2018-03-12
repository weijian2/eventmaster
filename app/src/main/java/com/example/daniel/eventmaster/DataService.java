package com.example.daniel.eventmaster;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 3/11/18.
 */

/**
 * Fake all data, will refine this function and connect to backend service later.
 */
public class DataService {
    public static List<Event> getEventData() {
        List<Event> eventData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            eventData.add(new Event("Warriors", "4742 Center Avenue, PA 15213",
                    "Go! Warriors!")
            );
        }
        return eventData;
    }
}
