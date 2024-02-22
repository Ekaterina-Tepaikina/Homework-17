package pro.sky.homework17.exception;

public class WrongLoginException extends RuntimeException {
    private String login;
    public WrongLoginException(String message) {
        super(message);
    }

    public WrongLoginException(String message, String login) {
        super(message+" "+login);
        this.login = login;
    }
}
