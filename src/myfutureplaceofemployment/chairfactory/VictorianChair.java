/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.chairfactory;

class VictorianChair implements IChair {
    private final int age;

    public VictorianChair(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
