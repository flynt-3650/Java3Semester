/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Employee;

import org.jetbrains.annotations.NotNull;

class EmployeeView {
    public void printEmployeeDetails(@NotNull Employee employee) {
        System.out.println("\nEMPLOYEE DETAILS\n" +
            "Name: " + employee.getName() + '\n' +
            "Hours: " + employee.getHours() + '\n' +
            "Base salary: " + employee.getBaseMonthlySalary() + '\n' +
            "Actual salary: " + employee.getActualMonthlySalary());
    }
}