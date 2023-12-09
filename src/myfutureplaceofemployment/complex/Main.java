/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.complex;

public class Main {
    public static void main(String[] args) {
        ComplexFactory factory = new ComplexFactory();

        System.out.println(factory.createComplex());
        System.out.println(factory.createComplex(5, 7));
    }
}
