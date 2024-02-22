package pro.sky.homework17.exception;

public class WrongPasswordException extends RuntimeException {
    private String password;
    private String confirmPassword;
    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException(String message, String password, String confirmPassword) {
        super(message+" "+password+" "+confirmPassword);
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
