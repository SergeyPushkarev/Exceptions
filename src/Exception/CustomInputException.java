package Exception;

public abstract class CustomInputException extends Exception {
    private String data;

    public CustomInputException(String message, String data) {
        super(message);
        this.data = data;
    }
}
