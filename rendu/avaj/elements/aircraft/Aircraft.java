package avaj.elements.aircraft;

import java.lang.Long;

import java.io.IOException;
import avaj.exceptions.AvajException;

import avaj.exceptions.TooManyAircraftsException;
import avaj.exceptions.InvalidAircraftTypeException;

import avaj.simulator.OutputManager;

public class Aircraft {

	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected String type;

	private static long idCounter = 0;

	private Aircraft() {}

	protected Aircraft(String n, Coordinates c) throws AvajException {
		name 		= n;
		coordinates	= c;
		id			= nextId();
	}

	private long nextId() throws AvajException {
		if (idCounter == Long.MAX_VALUE)
			throw ( new TooManyAircraftsException() );

		long ret = idCounter++;
		return (ret);
	}

    protected void log(final String message) throws AvajException, IOException {
        OutputManager.writeToFile(identify() + ": " + message);
    }

    protected void verbose(final String message) throws AvajException, IOException {
        OutputManager.verbose(identify() + ": " + message);
    }

    public String identify() throws AvajException {
    	if ( type.isEmpty() )
    		throw ( new InvalidAircraftTypeException() );

        return (type + "#" + name + "(" + id + ")");
    }

}