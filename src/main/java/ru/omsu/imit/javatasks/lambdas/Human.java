package ru.omsu.imit.javatasks.lambdas;

import java.util.Objects;

public class Human {
    private String surname;
    private String name;
    private String patronymic;
    private int age;
    private Gender gender;

    public Human(final String surname, final String name, final String patronymic, final int age, final Gender gender) {
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setAge(age);
        setGender(gender);
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(name, human.name) &&
                Objects.equals(patronymic, human.patronymic) &&
                gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, age, gender);
    }

    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
