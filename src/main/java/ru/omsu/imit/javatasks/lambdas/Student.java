package ru.omsu.imit.javatasks.lambdas;

import java.util.Objects;

public class Student extends Human {
    private String university;
    private String faculty;
    private String specialty;

    public Student(final String surname, final String name, final String patronymic, final int age, final Sex sex,
                   final String university, final String faculty, final String specialty) {
        super(surname, name, patronymic, age, sex);

        setUniversity(university);
        setFaculty(faculty);
        setSpecialty(specialty);
    }

    public void setUniversity(final String university) {
        this.university = university;
    }

    public void setFaculty(final String faculty) {
        this.faculty = faculty;
    }

    public void setSpecialty(final String specialty) {
        this.specialty = specialty;
    }

    public String getUniversity() {
        return university;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(university, student.university) &&
                Objects.equals(faculty, student.faculty) &&
                Objects.equals(specialty, student.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university, faculty, specialty);
    }

    @Override
    public String toString() {
        return "Student{" +
                "university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}