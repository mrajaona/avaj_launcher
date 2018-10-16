package avaj.elements.weathertower;

import avaj.elements.flyable.Flyable;
import avaj.elements.aircraft.Coordinates;

import java.util.ArrayList;

public class Tower {

    private ArrayList <Flyable> observers = new ArrayList <Flyable> ();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        // flyable.updateConditions();
    }

}