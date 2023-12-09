/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package sortedrhapsody;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;

class MergingStudents {
    public static void main(String[] args) {
        Student heisenberg = new Student("Walter White", 56789, 4.0);
        Student jessie = new Student("Jesse Pinkman", 12345, 2.5);
        Student finger = new Student("Michael Ehrmantraut", 98765, 3.5);
        Student gus = new Student("Gustavo Fring", 24680, 3.8);
        Student saul = new Student("Saul Goodman", 13579, 3.0);
        Student hank = new Student("Henry Schrader", 36912, 3.2);

        Student[] GPAList1 = new Student[]{heisenberg, jessie, finger};
        Student[] GPAList2 = new Student[]{gus, saul, hank};

        Student[] mergedAndSorted = mergeAndSort(GPAList1, GPAList2);

        for (final var student : mergedAndSorted)
            System.out.println(student);

    }

    public static Student @NotNull [] mergeAndSort(Student @NotNull [] list1, Student @NotNull [] list2) {
        // Merge the two arrays into a single array
        Student[] mergedList = new Student[list1.length + list2.length];
        System.arraycopy(list1, 0, mergedList, 0, list1.length);
        System.arraycopy(list2, 0, mergedList, list1.length, list2.length);

        // Sort the merged array using merge sort
        return mergeSort(mergedList);
    }

    public static Student @NotNull [] mergeSort(Student @NotNull [] arr) {
        int length = arr.length;

        if (length <= 1)
            return arr; // Base case: already sorted

        // Split the array into two halves
        int mid = length / 2;
        Student[] left = Arrays.copyOfRange(arr, 0, mid);
        Student[] right = Arrays.copyOfRange(arr, mid, length);

        // Recursively sort each half
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    @Contract(pure = true)
    public static Student @NotNull [] merge(Student @NotNull [] left, Student @NotNull [] right) {
        int totalLength = left.length + right.length;
        Student[] result = new Student[totalLength];

        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) >= 0)
                result[resultIndex++] = left[leftIndex++];
            else
                result[resultIndex++] = right[rightIndex++];

        }

        // Copy remaining elements from left and right subarrays, if any
        while (leftIndex < left.length)
            result[resultIndex++] = left[leftIndex++];

        while (rightIndex < right.length)
            result[resultIndex++] = right[rightIndex++];

        return result;
    }
}
