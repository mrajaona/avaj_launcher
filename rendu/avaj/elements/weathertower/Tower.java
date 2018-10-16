package avaj.elements.weathertower;

import avaj.elements.flyable.Flyable;
import avaj.elements.aircraft.Coordinates;

public class Tower {

    private Flyable observers;
    // private Flyable* observers;

    public void register(Flyable flyable) {

    }

    public void unregister(Flyable flyable) {
        // delete by id
    }

    protected void conditionsChanged() {
        // flyable.updateConditions();
    }

}