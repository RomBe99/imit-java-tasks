package ru.omsu.imit.javatasks.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreams {
    public static void arrayIntsToBinaryStream(final OutputStream os, final int[] ints) {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            for(int i : ints) {
                dos.writeInt(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] arrayIntsFromBinaryStream(final InputStream is, final int n) {
        int[] arr = new int[n];

        try(DataInputStream dis = new DataInputStream(is)) {
            for (int i = 0; i < n; i++) {
                arr[i] = dis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }
}