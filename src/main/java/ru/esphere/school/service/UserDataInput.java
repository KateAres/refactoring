package ru.esphere.school.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Класс обработки вводимых пользователем данных
 */
public class UserDataInput {

    /**
     * инициализация логгера
     */
    private static final Logger log = Logger.getLogger(UserDataInput.class.getName());

    /**
     * Ввод положительного целочисленного значения пользователем
     *
     * @return Вводимое пользователем значение (int)
     */
    public static int inputData() {
        int output = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Type age: ");
            output = scanner.nextInt();
            if (output < 0) {
                log.warning("please, type positive integer");
                throw new IllegalArgumentException("please, type positive integer");
            }
        } catch (InputMismatchException e) {
            log.warning("please, type positive integer");
            throw new IllegalArgumentException("please, type positive integer");
        }
        return output;
    }
}
