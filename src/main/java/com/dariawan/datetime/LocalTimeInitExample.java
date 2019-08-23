/**
 * Code Examples in JDK 8 v1 (https://www.dariawan.com)
 * Copyright (C) 2019 Dariawan <hello@dariawan.com>
 *
 * Creative Commons Attribution-ShareAlike 4.0 International License
 *
 * Under this license, you are free to:
 * # Share - copy and redistribute the material in any medium or format
 * # Adapt - remix, transform, and build upon the material for any purpose,
 *   even commercially.
 *
 * The licensor cannot revoke these freedoms
 * as long as you follow the license terms.
 *
 * License terms:
 * # Attribution - You must give appropriate credit, provide a link to the
 *   license, and indicate if changes were made. You may do so in any
 *   reasonable manner, but not in any way that suggests the licensor
 *   endorses you or your use.
 * # ShareAlike - If you remix, transform, or build upon the material, you must
 *   distribute your contributions under the same license as the original.
 * # No additional restrictions - You may not apply legal terms or
 *   technological measures that legally restrict others from doing anything the
 *   license permits.
 *
 * Notices:
 * # You do not have to comply with the license for elements of the material in
 *   the public domain or where your use is permitted by an applicable exception
 *   or limitation.
 * # No warranties are given. The license may not give you all of
 *   the permissions necessary for your intended use. For example, other rights
 *   such as publicity, privacy, or moral rights may limit how you use
 *   the material.
 *
 * You may obtain a copy of the License at
 *   https://creativecommons.org/licenses/by-sa/4.0/
 *   https://creativecommons.org/licenses/by-sa/4.0/legalcode
 */
package com.dariawan.datetime;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalTimeInitExample {

    public static void main(String[] args) {
        LocalTime localTime1 = LocalTime.now();
        System.out.println("LocalTime1 : " + localTime1);

        LocalTime localTime2 = LocalTime.now(Clock.systemUTC());
        System.out.println("LocalTime2 : " + localTime2);
        
        LocalTime localTime3 = LocalTime.now(ZoneId.systemDefault());
        System.out.println("LocalTime3 : " + localTime3);
        
        LocalTime localTime4 = LocalTime.of(3, 5, 15);
        System.out.println("LocalTime4 : " + localTime4);
        
        LocalTime localTime5 = LocalTime.of(15, 20, 45, 123456789);
        System.out.println("LocalTime5 : " + localTime5);
        
        LocalTime localTime6 = LocalTime.ofNanoOfDay(86399123456789L);
        System.out.println("LocalTime6 : " + localTime6);        
        
        LocalTime localTime7 = LocalTime.ofSecondOfDay(86399);
        System.out.println("LocalTime7 : " + localTime7);        
        
        LocalTime localTime8 = LocalTime.parse("20:45:30");
        System.out.println("LocalTime8 : " + localTime8);
        
        LocalTime localTime9 = LocalTime.parse("10:15:20", DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("LocalTime9 : " + localTime9);
        
        LocalTime localTime10 = LocalTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println("LocalTime10: " + localTime10);
    }
}
