package avaj.elements.weathertower;

import avaj.elements.flyable.Flyable;
import avaj.elements.aircraft.Coordinates;

import java.util.List;
import java.util.ArrayList;

public class Tower {

    private List <Flyable> observers = new ArrayList <Flyable> ();

    public void register(Flyable flyable) {

    }

    public void unregister(Flyable flyable) {
        // delete by id
    }

    protected void conditionsChanged() {
        // flyable.updateConditions();
    }

}