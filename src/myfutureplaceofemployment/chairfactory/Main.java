/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.chairfactory;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        ChairFactory chairFactory = new ChairFactory();

        FunctionalChair functionalChair = chairFactory.createFunctionalChair();
        MagicalChair magicalChair = chairFactory.createMagicalChair();
        VictorianChair victorianChair = chairFactory.createVictorianChair(60);

        System.out.println("FunctionalChair showcase:");
        client.setChair(functionalChair);
        client.sit();
        System.out.println(functionalChair.sum(2, 2));

        System.out.println("\nMagicalChair showcase:");
        client.setChair(magicalChair);
        client.sit();
        magicalChair.doMagic();

        System.out.println("\nVictorianChair showcase:");
        client.setChair(victorianChair);
        client.sit();
        System.out.println(victorianChair.getAge());
    }
}