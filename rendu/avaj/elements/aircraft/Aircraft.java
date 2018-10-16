package avaj.elements.aircraft;

public class Aircraft {

	protected long id;
	protected String name;
	protected Coordinates coordinates; // TO DO : check destroyed with Aircraft

	private static long idCounter = 0;

	private Aircraft() {}

	protected Aircraft(String n, Coordinates c) {
		name 		= n;
		coordinates	= c;
		id			= idCounter;

		idCounter++; // TO DO : limit
		System.out.println("id: " + id); // DEBUG
		System.out.println("idCounter: " + idCounter); // DEBUG
	}

	private long nextId() {
		return (idCounter + 1); // TO CHECK
	}

}