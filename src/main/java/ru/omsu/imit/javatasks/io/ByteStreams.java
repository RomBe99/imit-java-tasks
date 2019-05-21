package ru.omsu.imit.javatasks.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

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

    public static int[] arrayIntsFromRandomAccessFile(final File fileForRead, final int initialBitShift) {
        try (RandomAccessFile raf = new RandomAccessFile(fileForRead, "r")) {
            raf.seek(initialBitShift);

            final int ARRAY_SIZE = (int) raf.length();
            int[] ints = new int[ARRAY_SIZE];

            for (int i = 0; i < ARRAY_SIZE; i++) {
                ints[i] = raf.readInt();
            }

            return ints;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new int[0];
    }
}