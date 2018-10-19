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
                System.out.println("----- Debug Reader");

                ListIterator <String> iterator = content.listIterator();

                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }

                System.out.println("----- End debug Reader");
                System.out.println();
            }
            // END DEBUG

            // Lexer
            ArrayList < ArrayList <String> > lexeme = Lexer.run(content);
            if (lexeme == null || lexeme.isEmpty())
                throw (new DefaultException());

            fileName    = null;
            content     = null;

            // DEBUG
            {
                System.out.println("----- Debug Lexer");

                ListIterator < ArrayList <String> > iterator = lexeme.listIterator();
                ListIterator <String> subIterator;

                while (iterator.hasNext()) {

                    subIterator = content.listIterator();
                    while (subIterator.hasNext()) {
                        System.out.print(subIterator.next() + " ");
                    }

                }

                System.out.println("----- End debug Lexer");
                System.out.println();

            }
            // END DEBUG

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