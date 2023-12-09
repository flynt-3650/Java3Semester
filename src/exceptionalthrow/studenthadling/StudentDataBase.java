/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package exceptionalthrow.studenthadling;

import java.util.Arrays;
import java.util.ArrayList;

class StudentDataBase {
    private static final ArrayList<Student> STUDENT_DATA_BASE = new ArrayList<>(Arrays.asList(
        new Student("Walter White", 56789, 4.0),
        new Student("Jesse Pinkman", 12345, 2.7),
        new Student("Michael Ehrmantraut", 98765, 3.8),
        new Student("Gustavo Fring", 24680, 4.0),
        new Student("James McGill", 13579, 3.5),
        new Student("Hank Schrader", 36912, 3.6),
        new Student("Skyler White", 11111, 2.5),
        new Student("Marie Schrader", 22222, 3.0),
        new Student("Hector Salamanca", 33333, 2.5),
        new Student("Tuco Salamanca", 44444, 2.9),
        new Student("Kim Wexler", 55555, 3.7),
        new Student("Chuck McGill", 66666, 3.3),
        new Student("Howard Hamlin", 77777, 3.1),
        new Student("Nacho Varga", 88888, 3.0),
        new Student("Lalo Salamanca", 99999, 3.6)
    ));

    public static ArrayList<Student> getStudentDataBase() {
        return STUDENT_DATA_BASE;
    }
}
