/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Fitness;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;

class ClientController {
    private final Client model;

    ClientController(Client model) {
        this.model = model;
    }

    public void setClientName(String name) {
        model.setName(name);
    }

    public String getClientName() {
        return model.getName();
    }

    public Integer getClientAge() {
        return model.getAge();
    }

    public void setClientAge(Integer age) {
        model.setAge(age);
    }

    public LocalDate getCardExpirationDate() {
        return model.getCardExpirationDate();
    }

    public void setCardExpirationDate(String cardExpirationDateStr) {
        model.setCardExpirationDate(cardExpirationDateStr);
    }

    @Contract(pure = true)
    private static int countSpaces(@NotNull String input) {
        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == ' ')
                ++count;
        }

        return count;
    }

    public static @NotNull ArrayList<Client> retrieveClientFromDataBase(String name) {
        name = name.trim().toLowerCase();

        int amountOfWordsInName = countSpaces(name) + 1;
        ArrayList<Client> potentialClients = new ArrayList<>();

        if (amountOfWordsInName == 1) {
            for (final var item : ClientDB.getClientDataBase()) {
                String[] parsedName = item.getName().toLowerCase().split(" ");
                if (parsedName[0].equals(name) || parsedName[1].equals(name)) {
                    potentialClients.add(item);
                }
            }
        } else if (amountOfWordsInName == 2) {
            for (final var item : ClientDB.getClientDataBase()) {
                if (name.equalsIgnoreCase(item.getName())) {
                    potentialClients.add(item);
                }
            }
        } else {
            System.err.println("CHECK AMOUNT OF WORDS IN NAME");
        }
        return potentialClients;
    }

    public void updateView() {
        ClientView.updateClientDetails(model);
    }
}
