package avaj.simulator;

import avaj.exceptions.AvajException;
import avaj.exceptions.InvalidRunNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class ParsedData {
    
    private int nbSim;
    private ArrayList <ParsedItem> itemList;

    ParsedData(
        int n,
        ArrayList <ParsedItem> list
    ) throws AvajException {
        nbSim       = n;
        if (nbSim < 0) {
            throw ( new InvalidRunNumberException() );
        }
        itemList    = new ArrayList <ParsedItem> (list);
    }

    int getNbSim() {
        return (nbSim);
    }

    List <ParsedItem> getList() {
        return ( Collections.unmodifiableList(itemList) );
    }

}