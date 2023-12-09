/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package weloveerasingclasses;

import java.util.Arrays;
import java.util.List;

class Converter {
    public static List<String> convert(String[] strings) {
        return Arrays.asList(strings);
    }

    public static List<Integer> convert(Integer[] strings) {
        return Arrays.asList(strings);
    }

    public static void main(String[] args) {
        String[] strings = {"Tkachenko ", " is ", " cool ", " dude ", " NGL"};
        var converted1 = convert(strings);

        System.out.println(converted1 instanceof List<String>);

        for (var item : converted1) {
            System.out.print(item + ' ');
        }

        System.out.println();

        Integer[] integers = {1, 2, 3, 4, 5, 6};
        var converted2 = convert(integers);

        System.out.println(converted2 instanceof List<Integer>);

        for (var item : converted2) {
            System.out.print(item);
        }
    }
}
