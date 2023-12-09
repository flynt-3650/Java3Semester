/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package exceptionalthrow.studenthadling;

import exceptionalthrow.studenthadling.StudentExceptions.EmptyStringException;
import exceptionalthrow.studenthadling.StudentExceptions.StudentNotFoundException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

class StudentController {
    private final Student model;

    public StudentController(Student model) {
        this.model = model;
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentName(String newName) {
        model.setName(newName);
    }

    public Integer getStudentID() {
        return model.getID();
    }

    public void setStudentID(Integer newID) {
        model.setID(newID);
    }

    public Double getStudentGPAScore() {
        return model.getGPAScore();
    }

    public void setStudentGPAScore(Double newGPAScore) {
        model.setGPAScore(newGPAScore);
    }

    @Contract(pure = true)
    private static int countSpaces(@NotNull String input) {
        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == ' ')
                ++count;
        }

        return count;
    }

    public static @NotNull ArrayList<Student> retrieveStudentsByName(@NotNull String name) throws EmptyStringException, StudentNotFoundException {
        if (name.isEmpty()) {
            throw new EmptyStringException("Empty name");
        }

        name = name.trim().toLowerCase();

        int amountOfWordsInName = countSpaces(name) + 1;
        ArrayList<Student> potentialStudents = new ArrayList<>();

        if (amountOfWordsInName == 1) {
            for (final var student : StudentDataBase.getStudentDataBase()) {
                String[] parsedName = student.getName().toLowerCase().split(" ");
                if (parsedName[0].equals(name) || parsedName[1].equals(name)) {
                    potentialStudents.add(student);
                }
            }
        } else if (amountOfWordsInName == 2) {
            for (final var student : StudentDataBase.getStudentDataBase()) {
                if (name.equalsIgnoreCase(student.getName())) {
                    potentialStudents.add(student);
                }
            }
        } else {
            throw new StudentNotFoundException("Student not found.");
        }

        return potentialStudents;
    }

    @Contract("_ -> param1")
    public static @NotNull ArrayList<Student> sortByGPA(ArrayList<Student> studentGPAList) {
        quickSort(studentGPAList, 0, studentGPAList.size() - 1);
        return studentGPAList;
    }

    private static void quickSort(ArrayList<Student> arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(@NotNull ArrayList<Student> arr, int low, int high) {
        double pivot = arr.get(high).getGPAScore(); // Choosing the last element as the pivot
        int i = low - 1;

        for (int j = low; j < high; ++j) {
            if (arr.get(j).getGPAScore() > pivot) {
                ++i;
                // Swap arr[i] and arr[j] directly
                Student temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        Student temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    @Contract("_ -> param1")
    public static @NotNull ArrayList<Student> sortByID(@NotNull ArrayList<Student> students) {
        selectionSort(students);
        return students;
    }

    private static void selectionSort(@NotNull ArrayList<Student> students) {
        int size = students.size();
        for (int i = 0; i < size - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < size; ++j) {
                if (students.get(j).compareByID(students.get(minIndex)) < 0)
                    minIndex = j;
            }
            var temp = students.get(i);
            students.set(i, students.get(minIndex));
            students.set(minIndex, temp);
        }
    }
}
