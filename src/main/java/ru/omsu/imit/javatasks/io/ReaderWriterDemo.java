package ru.omsu.imit.javatasks.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderWriterDemo {
    public static void intArrayToFile(final int[] arrayForWrite, final File fileForWrite) {
        try (Writer bw = new BufferedWriter(new FileWriter(fileForWrite))) {
            for (int i : arrayForWrite) {
                bw.append(String.valueOf(i)).append(String.valueOf(' '));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] intArrayFromFile(final File fileForRead) {
        List<Integer> temp = new ArrayList<>();

        try (Scanner s = new Scanner(fileForRead)) {
            while (s.hasNext()) {
                temp.add(s.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int[] endArray = new int[temp.size()];

        if (temp.isEmpty()) {
            return endArray;
        }

        for (int i = 0; i < temp.size(); i++) {
            endArray[i] = temp.get(i);
        }

        return endArray;
    }
}