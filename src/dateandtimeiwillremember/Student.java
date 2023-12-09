/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package dateandtimeiwillremember;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

class Student {
    private String[] fullLegalName;
    private Integer ID;
    private final Date dateOfBirth;

    public Student(@NotNull String fullLegalName, Integer ID, String dateOfBirth) {
        this.fullLegalName = fullLegalName.split(" ");
        this.ID = ID;
        this.dateOfBirth = parseDateOfBirth(dateOfBirth);
    }

    public String[] getFullLegalName() {
        return fullLegalName;
    }
    public void setFullLegalName(@NotNull String name) {
        this.fullLegalName = name.split(" ");
    }
    public void setFirstName(String firstName) {
        fullLegalName[0] = firstName;
    }
    public void setLastName(String lastName) {
        fullLegalName[1] = lastName;
    }

    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }

    private @NotNull String formatDay(@NotNull String day) {
        if (day.charAt(day.length() - 1) == '1')
            return day + "st";
        else if (day.charAt(day.length() - 1) == '2')
            return day + "nd";
        else if (day.charAt(day.length() - 1) == '3')
            return day + "rd";
        else
            return day + "th";
    }

    private @Nullable Date parseDateOfBirth(String dateOfBirthString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // You can adjust the date format as needed
        try {
            return dateFormat.parse(dateOfBirthString);
        } catch (Exception e) {
            return null; // Handle parsing errors gracefully
        }
    }

    // Format date of birth based on the input format ('s', 'm', or 'l')
    public String getDateOfBirth(char format) {
        if (dateOfBirth == null)
            return null; // Handle case where date of birth is not set

        SimpleDateFormat dateFormat = null;

        if (format == 's' || format == 'S')
            dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        else if (format == 'm' || format == 'M')
            dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        else if (format == 'l' || format == 'L')
            dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

        if (dateFormat == null)
            return null; // Invalid format

        return dateFormat.format(dateOfBirth);
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullLegalName=" + Arrays.toString(fullLegalName) +
                ", ID=" + ID +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
