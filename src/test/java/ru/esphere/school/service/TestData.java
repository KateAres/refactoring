package ru.esphere.school.service;

import ru.esphere.school.data.Member;
import ru.esphere.school.data.GroupOfMembers;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс генерации тестовых данных
 */
public class TestData {
    /**
     * Создание тестовых данных (списка групп) для тестового класса FinderTest
     */
    public static List<GroupOfMembers> generateGroups() {
        List<GroupOfMembers> groups = new ArrayList<>();
        groups.add(new GroupOfMembers("group1", groupOfMembers1()));
        groups.add(new GroupOfMembers("group2", groupOfMembers2()));
        return groups;
    }

    /**
     * Создание тестовых данных (Списка членов групп (Member) для 1й группы)
     */
    private static List<Member> groupOfMembers1() {
        List<Member> groupOfMembers = new ArrayList<>();
        groupOfMembers.add(new Member("Mary", 12, "beginner"));
        groupOfMembers.add(new Member("Harry", 43, "intermediate"));
        return groupOfMembers;
    }

    /**
     * Создание тестовых данных (Списка членов групп (Member) для 2й группы)
     */
    private static List<Member> groupOfMembers2() {
        List<Member> groupOfMembers = new ArrayList<>();
        groupOfMembers.add(new Member("Nina", 81, "pre-intermediate"));
        groupOfMembers.add(new Member("Tony", 25, "beginner"));
        return groupOfMembers;
    }
}
