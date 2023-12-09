/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package stringparty;

class Person {
    private final String lastName;
    private final String firstNameInitial;
    private final String middleNameInitial;

    Person(String lastName, String firstNameInitial, String middleNameInitial) {
        this.lastName = lastName;
        this.firstNameInitial = firstNameInitial;
        this.middleNameInitial = middleNameInitial;
    }

    Person(String lastName) {
        this.lastName = lastName;
        this.middleNameInitial = null;
        this.firstNameInitial = null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstNameInitial='" + firstNameInitial + '\'' +
                ", middleNameInitial='" + middleNameInitial + '\'' +
                '}';
    }
}
