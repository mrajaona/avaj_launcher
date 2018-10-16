package avaj.elements.aircraft;

import avaj.elements.flyable.Flyable;
// import avaj.elements.machines.*;

public class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        System.out.println("newAircraft: " + type + " " + name + ": " + longitude + ", " + latitude + ", " + height); // DEBUG
        return null;
        /*
		Coordinates coord	= new Coordinates(longitude, latitude, height);
		Flyable aircraft	= ;

        System.out.println(type + " created"); // DEBUG
		return (aircraft);
        */
	}

}