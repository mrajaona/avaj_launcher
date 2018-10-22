package avaj.exceptions;

public class InvalidRunNumberException extends AvajException {

    public InvalidRunNumberException() {
        super(
            "Invalid number of times to run the simulation."
        );
    }

}
