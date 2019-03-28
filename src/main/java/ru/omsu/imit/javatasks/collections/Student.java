package ru.omsu.imit.javatasks.collections;

import java.util.Objects;

public class Student extends Human {
    private String facultyName;

    public Student(final String surname, final String name, final String patronymic, final String facultyName) {
        super(surname, name, patronymic);
        setFacultyName(facultyName);
    }

    public void setFacultyName(final String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(facultyName, student.facultyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), facultyName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "facultyName='" + facultyName + '\'' +
                '}';
    }
}
