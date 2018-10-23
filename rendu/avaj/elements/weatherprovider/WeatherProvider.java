package avaj.elements.weatherprovider;

import avaj.elements.aircraft.Coordinates;

public class WeatherProvider {

    public static final String      RAIN = "RAIN";
    public static final String      FOG  = "FOG";
    public static final String      SUN  = "SUN";
    public static final String      SNOW = "SNOW";

    private static WeatherProvider  weatherProvider = new WeatherProvider();
    private static final String []  weather = {
        RAIN,
        FOG,
        SUN,
        SNOW
    };

    private WeatherProvider() {};

    public static WeatherProvider getProvider() {
        return (weatherProvider);
    }

    // This could be static, but UML says otherwise
    public String getCurrentWeather(final Coordinates coordinates) {
        int seed = coordinates.getLongitude() + coordinates.getLatitude() - coordinates.getHeight();
        seed = seed / 5;
        seed = seed < 0 ? -seed : seed;

        return (weather[seed % 4]);
    }

}
