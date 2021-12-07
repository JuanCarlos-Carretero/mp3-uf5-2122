package a2;

public class BankAccountException extends Exception{
    public static final String ACCOUNT_NOT_FOUND = "Cuenta inexistente";
    public static final String ACCOUNT_OVERDRAFT = "Cuenta al descubierto";
    public static final String ACCOUNT_ZERO_USER = "Cuenta sin usuario";
}