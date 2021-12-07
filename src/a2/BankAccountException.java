package a2;

public class BankAccountException extends Exception{
    //BANK ACCOUNT MESSAGES
    public static final String ACCOUNT_NOT_FOUND = "Cuenta inexistente";
    public static final String ACCOUNT_OVERDRAFT = "Cuenta al descubierto";
    public static final String ACCOUNT_ZERO_USER = "Cuenta sin usuario";
    public static final String ACCOUNT_1_USER = "Cuenta solo con 1 usuario";

    public BankAccountException(String msg) {
        super(msg);
    }
}
