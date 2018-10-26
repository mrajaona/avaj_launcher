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

        int simNum = Integer.parseInt(Md5.decrypt(firstLine.get(0)));

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
                    Md5.decrypt(tmp.get(0)), // type 
                    Md5.decrypt(tmp.get(1)), // name
                    Md5.decrypt(tmp.get(2)), // longitude
                    Md5.decrypt(tmp.get(3)), // latitude
                    Md5.decrypt(tmp.get(4))  // height  
                )
            );
        }

        return ( new ParsedData(simNum, parsed) );
    }

}