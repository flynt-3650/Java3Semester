/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package dateandtimeiwillremember;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

class DT {
    static Calendar calendar = Calendar.getInstance();
    private static final int YEAR = calendar.get(Calendar.YEAR);
    private static final int MONTH = calendar.get(Calendar.MONTH);
    private static final int DAY = calendar.get(Calendar.DAY_OF_MONTH);
    private static final int HOUR = calendar.get(Calendar.HOUR_OF_DAY);
    private static final int MINUTE = calendar.get(Calendar.MINUTE);
    private static final int SECOND = calendar.get(Calendar.SECOND);

    private static @NotNull String formatDay(@NotNull String day) {
        if (day.length() > 2 || day.isEmpty()) {
            System.err.println("Invalid day passed to internal function");
            return "";
        }

        if (day.charAt(day.length() - 1) == '1' && day.length() == 1)
            return day + "st";
        else if (day.charAt(day.length() - 1) == '2' && day.length() == 1)
            return day + "nd";
        else if (day.charAt(day.length() - 1) == '3' && day.length() == 1)
            return day + "rd";
        else
            return day + "th";
    }

    public static void receiveAndPassTask(String devName) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        System.out.printf("%s has received task on %s %s, %d at %02d:%02d:%02d\n",
                devName, months[MONTH], formatDay(String.valueOf(DAY)), YEAR, HOUR, MINUTE, SECOND);
        System.out.printf("%s has to pass the task until %s %s, %d at %02d:%02d:%02d\n",
                devName, months[MONTH], formatDay(String.valueOf(DAY + 1)), YEAR, HOUR, MINUTE, SECOND);
        //System.out.print(devName + " has received task on" + parseDate());
    }

    public static void compareDate(@NotNull String userDate) {
        try {
            // Split the input date into year, month, and day components
            String[] parsed = userDate.split("-");

            if (parsed.length == 3) {
                int userYear = Integer.parseInt(parsed[0]);
                int userMonth = Integer.parseInt(parsed[1]);
                int userDay = Integer.parseInt(parsed[2]);

                // Calculate the year, month, and day offsets
                int yearOffset = userYear - YEAR;
                int monthOffset = userMonth - MONTH;
                int dayOffset = userDay - DAY;

                System.out.println("Year offset = " + yearOffset +
                    "\nMonth offset = " + monthOffset +
                    "\nDay offset = " + dayOffset);
            } else {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid date format. Please use numeric values for year, month, and day.");
        }
    }

    public static void createDateAndCalendar(@NotNull String userDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
            Date date = dateFormat.parse(userDate);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            System.out.println("Date: " + date);
            System.out.println("Calendar: " + calendar.getTime());
        } catch (ParseException e) {
            System.err.println("Error parsing the date: " + e.getMessage());
        }
    }

    public static void timeComparison() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4));

        System.out.println("INSERTION TEST");

        long arrayListStartTime = System.nanoTime();
        arrayList.add(2, 5);
        long arrayListEndTime = System.nanoTime();
        long arrayListDeltaTime = arrayListEndTime - arrayListStartTime;

        long linkedListStartTime = System.nanoTime();
        linkedList.add(2, 5);
        long linkedListEndTime = System.nanoTime();
        long linkedListDeltaTime = linkedListEndTime - linkedListStartTime;

        System.out.println("ArrayList " + arrayListDeltaTime + " nanoseconds");
        System.out.println("LinkedList " + linkedListDeltaTime + " nanoseconds");


        System.out.println("\nREMOVAL TEST");

        arrayListStartTime = System.nanoTime();
        arrayList.remove(2);
        arrayListEndTime = System.nanoTime();
        arrayListDeltaTime = arrayListEndTime - arrayListStartTime;

        linkedListStartTime = System.nanoTime();
        linkedList.remove(2);
        linkedListEndTime = System.nanoTime();
        linkedListDeltaTime = linkedListEndTime - linkedListStartTime;
        System.out.println("ArrayList " + arrayListDeltaTime + " nanoseconds");
        System.out.println("LinkedList " + linkedListDeltaTime + " nanoseconds");

        System.out.println("\nADDITION TEST");

        arrayListStartTime = System.nanoTime();
        arrayList.add(10);
        arrayListEndTime = System.nanoTime();
        arrayListDeltaTime = arrayListEndTime - arrayListStartTime;

        linkedListStartTime = System.nanoTime();
        linkedList.add(10);
        linkedListEndTime = System.nanoTime();
        linkedListDeltaTime = linkedListEndTime - linkedListStartTime;
        System.out.println("ArrayList " + arrayListDeltaTime + " nanoseconds");
        System.out.println("LinkedList " + linkedListDeltaTime + " nanoseconds");

        System.out.println("\nSEARCH TEST");

        arrayListStartTime = System.nanoTime();
        Boolean doesContainArrayList = arrayList.contains(3);
        arrayListEndTime = System.nanoTime();
        arrayListDeltaTime = arrayListEndTime - arrayListStartTime;

        linkedListStartTime = System.nanoTime();
        Boolean doesContain = linkedList.contains(3);
        linkedListEndTime = System.nanoTime();
        linkedListDeltaTime = linkedListEndTime - linkedListStartTime;
        System.out.println("ArrayList " + arrayListDeltaTime + " nanoseconds");
        System.out.println("LinkedList " + linkedListDeltaTime + " nanoseconds");
    }
}
