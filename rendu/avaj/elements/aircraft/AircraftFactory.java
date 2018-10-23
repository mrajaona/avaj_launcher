package avaj.elements.aircraft;

import avaj.elements.flyable.Flyable;

import avaj.exceptions.InvalidAircraftTypeException;
import avaj.exceptions.InvalidCoordinatesException;
import avaj.exceptions.InvalidHeightException;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import avaj.exceptions.AvajException;

public class AircraftFactory {

    public static final String JETPLANE     = "JetPlane";
    public static final String HELICOPTER   = "Helicopter";
    public static final String BALOON       = "Baloon";

    private static final String [] types    = {
        JETPLANE,
        HELICOPTER,
        BALOON
    } ;

    private static final Map <String, FlyableCreator> CREATOR_MAP = initCreatorMap();
    private static final Map <String, FlyableCreator> initCreatorMap() {
        Map <String, FlyableCreator> newMap = new HashMap <String, FlyableCreator> (types.length);

        newMap.put(
            JETPLANE,
            new FlyableCreator() {
                public Flyable make(String name, Coordinates coord) throws AvajException {
                    return (new JetPlane(name, coord));
                }
            }
        );

        newMap.put(
            HELICOPTER,
            new FlyableCreator() {
                public Flyable make(String name, Coordinates coord) throws AvajException {
                    return (new Helicopter(name, coord));
                }
            }
        );

        newMap.put(
            BALOON,
            new FlyableCreator() {
                public Flyable make(String name, Coordinates coord) throws AvajException {
                    return (new Baloon(name, coord));
                }
            }
        );

        return (Collections.unmodifiableMap(newMap));
    }

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AvajException {
        if (
            longitude < Coordinates.COORD_MIN
            || latitude < Coordinates.COORD_MIN
            || height < Coordinates.COORD_MIN
            ) {
            throw ( new InvalidCoordinatesException() );
        }

		Coordinates coord	    = new Coordinates(longitude, latitude, height);
        FlyableCreator creator  = CREATOR_MAP.get(type);

        if (creator == null) {
            throw ( new InvalidAircraftTypeException() );
        }

        Flyable aircraft    = creator.make(name, coord);

		return (aircraft);
	}

    private interface FlyableCreator {
        public Flyable make(String name, Coordinates coord) throws AvajException;
    }

}