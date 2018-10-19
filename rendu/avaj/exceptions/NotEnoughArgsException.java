package avaj.exceptions;

public class NotEnoughArgsException extends AvajException {

    public NotEnoughArgsException() {
        super(
            "Missing argument."
        );
    }

}