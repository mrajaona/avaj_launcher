package avaj.simulator;

import avaj.elements.aircraft.AircraftFactory;
import avaj.elements.flyable.Flyable;
import avaj.elements.weathertower.WeatherTower;

import avaj.exceptions.AvajException;

import avaj.exceptions.DefaultException;
import avaj.exceptions.NotEnoughArgsException;
import avaj.exceptions.TooManyArgsException;
import avaj.exceptions.InvalidFileException;

import java.util.ArrayList;
import java.util.ListIterator;
import java.io.IOException;

public class Simulator {

    public static void main(String [] args) {
        try {

            if (args.length == 0)
                throw (new NotEnoughArgsException() );
            else if (args.length < 1)
                throw (new TooManyArgsException() );

            // Reader

            String fileName = new String(args[0]);

            ArrayList <String> content  = Reader.run(fileName);
            if (content == null)
                throw (new DefaultException());
            else if (content.isEmpty())
                throw (new InvalidFileException());

            // DEBUG
            {
                ListIterator <String> contentIterator = content.listIterator();

                while (contentIterator.hasNext()) {
                    System.out.println(contentIterator.next());
                }
            }
            // END DEBUG

            // Lexer
            fileName = null;

            // Parser

            // Run simulation

            WeatherTower tower      = new WeatherTower();

            AircraftFactory factory = new AircraftFactory();

            // TEST
            {
                Flyable aircraftA = factory.newAircraft("JetPlane", "nameA", 0, 1, 2);
                Flyable aircraftB = factory.newAircraft("Helicopter", "nameB", 10, 11, 12);
                Flyable aircraftC = factory.newAircraft("Baloon", "nameC", 20, 21, 22);

                aircraftA.registerTower(tower);
                aircraftB.registerTower(tower);
                aircraftC.registerTower(tower);

                tower.runSimulation(10);
            }
            // END TEST

        } catch (AvajException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}