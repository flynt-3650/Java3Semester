/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Employee;

import java.util.ArrayList;

class EmployeeDemo {
    public static void main(String[] args) {
        EmployeeController controller;
        EmployeeView view = new EmployeeView();

        ArrayList<Employee> employees = EmployeeController.retrieveEmployeeFromDataBase(" John ");

        System.out.println(employees.size() + " employees were found");

        for (final var item : employees) {
            controller = new EmployeeController(item, view);
            controller.updateView();
        }
    }
}