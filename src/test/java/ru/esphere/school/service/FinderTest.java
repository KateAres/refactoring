package ru.esphere.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.esphere.school.data.Member;

import java.util.Set;

class FinderTest {

    @Test
    void findOldMembersShouldReturnMembersOlderThenGivenAge() {
        Finder finder = new Finder();
        Set<Member> members = finder.findOldMembers(TestData.generateGroups(), 30);
        Assertions.assertTrue(members.stream().anyMatch(x -> x.getName().equals("Harry")));
        Assertions.assertTrue(members.stream().anyMatch(x -> x.getName().equals("Nina")));
    }

    @Test
    void findOldMembersShouldReturnEmptySetWhenNoMembersFound() {
        Finder finder = new Finder();
        Set<Member> members = finder.findOldMembers(TestData.generateGroups(), 100);
        Assertions.assertTrue(members.isEmpty());
    }

    @Test
    void findOldMembersShouldReturnAllMembersWhenGivenNegativeAge() {
        Finder finder = new Finder();
        Set<Member> members = finder.findOldMembers(TestData.generateGroups(), -23);
        Assertions.assertTrue(members.stream().anyMatch(x -> x.getName().equals("Mary")));
        Assertions.assertTrue(members.stream().anyMatch(x -> x.getName().equals("Tony")));
        Assertions.assertTrue(members.stream().anyMatch(x -> x.getName().equals("Nina")));
        Assertions.assertTrue(members.stream().anyMatch(x -> x.getName().equals("Harry")));
    }
}
