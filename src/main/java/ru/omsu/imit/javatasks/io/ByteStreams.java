package ru.omsu.imit.javatasks.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteStreams {
    public static byte[] intArrayToByteArray(final int[] arrayForWrite) {
        byte[] bytes = new byte[arrayForWrite.length];

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            for (int i : arrayForWrite) {
                baos.write(i);
            }

            bytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

    public static int[] byteArrayToIntArray(final byte[] arrayForRead) {
        final int SIZE = arrayForRead.length;
        int[] ints = new int[SIZE];

        try (ByteArrayInputStream bais = new ByteArrayInputStream(arrayForRead)) {
            for (int i = 0; i < SIZE; i++) {
                ints[i] = bais.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ints;
    }
}
