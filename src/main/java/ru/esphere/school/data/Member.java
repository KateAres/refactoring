package ru.esphere.school.data;

/**
 * Класс члена группы (Member) со свойствами name, age, group
 */
public class Member {

    /**
     * Добавлено поле group для последующей сортировки членов группы по группам
     */
    private final String name;
    private final Integer age;
    private final String groupName;

    /**
     * Конструктор класса Member
     *
     * @param name имя члена группы
     * @param age   список членов группы
     * @param groupName имя группы
     */
    public Member(String name, Integer age, String groupName) {
        this.name = name;
        this.age = age;
        this.groupName = groupName;
    }

    /**
     * Getter переменной name
     *
     * @return имя члена группы
     */
    public String getName() {
        return name;
    }

    /**
     * Getter переменной age
     *
     * @return возраст члена группы
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Getter переменной group
     *
     * @return принадлежность к группе (имя группы)
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Переопределение toString()
     */
    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +'\'' +
                ", group=" + groupName +
                '}';
    }

    /**
     * Переопределение equals()
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
            Member member = (Member) obj;
            return age == member.age && (name == member.name ||
                    (name != null && name.equals(member.getName())))
                    && (groupName == member.name ||
                    (groupName != null && groupName.equals(member.getName())));
        }

    /**
     * Переопределение hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
        result = prime * result + age;
        return result;
    }
}

