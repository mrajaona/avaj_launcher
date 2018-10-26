package avaj.simulator;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.IOException;
import avaj.exceptions.AvajException;

import avaj.exceptions.DefaultException;

class Reader {

    static ArrayList <String> run(final String fileName) throws AvajException, IOException {
        ArrayList <String> content  = new ArrayList <String> ();
        String line                 = null;

        final FileReader fileReader = new FileReader(fileName);
        if (fileReader == null)
            throw ( new DefaultException() );

        final BufferedReader bufferedReader = new BufferedReader(fileReader);
        if (bufferedReader == null)
            throw ( new DefaultException() );

        while((line = bufferedReader.readLine()) != null) {
            if (content.add(new String(line)) == false)
                throw ( new DefaultException() );
        } 

        bufferedReader.close();

        return (content);
    }

}