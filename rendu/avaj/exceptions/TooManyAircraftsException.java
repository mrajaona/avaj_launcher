package avaj.exceptions;

public class TooManyAircraftsException extends AvajException {

    public TooManyAircraftsException() {
        super(
            "Too many aircrafts created."
        );
    }

}