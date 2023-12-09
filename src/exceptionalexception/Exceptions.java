/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package exceptionalexception;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

class Exceptions {
    static class Exception1 {
        public void exceptionDemo() {
            try {
                System.out.println(-2D / 0D);
            } catch (ArithmeticException e) {
                System.out.println("ZERO DIV. ERROR");
            }
        }
    }

    static class Exception2 {
        public void exceptionDemo() {
            Scanner myScanner = new Scanner(System.in);
            System.out.print( "Enter an integer ");
            String intString = myScanner.next();

            try {
                int i = Integer.parseInt(intString);
                System.out.println(2 / i);
            } catch (NumberFormatException e) {
                System.out.println("NO STRINGS ALLOWED IN INPUT");
            } finally {
                myScanner.close();
            }
        }
    }

    static class ThrowsDemo {
        public void getDetails(String key) {
            if (key == null) {
                throw new NullPointerException("null key in getDetails" );
            }
            try {
                System.out.println(Arrays.toString(key.split(" ")));
            } catch (NullPointerException NPE) {
                System.out.println("DEREFERENCING NULLPTR");
            }
        }
    }

    static class ThrowsDemo1 {
        public void printMessage(String key) {
            try {
                String message = getDetails(key);
                System.out.println(message);
            } catch (NullPointerException e) {
                System.err.println("DEREFERENCING NULLPTR");
            }

        }

        public String getDetails(String key) {
            if (key == null) {
                throw new NullPointerException( "null key in getDetails" );
            }
            return "data for " + key;
        }
    }

    public static class ThrowsDemo2 {
        public void getKey() {
            Scanner myScanner = new Scanner(System.in);
            boolean validInput = false;

            while (!validInput) { // Цикл для дополнительных попыток ввода
                try {
                    System.out.println("Enter a key:");
                    String key = myScanner.next();
                    printDetails(key);
                    validInput = true; // Если дошли до этой строки, ввод считается правильным
                } catch (Exception e) {
                    System.out.println("Invalid input: " + e.getMessage());
                }
            }
        }

        public void printDetails(String key) throws Exception {
            String message = getDetails(key);
            System.out.println(message);
        }

        private @NotNull String getDetails(@NotNull String key) throws Exception {
            if (key.isEmpty()) {
                throw new Exception("Key set to empty string");
            }
            return "data for " + key;
        }
    }


    public static void main(String[] args) {
        var e1 = new Exception1();
        e1.exceptionDemo();

//        var e2 = new Exception2();
//        e2.exceptionDemo();

//        var demo = new ThrowsDemo();
//        demo.getDetails(null); // "Burger Cat"

//        var demo1 = new ThrowsDemo1();
//        demo1.printMessage("Burger Cat");
//        var demo2 = new ThrowsDemo2();
//        demo2.getKey();
    }
}