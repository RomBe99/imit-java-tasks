package ru.omsu.imit.javatasks.io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable {
    private int number;
    private int square;
    private List<Person> owners;

    public Flat(final int number, final int square, final List<Person> owners) {
        setNumber(number);
        setSquare(square);
        setOwners(owners);
    }

    public void setNumber(final int number) {
        this.number = number;
    }

    public void setSquare(final int square) {
        this.square = square;
    }

    public void setOwners(final List<Person> owners) {
        final int SIZE = owners.size();
        this.owners = new ArrayList<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            this.owners.add(i, owners.get(i));
        }
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