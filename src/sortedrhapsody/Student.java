/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package sortedrhapsody;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;

class Student implements Comparable<Student> {
    private String[] fullLegalName;
    private Integer ID;
    private Double GPAScore;

    @Contract(pure = true)
    public Student(@NotNull String fullLegalName, Integer ID, Double GPAScore) {
        this.fullLegalName = fullLegalName.split(" ");
        this.ID = ID;
        this.GPAScore = GPAScore;
    }
    
    public Student(@NotNull String fullLegalName, Integer ID) { // in case u don't need GPA
        this.fullLegalName = fullLegalName.split(" ");
        this.ID = ID;
    }

    public String[] getFullLegalName() {
        return fullLegalName;
    }
    public void setFullLegalName(@NotNull String fullLegalName) {
        this.fullLegalName = fullLegalName.split(" ");
    }
    public void setFirstName(String firstName) {
        fullLegalName[0] = firstName;
    }
    public void setSurname(String surname) {
        fullLegalName[1] = surname;
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
        return "GPAStudent{" +
                "name=" + Arrays.toString(fullLegalName) +
                ", ID=" + ID +
                ", GPAScore=" + GPAScore +
                '}';
    }

    @Override
    public int compareTo(@NotNull Student other) {
        return this.GPAScore.compareTo(other.getGPAScore());
    }

}
