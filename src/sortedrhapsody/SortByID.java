/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package sortedrhapsody;

import org.jetbrains.annotations.NotNull;

class SortByID {
    public static void main(String[] args) {
        Student[] IDNumber = getGpaStudents();

        int size = IDNumber.length;
        for (int i = 0; i < size - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < size; ++j) {
                if (IDNumber[j].compareTo(IDNumber[minIndex]) < 0)
                    minIndex = j;
            }
            var temp = IDNumber[i];
            IDNumber[i] = IDNumber[minIndex];
            IDNumber[minIndex] = temp;
        }

        for (final var item : IDNumber)
            System.out.println(item);

    }

    @NotNull
    private static Student @NotNull [] getGpaStudents() {
        Student heisenberg = new Student("Walter White", 56789);
        Student jessie = new Student("Jesse Bruce Pinkman", 12345);
        Student finger = new Student("Michael Ehrmantraut", 98765);
        Student gus = new Student("Gustavo Fring", 24680);
        Student saul = new Student("Saul Goodman", 13579);
        Student hank = new Student("Henry Schrader", 36912);

        return new Student[]{heisenberg, jessie, finger, gus, saul, hank};
    }
}