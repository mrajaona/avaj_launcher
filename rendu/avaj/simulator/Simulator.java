package avaj.simulator;

import avaj.elements.aircraft.AircraftFactory;
import avaj.elements.flyable.Flyable;
import avaj.elements.weathertower.WeatherTower;

public class Simulator {

    public static void main(String [] args) {
        WeatherTower tower = new WeatherTower();

        AircraftFactory factory = new AircraftFactory();

        Flyable aircraftA = factory.newAircraft("type A", "nameA", 0, 1, 2);
        Flyable aircraftB = factory.newAircraft("type B", "nameB", 10, 11, 12);
        Flyable aircraftC = factory.newAircraft("type C", "nameC", 20, 21, 22);

        aircraftA.registerTower(tower);
        aircraftB.registerTower(tower);
        aircraftC.registerTower(tower);

        tower.runSimulation(3);
    }

}