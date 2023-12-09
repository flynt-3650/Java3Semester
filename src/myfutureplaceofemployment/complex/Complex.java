/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.complex;

public class Complex {
    private final double real;
    private final double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex() {
        this.real = 0;
        imaginary = 0;
    }

    @Override
    public String toString() {
        return "n = " + real + " + " + imaginary +"i";
    }
}
