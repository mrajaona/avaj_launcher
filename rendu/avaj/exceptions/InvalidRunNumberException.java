package avaj.exceptions;

public class InvalidRunNumberException extends AvajException {

    public InvalidRunNumberException() {
        super(
            "Invalid numer of times to run the simulation."
        );
    }

}
