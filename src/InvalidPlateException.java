package exceptions;

public class InvalidPlateException extends RuntimeException {
    public InvalidPlateException() {
        super("Invalid vehicle plate");
    }
}
