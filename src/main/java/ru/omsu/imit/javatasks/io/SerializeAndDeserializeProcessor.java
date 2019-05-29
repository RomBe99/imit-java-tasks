package ru.omsu.imit.javatasks.io;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class SerializeAndDeserializeProcessor {
    public static void serializePerson(final OutputStream os, final Person personForSerialization) {
        try (final ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(personForSerialization);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person deserializePerson(final InputStream is) {
        try (final ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void serializeHouse(final OutputStream os, final House houseForSerialization) {
        try (final ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(houseForSerialization);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static House deserializeHouse(final InputStream is) {
        try (final ObjectInputStream ois = new ObjectInputStream(is)) {
            return (House) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void serializeFlat(final OutputStream os, final Flat flatForSerialization) {
        try (final ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(flatForSerialization);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Flat deserializeFlat(final InputStream is) {
        try (final ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Flat) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void serializeHouseToJSON(final File pathToFile, final House houseForSerialization) {
        final ObjectMapper OM = new ObjectMapper();

        try {
            OM.writeValue(pathToFile, houseForSerialization);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static House deserializeHouseToJSON(final File pathToFile) {
        final ObjectMapper OM = new ObjectMapper();

        try {
            return OM.readValue(pathToFile, House.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}