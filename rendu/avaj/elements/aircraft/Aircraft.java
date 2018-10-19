package avaj.elements.aircraft;

public class Aircraft {

	protected long id;
	protected String name;
	protected Coordinates coordinates;

	private static long idCounter = 0;

	private Aircraft() {}

	protected Aircraft(String n, Coordinates c) {
		name 		= n;
		coordinates	= c;
		id			= idCounter;

		idCounter++; // TO DO : limit
	}

	private long nextId() {
		return (idCounter + 1); // TO CHECK
	}

}