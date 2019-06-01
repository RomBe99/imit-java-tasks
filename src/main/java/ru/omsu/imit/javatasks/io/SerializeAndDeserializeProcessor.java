package ru.omsu.imit.javatasks.io;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class SerializeAndDeserializeProcessor {
    public static void serializePerson(final OutputStream os, final Person personForSerialization) {
        try (final ObjectOutputStream OOS = new ObjectOutputStream(os)) {
            OOS.writeObject(personForSerialization);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person deserializePerson(final InputStream is) {
        try (final ObjectInputStream OIS = new ObjectInputStream(is)) {
            return (Person) OIS.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void serializeHouse(final OutputStream os, final House houseForSerialization) {
        try (final ObjectOutputStream OOS = new ObjectOutputStream(os)) {
            OOS.writeObject(houseForSerialization);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static House deserializeHouse(final InputStream is) {
        try (final ObjectInputStream OIS = new ObjectInputStream(is)) {
            return (House) OIS.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void serializeFlat(final OutputStream os, final Flat flatForSerialization) {
        try (final ObjectOutputStream OOS = new ObjectOutputStream(os)) {
            OOS.writeObject(flatForSerialization);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Flat deserializeFlat(final InputStream is) {
        try (final ObjectInputStream OIS = new ObjectInputStream(is)) {
            return (Flat) OIS.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String serializeHouseToJSON(final House houseForSerialization) {
        final ObjectMapper OM = new ObjectMapper();

        try {
            return OM.writeValueAsString(houseForSerialization);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static House deserializeHouseToJSON(final String JSONString) {
        final ObjectMapper OM = new ObjectMapper();

        try {
            return OM.readValue(JSONString, House.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}