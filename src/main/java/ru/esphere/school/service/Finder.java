package ru.esphere.school.service;

import ru.esphere.school.data.GroupOfMembers;
import ru.esphere.school.data.Member;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Класс поиска членов групп старше опеределённого возраста
 */
public class Finder {

    /**
     * Поиск групп людей старше определенного возраста.
     * for-loop (для groups) заменён на медод forEach() для итерации по коллекции groups
     * for-loop (для membersGroup.getMembers()) заменён на stream с сортировкой по условию и записью элементов в переменную groupsNames
     *
     * @param groups    группы
     * @param targetAge возраст для поиска
     * @return список имен групп из списка групп старше возраста targetAge
     */
    public Set<Member> findOldMembers(List<GroupOfMembers> groups, int targetAge) {
        Set<Member> groupsNames = new HashSet<>();
        groups.forEach(i -> i.getMembers().stream()
                .filter(x -> x.getAge() > targetAge)
                .forEach(groupsNames::add));
        return groupsNames;
    }
}
