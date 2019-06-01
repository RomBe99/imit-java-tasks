package ru.omsu.imit.javatasks.io;

import java.io.*;

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
            final String[] temp = br.readLine().split(" ");

            for (int i = 0; i < intsCount; i++) {
                arr[i] = Integer.parseInt(temp[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }
}