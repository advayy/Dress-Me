package model;

import java.util.*;

public class EventLog implements Iterable<Event> {
	/** the only EventLog in the system (Singleton Design Pattern) */
    private static EventLog theLog;
    private Collection<Event> events;

	/**
	 * Prevent external construction.
	 * (Singleton Design Pattern).
	 */
    private EventLog() {
        events = new ArrayList<Event>();
    }

    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }

        return theLog;
    }

	/**
	 * Adds an event to the event log.
	 * @param e the event to be added
	 */
    public void logEvent(Event e) {
    	events.add(e);
    }

	/**
	 * Clears the event log and logs the event.
	 */
    public void clear() {
    	events.clear();
    	logEvent(new Event("Event log cleared."));
    }

    @Override
    public Iterator<Event> iterator() {
    	return events.iterator();
    }
}