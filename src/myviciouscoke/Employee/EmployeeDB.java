/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Employee;

import java.util.ArrayList;
import java.util.Arrays;

class EmployeeDB {
    static final ArrayList<Employee> EMPLOYEE_DATA_BASE = new ArrayList<>(Arrays.asList(
        new Employee("Aiden Walker", 160L, 1250D),
        new Employee("John Doe", 150L, 1350D),
        new Employee("John New", 150L, 1350D),
        new Employee("Jane Smith", 140L, 1450D),
        new Employee("John Pork", 200L, 1250D)
    ));
}
