package avaj.simulator;

import avaj.exceptions.AvajException;
import avaj.exceptions.InvalidFileException;

import java.util.ArrayList;
import java.util.ListIterator;

class Parser {

    static void run(ArrayList < ArrayList <String> > lexeme) throws AvajException {
        ListIterator < ArrayList <String> > iterator = lexeme.listIterator();
        ListIterator <String> subIterator;

        int simNum = 0;

        // get number of simulations to run
        ArrayList <String> firstLine = lexeme.get(0);
        if (firstLine != null) {

            if (firstLine.size() != 1)
                throw ( new InvalidFileException() );

            String num = firstLine.get(0);
            simNum = Integer.parseInt(num);
        
        }

        System.out.println("simNum = " + simNum);

        while (iterator.hasNext()) {

            subIterator = iterator.next().listIterator();
            while (subIterator.hasNext()) {
                System.out.print(subIterator.next() + " - ");
            }

            System.out.println();                    

        }



        // get aircrafts

        return ;
        // return (parsed);
    }

}