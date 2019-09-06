package by.tms.Userlist;

import java.util.Objects;

public class User {
    private String name;
    private String age;
    private String id;

    public User(String name, String age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Username: " + name + ", age: " + age + ", id: " + id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(age, user.age) &&
                Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }
}