package ru.mirea.prac6;

import java.util.Arrays;

public class Algorithm {

    public static Comparable[] buffer;

    public static void main(String[] args) {
        Comparable[] students = {
                new Student("Alex", 18),
                new Student("Max", 18),
                new Student("Barbara", 18),
                new Student("null", 19),
                new Student("Alex", 20),
                new Student("Alex", 20),
                new Student("No", 19)
        };
        sort(students);
        System.out.println(Arrays.toString(students));
    }

    public static void sort(Comparable[] array)
    {
        buffer = new Comparable[array.length]; // Память выделяется один раз.
        sort (array, 0, array.length -1);
    }

    private static void sort (Comparable [] array, int from, int to)
    {
        if (to <= from) return;
        int mid = from + (to - from) / 2;
        sort(array, from, mid);
        sort(array, mid + 1, to);
        merge(array, from, mid, to);
    }

    private static void merge (Comparable [] array, int from, int mid, int to)
    {
        int i = from, j = mid+1;
        if (to + 1 - from >= 0)
            System.arraycopy(array, from, buffer, from, to + 1 - from);
        for (int k = from; k <= to; k++)
            if (i > mid)
                array[k] = buffer[j++];
            else if (j > to )
                array[k] = buffer[i++];
            else if (buffer[j].compareTo(buffer[i]) < 0)
                array[k] = buffer[j++];
            else
                array[k] = buffer[i++];
    }

}