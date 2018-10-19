package avaj.simulator;

import avaj.exceptions.AvajException;
import avaj.exceptions.DefaultException;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.IOException;

class Reader {

    public static ArrayList <String> run(String fileName) throws AvajException, IOException {
        ArrayList <String> content  = new ArrayList <String> ();
        String line                 = null;

        FileReader fileReader           = new FileReader(fileName);
        if (fileReader == null)
            throw (new DefaultException());
        
        BufferedReader bufferedReader   = new BufferedReader(fileReader);
        if (bufferedReader == null)
            throw (new DefaultException());

        while((line = bufferedReader.readLine()) != null) {
            if (content.add(new String(line)) == false)
                throw (new DefaultException());
        } 

        bufferedReader.close();

        return (content);
    }

}