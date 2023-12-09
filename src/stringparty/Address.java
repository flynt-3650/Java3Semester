/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package stringparty;

import org.jetbrains.annotations.NotNull;
import java.util.StringTokenizer;

class Address {
    private final String country;
    private final String region;
    private final String city;
    private final String street;
    private final String house;
    private final String building;
    private final String flat;

    public Address(@NotNull String address) {
        if (address.contains(",")) {
            StringTokenizer stringTokenizer = new StringTokenizer(address, ",");
            this.country = stringTokenizer.nextToken();
            this.region = stringTokenizer.nextToken();
            this.city = stringTokenizer.nextToken();
            this.street = stringTokenizer.nextToken();
            this.house = stringTokenizer.nextToken();
            this.building = stringTokenizer.nextToken();
            this.flat = stringTokenizer.nextToken();
        } else if (address.contains(".")) {
            StringTokenizer stringTokenizer = new StringTokenizer(address, ".");
            this.country = stringTokenizer.nextToken();
            this.region = stringTokenizer.nextToken();
            this.city = stringTokenizer.nextToken();
            this.street = stringTokenizer.nextToken();
            this.house = stringTokenizer.nextToken();
            this.building = stringTokenizer.nextToken();
            this.flat = stringTokenizer.nextToken();
        } else if (address.contains(";")) {
            StringTokenizer stringTokenizer = new StringTokenizer(address, ";");
            this.country = stringTokenizer.nextToken();
            this.region = stringTokenizer.nextToken();
            this.city = stringTokenizer.nextToken();
            this.street = stringTokenizer.nextToken();
            this.house = stringTokenizer.nextToken();
            this.building = stringTokenizer.nextToken();
            this.flat = stringTokenizer.nextToken();
        } else {
            this.country = null;
            this.region = null;
            this.city = null;
            this.street = null;
            this.house = null;
            this.building = null;
            this.flat = null;
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", building='" + building + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }
}
