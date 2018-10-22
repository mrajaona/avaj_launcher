package avaj.elements.aircraft;

public class Coordinates {
    
    static final int COORD_MIN  = 0;
    static final int COORD_MAX  = 100;

    private int longitude;
    private int latitude;
    private int height;

    private int checkCoord(int value) {
        return (value > COORD_MIN ? value : COORD_MIN);
    }

    private int checkHeight(int value) {
        if (value < COORD_MIN)
            value = COORD_MIN;
        else if (value > COORD_MAX)
            value = COORD_MAX;

        return (value);
    }

    private Coordinates() {}

    // Initialized by AircraftFactory
    Coordinates(int lo, int la, int he) {
        longitude   = checkCoord(lo);
        latitude    = checkCoord(la);
        height      = checkHeight(he);
    }

    public int getLongitude() {
        return (longitude);
    }

    public void editLongitude(int modifier) {
        longitude = checkCoord(longitude + modifier);
    }

    public int getLatitude() {
        return (latitude);
    }

    public void editLatitude(int modifier) {
        latitude = checkCoord(latitude + modifier);
    }

    public int getHeight() {
        return (height);
    }

    public void editHeight(int modifier) {
        height = checkHeight(height + modifier);
    }

}