/*
 * Copyright (c) 2004, 2023, Michael Tomas Fox's and/or his affiliates. All rights reserved.
 * @MT_F0XTR0T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package regexrejects;

import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Main {
    public static void main(String[] args) {
        System.out.println("TASK #1");
        /*

           ^                            - Anchors the match at the beginning of the input string.
           abcdefghijklmnopqrstuv18340 - Matches the exact sequence of characters "abcdefghijklmnopqrstuv18340".
           $                            - Anchors the match at the end of the input string.

           Overall, this regular expression is quite simple. It matches a specific string: "abcdefghijklmnopqrstuv18340".
           It ensures that the input string contains exactly this sequence of characters and nothing else.
        */
        Pattern p1 = Pattern.compile("^abcdefghijklmnopqrstuv18340$");
        Matcher m1 = p1.matcher("abcdefghijklmnopqrstuv18340");
        System.out.println(m1.matches());


        System.out.println("\nTASK #2");
        /*

           \\b           - Matches a word boundary, ensuring that the pattern matches whole words.

           (             - Start of a capturing group.
             \\d+       - Matches one or more digits (0-9).
             \\.        - Matches a literal dot (.) character.
             \\d{2}     - Matches exactly two digits (0-9).
           )             - End of the first capturing group.

           \\s           - Matches a whitespace character (space).

           (             - Start of a capturing group.
             USD|RUB|EU - Matches one of the three currency codes: USD, RUB, or EU.
           )             - End of the second capturing group.

           \\b           - Matches a word boundary, ensuring that the pattern matches whole words.

           Overall, this regular expression is used to match currency amounts in a specific format:
           - The amount is in the form of X.XX (e.g., 123.45).
           - There is a space character separating the amount from the currency code.
           - The currency code is one of USD, RUB, or EU.

           The regular expression captures the amount and the currency code separately using capturing groups.
        */
        Pattern p2 = Pattern.compile("\\b(\\d+\\.\\d{2})\\s(USD|RUB|EU)\\b");

        Matcher m2 = p2.matcher("25.98 USD, 100 RUB, 10.25 EU, 44 ERR, 0.004 EU.");

        while (m2.find()) {
            String price = m2.group(1);
            String currency = m2.group(2);
            System.out.println("price: " + price + " " + currency);
        }


        System.out.println("\nTASK #3");
        /*
           \\d      - Matches a digit (0-9).

           (?!     - Start of a negative lookahead assertion.
             [+]   - Matches a literal plus (+) character.
           )       - End of the negative lookahead assertion.

           Overall, this regular expression matches a single digit (0-9) but only if it is not followed by a plus (+) sign.

           This is an example of a negative lookahead assertion. It ensures that the digit is matched only if it is not immediately followed by a plus sign, effectively excluding digits that are part of expressions like "+123" from being matched.
        */
        Pattern p3 = Pattern.compile("\\d(?![+])");

        Matcher m3 = p3.matcher("(1 + 8) – 9 / 4"); // 6 / 5 – 2 * 9

        while (m3.find())
            System.out.println("Found: " + m3.group());


        System.out.println("\nTASK #4");
        // Define a regular expression pattern for the date format dd/mm/yyyy.
        // It enforces the following rules:
        // - Day (dd): 01-31
        // - Month (mm): 01-12
        // - Year (yyyy): 1900-9999


        // Test the regular expression against example strings.
        String[] testDates = {
            "29/02/2000", // Valid date (leap year)
            "30/04/2003", // Valid date
            "01/01/2003", // Valid date
            "29/02/2001", // Invalid date (not a leap year)
            "30-04-2003", // Invalid date (wrong separator)
            "1/1/1899"    // Invalid date (year not in the allowed range)
        };
        /*
       ^                    - Anchors the match at the beginning of the input string.
       (0[1-9]|[1-2][0-9]|3[0-1]) - Matches a valid day in a month (01-31).
       /                    - Matches the forward slash separator between day, month, and year.
       (0[1-9]|1[0-2])      - Matches a valid month (01-12).
       /                    - Matches the forward slash separator between day, month, and year.
       (19\\d{2}|[2-9]\\d{3}) - Matches a valid year in the format 19XX or 2XXX-9XXX.

       $                    - Anchors the match at the end of the input string.

       Overall, this regular expression is used to validate date strings in the format "DD/MM/YYYY"
       where DD is a valid day (01-31), MM is a valid month (01-12), and YYYY is a valid year (1900-9999).
        */

        Pattern p4 = Pattern.compile("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(19\\d{2}|[2-9]\\d{3})$");

        for (var date : testDates) {
            Matcher matcher = p4.matcher(date);

            if (matcher.matches())
                System.out.println(date + " is a valid date.");
            else
                System.out.println(date + " is not a valid date.");
        }


        System.out.println("\nTASK #5");
        // Test email addresses against the pattern.
        String[] testEmails = {
            "user@example.com", // Valid email
            "root@holocaust",   // Valid email
            "myhost@@@com.ru",  // Invalid email (multiple consecutive @ symbols)
            "@my.ru",           // Invalid email (no username)
            "Julia String"      // Invalid email (no @ symbol)
        };

        /*
       ^                            - Anchors the match at the beginning of the input string.
       [a-zA-Z0-9._%+-]+            - Matches the local part of an email address, which can contain
                                      letters (a-z, A-Z), digits (0-9), and special characters like
                                      dot (.), underscore (_), percent (%), plus (+), and hyphen (-).
       @                            - Matches the at symbol "@" which separates the local part from
                                      the domain part of the email.
       [a-zA-Z0-9.-]+               - Matches the domain name part of the email, which can contain
                                      letters (a-z, A-Z), digits (0-9), dot (.), and hyphen (-).
       \.                           - Matches the literal dot (.) character between the domain and
                                      the top-level domain (TLD).
       [a-zA-Z]{2,}                 - Matches the TLD, which consists of at least two letters (e.g.,
                                      com, org, net).
       $                            - Anchors the match at the end of the input string.

       Overall, this regular expression is used to validate email addresses. It checks for a valid
       local part (username) followed by the "@" symbol and a valid domain name, and it ensures that
       the TLD (e.g., com, org) consists of at least two letters.
        */
        Pattern p5 = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

        for (var email : testEmails) {
            Matcher matcher = p5.matcher(email);

            if (matcher.matches())
                System.out.println(email + " is a valid email address.");
            else
                System.out.println(email + " is not a valid email address.");
        }

        System.out.println("\nTASK #6");
        String text = "Это некий текст для анализа частотности букв.";
        Map<Character, Integer> letterFrequency = buildLetterFrequency(text);
        for (Map.Entry<Character, Integer> entry : letterFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @NotNull
    public static Map<Character, Integer> buildLetterFrequency(String text) {
        Map<Character, Integer> letterFrequency = new HashMap<>();
        String regex = "[а-яА-Яa-zA-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            char letter = matcher.group().toLowerCase().charAt(0);
            letterFrequency.put(letter, letterFrequency.getOrDefault(letter, 0) + 1);
        }
        return letterFrequency;
    }
}