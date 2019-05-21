package ru.omsu.imit.javatasks.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriterDemo {
    public static void arrayIntsToCharStream(final Writer w, final int[] ints) {
        try (BufferedWriter bw = new BufferedWriter(w)) {
            for (int i : ints) {
                bw.write(i + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] arrayIntsFromCharStream(final Reader r, final int intsCount) {
        int[] arr = new int[intsCount];

        try (BufferedReader br = new BufferedReader(r)) {
            for (int i = 0; i < intsCount; i++) {
                arr[i] = br.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }
}