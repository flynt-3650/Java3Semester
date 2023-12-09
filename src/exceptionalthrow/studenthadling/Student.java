/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package exceptionalthrow.studenthadling;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class Student implements Comparable<Student> {
    private String name;
    private Integer ID;
    private Double GPAScore;

    @Contract(pure = true)
    public Student(@NotNull String name, Integer ID, Double GPAScore) {
        this.name = name;
        this.ID = ID;
        this.GPAScore = GPAScore;
    }

    public Student(@NotNull String fullLegalName, Integer ID) { // In case u don't need GPA
        this.name = fullLegalName;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Double getGPAScore() {
        return GPAScore;
    }

    public void setGPAScore(Double GPAScore) {
        this.GPAScore = GPAScore;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", ID=" + ID +
            ", GPAScore=" + GPAScore +
            '}';
    }

    @Override
    public int compareTo(@NotNull Student other) {
        return this.GPAScore.compareTo(other.getGPAScore());
    }

    public int compareByID(@NotNull Student other) {
        return this.ID.compareTo(other.getID());
    }
}
