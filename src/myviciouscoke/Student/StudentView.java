/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Student;

import org.jetbrains.annotations.NotNull;

class StudentView {
    public void printStudentDetails(@NotNull Student student) {
        System.out.println("STUDENT DETAILS\n"
            + "Name: " + student.getName() + '\n'
            + "Roll number: " + student.getRollNo());
    }
}
