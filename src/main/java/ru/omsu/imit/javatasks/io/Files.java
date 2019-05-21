package ru.omsu.imit.javatasks.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Files {
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
