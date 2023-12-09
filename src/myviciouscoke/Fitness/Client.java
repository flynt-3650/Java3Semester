/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Fitness;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Client {
    private String name;
    private Integer age;
    private LocalDate cardExpirationDate;

    public Client(String name, Integer age, String cardExpirationDateStr) {
        this.name = name;
        this.age = age;
        this.cardExpirationDate = LocalDate.parse(cardExpirationDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDateStr) {
        this.cardExpirationDate = LocalDate.parse(cardExpirationDateStr, DateTimeFormatter.ofPattern("yyyy-MMMM-dd"));
    }
}
