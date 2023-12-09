/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package dateandtimeiwillremember;

class Main {
    public static void main(String[] args) { // comment out / uncomment methods u want to use
        DT.receiveAndPassTask("Aiden Walker");
        DT.compareDate("2004-11-16"); // YYYY-MM-DD
        DT.createDateAndCalendar("2001-08-15-18-00"); // YYYY-MM-DD
        DT.timeComparison();

        Student student = new Student("Walter White", 123, "1958-09-07");
        System.out.println(student.getDateOfBirth('s'));
        System.out.println(student.getDateOfBirth('m'));
        System.out.println(student.getDateOfBirth('l'));


    }
}
