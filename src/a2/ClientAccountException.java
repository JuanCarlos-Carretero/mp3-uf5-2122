package a2;

public class ClientAccountException extends Exception{

    //CLIENT MESSAGES
    public static final String WRONG_DNI = "DNI incorrecto";

    public ClientAccountException(String msg) {
        super(msg);
    }
}
