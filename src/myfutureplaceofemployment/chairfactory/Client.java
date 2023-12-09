/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myfutureplaceofemployment.chairfactory;

class Client {
    public IChair chair;

    public void sit() {
        System.out.println("Sitting on " + chair.getClass());
    }

    public void setChair(IChair chair) {
        this.chair = chair;
    }
}
