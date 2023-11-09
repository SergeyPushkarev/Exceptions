package Exception;

public class IncorrectNumberOfDataEntered extends CustomInputException{
    public IncorrectNumberOfDataEntered(String message, String data) {
        super(message, data);
    }
}
