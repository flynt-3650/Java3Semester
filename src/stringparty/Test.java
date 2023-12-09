/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package stringparty;

import org.jetbrains.annotations.NotNull;

class Test {
    public static void genericOperations(@NotNull String s) {
        System.out.println(s.charAt(s.length() - 1));

        if (s.endsWith("!!!"))
            System.out.println("'!!!' found");
        else
            System.out.println("'!!!' not found");

        if (s.startsWith("I like"))
            System.out.println("'I like' found");
        else
            System.out.println("'I like' not found");

        if (s.contains("Java"))
            System.out.println("'Java' found");
        else
            System.out.println("'Java' not found");

        System.out.println("'Java' starts from index " + s.indexOf("Java"));

        System.out.println(s.replace('a', 'o'));

        System.out.println(s.toUpperCase());

        System.out.println(s.toLowerCase());

        System.out.println(s.substring(s.indexOf("Java")));
    }

    public static @NotNull String formatPhoneNumber(@NotNull String number) {
        if (number.contains("+"))
            number = number.replace("+", "");

        return "+" + number.substring(0, 4) + "-" + number.substring(4, 7) + "-" + number.substring(7, 11);
    }

    public static void main(String[] args) {
        System.out.println("TASK No.1");
        genericOperations("I like Java!!!");

        System.out.println("\nTASK No.2");
        System.out.println(new Person("White", "W.", "H."));

        System.out.println("\nTASK No.3");
        System.out.println(new Address("Russia,Moscow,Moscow,Prospect Vernadskogo,78,1,I-204-V"));
        System.out.println(new Address("USA;New Mexico;Albuquerque;Negra Aroya Lane;308;1;0"));

        System.out.println("\nTASK No.4");
        String[] shirts = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };
        Shirt[] shirts1 = new Shirt[11];

        for (int i = 0; i < shirts1.length; ++i)
            shirts1[i] = new Shirt(shirts[i]);

        for (final var item : shirts1)
            System.out.println(item);

        System.out.println("\nTASK No.5");
        System.out.println(formatPhoneNumber("+79175655655"));
        System.out.println(formatPhoneNumber("89175655655"));

        System.out.println("\nTASK No.6");
    }
}
