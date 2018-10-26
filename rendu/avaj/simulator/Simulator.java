package avaj.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import java.io.IOException;
import avaj.exceptions.AvajException;

import avaj.exceptions.DefaultException;
import avaj.exceptions.NotEnoughArgsException;
import avaj.exceptions.TooManyArgsException;
import avaj.exceptions.InvalidFileException;

import avaj.elements.aircraft.AircraftFactory;
import avaj.elements.flyable.Flyable;
import avaj.elements.weathertower.WeatherTower;

public class Simulator {

    public static void main(String [] args) {
        try {

            if (args.length == 0)
                throw ( new NotEnoughArgsException() );
            else if (args.length < 1)
                throw ( new TooManyArgsException() );

            // Reader
            String fileName = new String(args[0]);

            ArrayList <String> content  = Reader.run(fileName);
            if (content == null)
                throw ( new DefaultException() );
            else if (content.isEmpty())
                throw ( new InvalidFileException() );

            // Lexer
            ArrayList < ArrayList <String> > lexeme = Lexer.run(content);
            if (lexeme == null || lexeme.isEmpty())
                throw ( new DefaultException() );

            fileName    = null;
            content     = null;

            // Parser
            ParsedData parsedData = Parser.run(lexeme);

            // Run simulation
            run(parsedData);

        } catch (AvajException e) {
            System.out.println("AvajException");
            e.printStackTrace(System.out);
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace(System.out);
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace(System.out);
        }

    }

    private static void run(ParsedData data) throws AvajException, IOException {
        OutputManager.createOutputFile();

        final WeatherTower tower        = new WeatherTower();
        AircraftFactory factory         = new AircraftFactory();
        ArrayList <Flyable> flyableList = new ArrayList <Flyable> ();

        List <ParsedItem> parsed            = data.getList();
        ListIterator <ParsedItem> iterator  = parsed.listIterator();

        while (iterator.hasNext()) {

            ParsedItem item     = iterator.next();
            Flyable aircraft    = factory.newAircraft(
                    item.getType(),
                    item.getName(),
                    item.getLongitude(),
                    item.getLatitude(),
                    item.getHeight()
                );

            flyableList.add(aircraft);
            aircraft.registerTower(tower);

        }

        factory = null;

        tower.runSimulation(data.getNbSim());

    }

}