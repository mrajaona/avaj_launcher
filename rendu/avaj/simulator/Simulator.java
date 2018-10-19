package avaj.simulator;

import avaj.elements.aircraft.AircraftFactory;
import avaj.elements.flyable.Flyable;
import avaj.elements.weathertower.WeatherTower;

import avaj.exceptions.AvajException;
import java.lang.Exception;

import avaj.exceptions.NotEnoughArgsException;
import avaj.exceptions.TooManyArgsException;

public class Simulator {

    public static void main(String [] args) {
        try {

            if (args.length == 0)
                throw (new NotEnoughArgsException() );
            else if (args.length < 1)
                throw (new TooManyArgsException() );

            String filename         = args[0];

            Reader reader           = new Reader();

            // Run simulation

            WeatherTower tower      = new WeatherTower();

            AircraftFactory factory = new AircraftFactory();

            Flyable aircraftA = factory.newAircraft("JetPlane", "nameA", 0, 1, 2);
            Flyable aircraftB = factory.newAircraft("Helicopter", "nameB", 10, 11, 12);
            Flyable aircraftC = factory.newAircraft("Baloon", "nameC", 20, 21, 22);

            aircraftA.registerTower(tower);
            aircraftB.registerTower(tower);
            aircraftC.registerTower(tower);

            tower.runSimulation(10);

        } catch (AvajException e) {
            //System.err.println(e.toString());
            e.printStackTrace();
        }

    }

}