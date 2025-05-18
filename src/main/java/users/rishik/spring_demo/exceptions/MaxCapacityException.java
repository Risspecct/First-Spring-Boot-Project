package users.rishik.spring_demo.exceptions;

public class MaxCapacityException extends RuntimeException {
    public MaxCapacityException(String message) {
        super(message);
    }
}
