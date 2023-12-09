/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.chairfactory;

class ChairFactory implements IAbstractChairFactory {
    @Override
    public VictorianChair createVictorianChair(int age) {
        return new VictorianChair(age);
    }

    @Override
    public MagicalChair createMagicalChair() {
        return new MagicalChair();
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }
}
