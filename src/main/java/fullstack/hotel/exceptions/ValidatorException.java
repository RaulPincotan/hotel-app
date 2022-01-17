package fullstack.hotel.exceptions;

public class ValidatorException extends RuntimeException{
    public ValidatorException(String message) {
        super(message);
    }
}
