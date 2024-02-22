package pro.sky.homework17.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework17.exception.WrongLoginException;
import pro.sky.homework17.exception.WrongPasswordException;

@RestController
public class LoginController {
    @GetMapping(path = "/login")
    public static void Login(@RequestParam("login") String login,
                             @RequestParam("password") String password,
                             @RequestParam("confirmPassword") String confirmPassword) {
        try {
            if (!login.matches("[a-zA-Z0-9_]+")) {
                throw new WrongLoginException("Логин содержит запрещённые символы", login);
            } else if (login.length() > 20) {
                throw new WrongLoginException("Логин слишком длинный", login);
            }
            if (!password.matches("[a-zA-Z0-9_]+"))
            {
                throw new WrongPasswordException("Пароль содержит запрещённые символы", password, confirmPassword);
            }
                else if (password.length() > 20) {
                throw new WrongPasswordException("Пароль слишком длинный", password, confirmPassword);
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают", password, confirmPassword);
            }
        } catch (WrongLoginException e) {
            e.printStackTrace();
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }
    }
}
