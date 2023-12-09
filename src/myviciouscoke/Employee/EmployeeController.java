/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Employee;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

class EmployeeController {
    private final Employee model;
    private final EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public String getEmployeeName() {
        return model.getName();
    }

    public void setEmployeeName(String name) {
        model.setName(name);
    }

    public Long getEmployeeHours() {
        return model.getHours();
    }

    public void setEmployeeHours(Long hours) {
        model.setHours(hours);
    }

    public Double getBaseSalary() {
        return model.getBaseMonthlySalary();
    }

    public void setBaseSalary(Double baseSalary) {
        model.setBaseMonthlySalary(baseSalary);
    }

    public Double getActualSalary() {
        return model.getActualMonthlySalary();
    }

    public void setActualSalary(Double actualSalary) {
        model.setActualMonthlySalary(actualSalary);
    }

    @Contract(pure = true)
    private static int countSpaces(@NotNull String input) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                ++count;
            }
        }
        return count;
    }

    public static @NotNull ArrayList<Employee> retrieveEmployeeFromDataBase(String name) {
        name = name.trim().toLowerCase();

        int amountOfWordsInName = countSpaces(name) + 1;
        ArrayList<Employee> potentialEmployees = new ArrayList<>();

        // If only 1 word provided, search for matches in both first name & last name
        if (amountOfWordsInName == 1) {
            for (final var item : EmployeeDB.EMPLOYEE_DATA_BASE) {
                String[] parsedName = item.getName().toLowerCase().split(" ");
                if (parsedName[0].equals(name) || parsedName[1].equals(name)) {
                    potentialEmployees.add(item);
                }
            }
        } else if (amountOfWordsInName == 2) {
            for (final var item : EmployeeDB.EMPLOYEE_DATA_BASE) {
                if (name.equalsIgnoreCase(item.getName())) {
                    potentialEmployees.add(item);
                }
            }
        } else {
            System.err.println("CHECK AMOUNT OF WORDS IN NAME");
        }

        return potentialEmployees;
    }

    public void updateView() {
        model.calculateActualSalary();
        view.printEmployeeDetails(model);
        //System.err.println("EMPLOYEE DOES NOT EXIST -- VIEW HAS FAILED " + model.getName());
    }
}
