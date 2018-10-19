package avaj.simulator;

import avaj.exceptions.AvajException;
import avaj.exceptions.InvalidFileException;

import java.util.ArrayList;
import java.util.ListIterator;

class Parser {

    static ParsedData run(ArrayList < ArrayList <String> > lexeme) throws AvajException {

        int simNum = 0;

        // get number of simulations to run
        ArrayList <String> firstLine = lexeme.get(0);
        if (firstLine != null) {

            if (firstLine.size() != 1)
                throw ( new InvalidFileException() );

            String num = firstLine.get(0);
            simNum = Integer.parseInt(num);
        
        }

        // remove first line
        lexeme.remove(0);

        ArrayList <ParsedItem> parsed = new ArrayList <ParsedItem> ();

        ListIterator < ArrayList <String> > iterator = lexeme.listIterator();
        ListIterator <String> subIterator;

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