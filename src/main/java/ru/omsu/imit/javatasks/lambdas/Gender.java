package ru.omsu.imit.javatasks.lambdas;

public enum Gender {
    MALE("Male"), FEMALE("Female");
    private String value;

    Gender(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
