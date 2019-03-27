package ru.omsu.imit.javatasks.collections;

import java.util.Objects;

public class Student extends Human {
    private String facultyТame;

    public Student(final String surname, final String name, final String patronymic, final String facultyТame) {
        super(surname, name, patronymic);
        setFacultyТame(facultyТame);
    }

    public void setFacultyТame(final String facultyТame) {
        this.facultyТame = facultyТame;
    }

    public String getFacultyТame() {
        return facultyТame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(facultyТame, student.facultyТame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), facultyТame);
    }

    @Override
    public String toString() {
        return "Student{" +
                "facultyТame='" + facultyТame + '\'' +
                '}';
    }
}
