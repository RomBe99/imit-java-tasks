package ru.omsu.imit.javatasks.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Files {
    public static int[] arrayIntsFromRandomAccessFile(final File fileForRead, final long initialBitShift) {
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

    public static List<String> filesListWithSpecifiedExtension(final File catalogPath, String extension) {
        return Arrays.asList(Objects.requireNonNull(catalogPath.list((directory, name) -> name.endsWith(extension))));
    }
}