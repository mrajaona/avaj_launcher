package avaj.simulator;

import avaj.elements.aircraft.AircraftFactory;
import avaj.elements.aircraft.Aircraft;

public class Simulator {

    public static void main(String [] args) {
        AircraftFactory factory = new AircraftFactory();

        Aircraft aircraftA = factory.newAircraft("type A", "nameA", 0, 1, 2);
        Aircraft aircraftB = factory.newAircraft("type B", "nameB", 10, 11, 12);
        Aircraft aircraftC = factory.newAircraft("type C", "nameC", 20, 21, 22);
    }

}