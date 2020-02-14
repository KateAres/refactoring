package ru.esphere.school;

import ru.esphere.school.service.Finder;
import ru.esphere.school.service.GroupsManager;
import ru.esphere.school.service.UserDataInput;

/**
 * Класс запуска приложения
 */
public class App {

    /**
     * метод main
     *
     * @param args массив строк
     */
    public static void main(String[] args) {
        new Finder()
                .findOldMembers(new GroupsManager().fillGroups("groups.txt", "members.txt"),
                        UserDataInput.inputData()).forEach(x -> System.out.println(x.toString()));
    }
}
