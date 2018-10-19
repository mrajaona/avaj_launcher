package avaj.elements.aircraft;

import avaj.elements.flyable.Flyable;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class AircraftFactory {

    public static final String JETPLANE     = "JetPlane";
    public static final String HELICOPTER   = "Helicopter";
    public static final String BALOON       = "Baloon";

    private static final String [] types    = {
        JETPLANE,
        HELICOPTER,
        BALOON
    } ;

    private static Map <String, FlyableCreator> creatorMap = initCreatorMap();
    private static Map <String, FlyableCreator> initCreatorMap() {

        Map <String, FlyableCreator> newMap = new HashMap <String, FlyableCreator> (types.length);

        newMap.put(
            JETPLANE,
            new FlyableCreator() {
                public Flyable make(String name, Coordinates coord) {
                    return (new JetPlane(name, coord));
                }
            }
        );

        newMap.put(
            HELICOPTER,
            new FlyableCreator() {
                public Flyable make(String name, Coordinates coord) {
                    return (new Helicopter(name, coord));
                }
            }
        );

        newMap.put(
            BALOON,
            new FlyableCreator() {
                public Flyable make(String name, Coordinates coord) {
                    return (new Baloon(name, coord));
                }
            }
        );

        return (Collections.unmodifiableMap(newMap));

    }

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
       // System.out.println("newAircraft: " + type + " " + name + ": " + longitude + ", " + latitude + ", " + height); // DEBUG

		Coordinates coord	    = new Coordinates(longitude, latitude, height);
        FlyableCreator creator  = creatorMap.get(type);

        if (creator == null) {
            return (null);
        }

        Flyable aircraft    = creator.make(name, coord);

		return (aircraft);
	}

    private interface FlyableCreator {
        public Flyable make(String name, Coordinates coord);
    }

}