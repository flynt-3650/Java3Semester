/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Student;

import org.jetbrains.annotations.NotNull;

class MVCPatternDemo {
    public static void main(String[] args) {
        Student model = retrieveStudentFromDataBase();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
    }
    public static @NotNull Student retrieveStudentFromDataBase() {
        Student student = new Student();
        student.setName("Walter White");
        student.setRollNo("SEP071958");
        return student;
    }
}
