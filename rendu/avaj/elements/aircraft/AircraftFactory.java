package avaj.elements.aircraft;

import avaj.elements.flyable.Flyable;

public class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        System.out.println("newAircraft: " + type + " " + name + ": " + longitude + ", " + latitude + ", " + height); // DEBUG

		Coordinates coord	= new Coordinates(longitude, latitude, height);
		Flyable aircraft	= new Helicopter(name, coord);

        System.out.println(type + " created"); // DEBUG
		return (aircraft);
	}

}