package avaj.exceptions;

public class InvalidWeatherException extends AvajException {

    public InvalidWeatherException() {
        super(
            "Invalid weather found."
        );
    }

}