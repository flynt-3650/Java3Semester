/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package exceptionalthrow.itin;

import org.jetbrains.annotations.NotNull;

class ITINChecker {
    public static boolean checkITIN(@NotNull String query) throws InvalidITINException {

        int size = query.length();

        if (size != 12 && size != 10)
            throw new InvalidITINException("Invalid Size");

        int partialSum = (
            Character.getNumericValue(query.charAt(0)) * 2 +
            Character.getNumericValue(query.charAt(1)) * 4 +
            Character.getNumericValue(query.charAt(2)) * 10 +
            Character.getNumericValue(query.charAt(3)) * 3 +
            Character.getNumericValue(query.charAt(4)) * 5 +
            Character.getNumericValue(query.charAt(5)) * 9 +
            Character.getNumericValue(query.charAt(6)) * 4 +
            Character.getNumericValue(query.charAt(7)) * 6 +
            Character.getNumericValue(query.charAt(8)) * 8);

        int divided = partialSum / 11 * 11;

        if (((partialSum - divided) % 10) == Character.getNumericValue(query.charAt(size - 1)))
            return true;
        else
            throw new InvalidITINException("Wrong INN");
    }

    public static void main(String[] args) {
        try {
            //System.out.println(checkITIN("7713456564"));
            System.out.println(checkITIN("7707083893"));
        } catch (InvalidITINException e) {
            System.err.println(e.getMessage());
        }
    }
}
