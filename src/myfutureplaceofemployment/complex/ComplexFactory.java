/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.complex;

public class ComplexFactory {
    Complex createComplex() {
        return new Complex();
    }

    Complex createComplex(double r, double i) {
        return new Complex(r, i);
    }
}
