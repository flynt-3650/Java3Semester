/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package myviciouscoke.Fitness;
import java.util.ArrayList;
import java.util.Arrays;

class ClientDB {
    private static final ArrayList<Client> CLIENT_DATA_BASE = new ArrayList<>(Arrays.asList(
        new Client("Alice Peterson", 30, "2023-12-31"),
        new Client("Andrew Tate", 36, "2024-01-05"),
        new Client("Tristan Tate", 35, "2024-01-05"),
        new Client("Bob Rogan", 25, "2024-06-15"),
        new Client("Charlie Davis", 40, "2023-11-20"),
        new Client("David Goggins", 28, "2023-10-15"),
        new Client("Eve Loot", 35, "2024-03-05"),
        new Client("Frank Sinatra", 45, "2023-09-10")
    ));

    public static ArrayList<Client> getClientDataBase() {
        return CLIENT_DATA_BASE;
    }
}
