package avaj.simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

class Lexer {

    static ArrayList < ArrayList <String> > run(ArrayList <String> content) {
        List <String> line;
        ArrayList < ArrayList <String> > lexeme = new ArrayList < ArrayList <String> > ();

        ListIterator <String> iterator = content.listIterator();

        while (iterator.hasNext()) {
            line = Arrays.asList(iterator.next().split(" "));

            /*
            // Print md5
            for (String word : line) {
                System.out.print(Md5.encrypt(word) + " ");
            }
                System.out.println("");
            */

            lexeme.add(new ArrayList <String> (line));
        }

        return (lexeme);
    }

}