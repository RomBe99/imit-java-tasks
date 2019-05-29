package ru.omsu.imit.javatasks.io;

import java.util.List;
import java.util.Objects;

public class Flat {
    private int number;
    private int square;
    private List<Person> owners;

    public Flat(int number, int square, List<Person> owners) {
        setNumber(number);
        setSquare(square);
        setOwners(owners);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public void setOwners(List<Person> owners) {
        this.owners = owners;
    }

    public int getNumber() {
        return number;
    }

    public int getSquare() {
        return square;
    }

    public List<Person> getOwners() {
        return owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number &&
                square == flat.square &&
                Objects.equals(owners, flat.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, square, owners);
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", square=" + square +
                ", owners=" + owners +
                '}';
    }
}