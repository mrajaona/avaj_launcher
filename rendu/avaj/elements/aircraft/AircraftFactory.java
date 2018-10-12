package avaj.elements.aircraft;

// import avaj.elements.flyable.Flyable;
// import avaj.elements.machines.*;

public class AircraftFactory {

	// public static Flyable newAircraft(string type, string name, int longitude, int latitude, int height) {
	public static Aircraft newAircraft(String type, String name, int longitude, int latitude, int height) {
		System.out.println(type + " created"); // DEBUG

		Coordinates coord	= new Coordinates(longitude, latitude, height);
		Aircraft aircraft	= new Aircraft(name, coord);

		return (aircraft);
	}

}