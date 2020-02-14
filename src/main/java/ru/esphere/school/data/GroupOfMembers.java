package ru.esphere.school.data;

import java.util.List;

/**
 * Класс группы (GroupOfMembers) со свойствами groupName, members
 * (Изменено имя группы на GroupOfMembers для большей лексической точности)
 */
public class GroupOfMembers {
    private final String groupName;
    private final List<Member> members;

    /**
     * Конструктор класса GroupOfMembers
     *
     * @param groupName имя группы
     * @param members   список членов группы
     */
    public GroupOfMembers(String groupName, List<Member> members) {
        this.groupName = groupName;
        this.members = members;
    }

    /**
     * Getter переменной groupName
     *
     * @return имя группы
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Getter переменной members
     *
     * @return список членов группы
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * Переопределение toString()
     */
    @Override
    public String toString() {
        return "GroupOfMembers{" +
                "groupName='" + groupName + '\'' +
                ", members=" + members +
                '}';
    }
}
