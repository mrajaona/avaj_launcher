package avaj.elements.weathertower;

import avaj.elements.flyable.Flyable;
import avaj.elements.aircraft.Coordinates;

import avaj.simulator.OutputManager;

import java.util.ArrayList;

import avaj.exceptions.AvajException;
import java.io.IOException;

public class Tower {

    private ArrayList <Flyable> observers = new ArrayList <Flyable> ();

    private void log(final String message) throws AvajException, IOException {
        OutputManager.writeToFile("Tower says: " + message);
    }

    public void register(final Flyable flyable) throws AvajException, IOException {
        observers.add(flyable);
        log(flyable.identify() + " registered to weather tower.");
    }

    public void unregister(final Flyable flyable) throws AvajException, IOException {
        observers.remove(flyable);
        log(flyable.identify() + " unregistered from weather tower.");
    }

    protected void conditionsChanged() throws AvajException, IOException {
        if (observers.isEmpty()) {
            log("Nobody flying.");
            return ;
        }

        final ArrayList <Flyable> tmpList = new ArrayList <Flyable> (observers);

        for (Flyable observer : tmpList) {
            observer.updateConditions();
        }
    }

}