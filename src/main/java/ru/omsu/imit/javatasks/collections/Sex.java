package ru.omsu.imit.javatasks.collections;

public enum Sex {
    MALE("Male"), FEMALE("Female");
    private String value;

    Sex(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
