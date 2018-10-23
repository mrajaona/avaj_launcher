package avaj.simulator;

import avaj.exceptions.AvajException;
import avaj.exceptions.InvalidFileException;
import avaj.exceptions.DefaultException;

import java.util.ArrayList;
import java.util.ListIterator;

class Parser {

    static ParsedData run(ArrayList < ArrayList <String> > lexeme) throws AvajException {
        // get number of simulations to run
        ArrayList <String> firstLine = lexeme.get(0);
        if (firstLine == null)
            throw ( new DefaultException() );
        if (firstLine.size() != 1)
            throw ( new InvalidFileException() );

        int simNum = Integer.parseInt(firstLine.get(0));

        // remove first line
        lexeme.remove(0);

        ArrayList <ParsedItem> parsed                   = new ArrayList <ParsedItem> ();
        ListIterator < ArrayList <String> > iterator    = lexeme.listIterator();

        // get aircrafts
        while (iterator.hasNext()) {
            ArrayList <String> tmp = iterator.next();

            if (tmp.size() != 5)
                throw ( new InvalidFileException() );

            parsed.add(
                new ParsedItem(
                    tmp.get(0), // type 
                    tmp.get(1), // name
                    tmp.get(2), // longitude
                    tmp.get(3), // latitude
                    tmp.get(4)  // height  
                )
            );
        }

        return ( new ParsedData(simNum, parsed) );
    }
}