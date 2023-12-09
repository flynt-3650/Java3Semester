/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package stringparty;

import java.util.StringTokenizer;

class Shirt {
    private final String ID;
    private final String name;
    private final String color;
    private final String size;

    public Shirt(String data) {
        StringTokenizer stringTokenizer = new StringTokenizer(data, ",");
        this.ID = stringTokenizer.nextToken();
        this.name = stringTokenizer.nextToken();
        this.color = stringTokenizer.nextToken();
        this.size = stringTokenizer.nextToken();
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
