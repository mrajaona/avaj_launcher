package avaj.elements.aircraft;

import avaj.exceptions.AvajException;
import avaj.exceptions.TooManyAircraftsException;

import java.lang.Long;

public class Aircraft {

	protected long id;
	protected String name;
	protected Coordinates coordinates;

	private static long idCounter = 0;

	private Aircraft() {}

	protected Aircraft(String n, Coordinates c) throws AvajException {
		if (idCounter == Long.MAX_VALUE) {
			throw ( new TooManyAircraftsException() );
		}

		name 		= n;
		coordinates	= c;
		id			= idCounter;

		idCounter++; // TO DO : limit
	}

	private long nextId() {
		return (idCounter + 1); // TO CHECK
	}

}