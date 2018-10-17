package avaj.elements.weathertower;

import avaj.elements.flyable.Flyable;
import avaj.elements.aircraft.Coordinates;

import java.util.ArrayList;

public class Tower {

    private ArrayList <Flyable> observers = new ArrayList <Flyable> ();

    private void log(String message) {
        System.out.println("Tower says: " + message);
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
        log(flyable.identify() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        log(flyable.identify() + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        ArrayList <Flyable> tmpList = new ArrayList <Flyable> (observers);

        for (Flyable observer : tmpList) {
            observer.updateConditions();
        }

        tmpList.clear();
    }

}