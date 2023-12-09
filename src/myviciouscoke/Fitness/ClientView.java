/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Fitness;

import org.jetbrains.annotations.NotNull;

class ClientView {
    public static @NotNull String updateClientDetails(@NotNull Client client) {
        return "Name: '" + client.getName() + "' \n" +
               "Age: `" + client.getAge() + "` \n" +
               "Card Expiration Date: `" + client.getCardExpirationDate() + "` \n";
    }
}
