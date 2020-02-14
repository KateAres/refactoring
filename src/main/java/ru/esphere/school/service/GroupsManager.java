package ru.esphere.school.service;

import ru.esphere.school.data.GroupOfMembers;
import ru.esphere.school.data.Member;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс распредения людей по группам
 */
public class GroupsManager {

    /**
     * Создание списка объектов класса GroupOfMembers с данными о членах группы
     *
     * @param groupsFilePath  путь до файла со списком групп
     * @param membersFilePath путь до файла со списком членов групп
     * @return список объектов класса GroupOfMembers
     */
    public List<GroupOfMembers> fillGroups(String groupsFilePath, String membersFilePath) {
        List<GroupOfMembers> filledGroups = new ArrayList<>();
        FileDataReader fileDataReader = new FileDataReader();
        List<Member> members = fileDataReader.collectMembers(membersFilePath);
        List<String> groupsList = fileDataReader.getDataFromFile(groupsFilePath);
        groupsList.forEach(x -> filledGroups.add((new GroupOfMembers(x, sortMembers(members, x)))));
        return filledGroups;
    }

    /**
     * Сортировка членов групп (объекты класса Member) по принадлежности к группе (groupName)
     *
     * @param members список членов групп (объекты класса Member)
     * @param groupName   имя группы
     * @return список членов групп (Member), содержащих заданный параметр groupName
     */
    private List<Member> sortMembers(List<Member> members, String groupName) {
        if (groupName != null) {
            return members.stream().filter(x -> x.getGroupName().equals(groupName)).collect(Collectors.toList());
        }
        return null;
    }
}
