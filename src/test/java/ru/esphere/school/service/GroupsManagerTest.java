package ru.esphere.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.esphere.school.data.GroupOfMembers;

import java.util.List;

class GroupsManagerTest {

    @Test
    void fillGroupsShouldReturnGroupsWithDataFromFiles() {
        GroupsManager groupsManager = new GroupsManager();
        List<GroupOfMembers> expected = groupsManager.fillGroups("groups.txt", "members.txt");
        Assertions.assertTrue(expected.get(0).getMembers().get(1).getName().equals("Lisa"));
        Assertions.assertTrue(expected.get(0).getMembers().get(0).getName().equals("Mary"));
        Assertions.assertTrue(expected.get(1).getMembers().get(0).getName().equals("Lola"));
        Assertions.assertTrue(expected.get(1).getMembers().get(1).getName().equals("Petr"));
    }

    @Test
    void fillGroupsShouldReturnEmptyListWhenItGetsEmptyFiles() {
        GroupsManager groupsManager = new GroupsManager();
        List<GroupOfMembers> expected = groupsManager.fillGroups("empty.txt", "empty.txt");
        Assertions.assertTrue(expected.isEmpty());
    }

    @Test
    void fillGroupsShouldThrowIllegalArgumentExceptionWhenItGetsWrongFilePath() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GroupsManager groupsManager = new GroupsManager();
            groupsManager.fillGroups("nonExistent.txt", "nonExistent.txt");
        });
    }
}
