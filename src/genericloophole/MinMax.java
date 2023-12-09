/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package genericloophole;

class MinMax<E extends Comparable<E>> {
    private final E[] arr;

    public MinMax(E[] arr) {
        this.arr = arr;
    }

    public E getMin() throws Exception {
        int n = arr.length;

        if (n == 0) {
            throw new Exception("EMPTY ARRAY");
        }

        E min = arr[0];
        for (E e : arr) {

            if (e.compareTo(min) < 0)
                min = e;

        }
        return min;
    }

    public E getMax() throws Exception {
        int n = arr.length;

        if (n == 0) {
            throw new Exception("EMPTY ARRAY");
        }

        E max = arr[0];
        for (E e : arr) {

            if (e.compareTo(max) > 0)
                max = e;

        }
        return max;
    }
}
