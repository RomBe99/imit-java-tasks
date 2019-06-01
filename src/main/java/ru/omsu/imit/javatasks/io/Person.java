package ru.omsu.imit.javatasks.io;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String surname;
    private String name;
    private String patronymic;
    private int day;
    private int month;
    private int year;

    public Person() {
        this("None", "None", "None", 0, 0, 0);
    }

    public Person(
            final String surname, final String name, final String patronymic,
            final int day, final int month, final int year
    ) {
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setDay(day);
        setMonth(month);
        setYear(year);
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

    public void setDay(final int day) {
        this.day = day;
    }

    public void setMonth(final int month) {
        this.month = month;
    }

    public void setYear(final int year) {
        this.year = year;
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

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getFullDate() {
        return day + "." + month + "." + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return day == person.day &&
                month == person.month &&
                year == person.year &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(name, person.name) &&
                Objects.equals(patronymic, person.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, day, month, year);
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}