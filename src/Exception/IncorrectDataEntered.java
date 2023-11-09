package Exception;

public class IncorrectDataEntered extends CustomInputException{
    private String concreteData;

    public IncorrectDataEntered(String message, String data, String concreteData) {
        super(message, data);
        this.concreteData = concreteData;
    }
}
