/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package sortedrhapsody;

import org.jetbrains.annotations.NotNull;

class SortingStudentsByGPA {
    public static void main(String[] args) {
        Student[] GPAList = getGpaStudents();

        quickSort(GPAList, 0, GPAList.length - 1);

        for (var student : GPAList)
            System.out.println(student);
    }

    public static void quickSort(Student[] arr, Integer low, Integer high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(Student @NotNull [] arr, int low, int high) {
        double pivot = arr[high].getGPAScore(); // Choosing the last element as the pivot
        int i = low - 1;

        for (int j = low; j < high; ++j) {
            if (arr[j].getGPAScore() > pivot) {
                ++i;
                // Swap arr[i] and arr[j] directly
                var temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        var temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    @NotNull
    private static Student @NotNull [] getGpaStudents() { // Edit Students array here
        Student heisenberg = new Student("Walter White", 56789, 4.0);
        Student jessie = new Student("Jesse Pinkman", 12345, 2.5);
        Student finger = new Student("Michael Ehrmantraut", 98765, 3.5);
        Student gus = new Student("Gustavo Fring", 24680, 3.8);
        Student saul = new Student("Saul Goodman", 13579, 3.0);
        Student hank = new Student("Henry Schrader", 36912, 3.2);

        return new Student[]{heisenberg, jessie, finger, gus, saul, hank};
    }
}