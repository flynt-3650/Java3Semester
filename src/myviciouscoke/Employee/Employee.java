/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Employee;

class Employee {
    private String name;
    private Long hours;
    private Double baseMonthlySalary;
    private Double actualMonthlySalary;

    public Employee(String name, Long hours, Double baseMonthlySalary) {
        this.name = name;
        this.hours = hours;
        this.baseMonthlySalary = baseMonthlySalary;
        calculateActualSalary();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHours() {
        return hours;
    }

    public void setHours(Long hours) {
        this.hours = hours;
    }

    public Double getBaseMonthlySalary() {
        return baseMonthlySalary;
    }

    public void setBaseMonthlySalary(Double baseMonthlySalary) {
        this.baseMonthlySalary = baseMonthlySalary;
    }

    public Double getActualMonthlySalary() {
        return actualMonthlySalary;
    }

    public void setActualMonthlySalary(Double actualMonthlySalary) {
        this.actualMonthlySalary = actualMonthlySalary;
    }

    public void calculateActualSalary() {
        actualMonthlySalary = hours * (baseMonthlySalary / 160L);
    }
}
