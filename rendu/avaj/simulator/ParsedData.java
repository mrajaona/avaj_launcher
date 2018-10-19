package avaj.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class ParsedData {
    
    private int nbSim;
    private ArrayList <ParsedItem> itemList;

    ParsedData(
        int n,
        ArrayList <ParsedItem> list
    ) {
        nbSim       = n;
        itemList    = new ArrayList <ParsedItem> (list);
    }

    int getNbSim() {
        return (nbSim);
    }

    List <ParsedItem> getList() {
        return ( Collections.unmodifiableList(itemList) );
    }

}