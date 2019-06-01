package ru.omsu.imit.javatasks.io;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    private String cadastralHouseNumber;
    private String address;
    private Person seniorHousework;
    private List<Flat> flats;

    public House(
            final String cadastralHouseNumber, final String address,
            final Person seniorHousework, final List<Flat> flats) {
        setCadastralHouseNumber(cadastralHouseNumber);
        setAddress(address);
        setSeniorHousework(seniorHousework);
        setFlats(flats);
    }

    public void setCadastralHouseNumber(final String cadastralHouseNumber) {
        this.cadastralHouseNumber = cadastralHouseNumber;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setSeniorHousework(final Person seniorHousework) {
        this.seniorHousework = seniorHousework;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

    public String getCadastralHouseNumber() {
        return cadastralHouseNumber;
    }

    public String getAddress() {
        return address;
    }

    public Person getSeniorHousework() {
        return seniorHousework;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(cadastralHouseNumber, house.cadastralHouseNumber) &&
                Objects.equals(address, house.address) &&
                Objects.equals(seniorHousework, house.seniorHousework) &&
                Objects.equals(flats, house.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadastralHouseNumber, address, seniorHousework, flats);
    }

    @Override
    public String toString() {
        return "House{" +
                "cadastralHouseNumber='" + cadastralHouseNumber + '\'' +
                ", address='" + address + '\'' +
                ", seniorHousework=" + seniorHousework +
                ", flats=" + flats +
                '}';
    }
}