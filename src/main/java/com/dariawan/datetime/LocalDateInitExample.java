/**
 * Java 11 Code Examples v1 (https://www.dariawan.com)
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
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalDateInitExample {

    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.now();
        System.out.println("LocalDate1: " + localDate1);

        LocalDate localDate2 = LocalDate.now(Clock.systemUTC());
        System.out.println("LocalDate2: " + localDate2);
        
        LocalDate localDate3 = LocalDate.now(ZoneId.systemDefault());
        System.out.println("LocalDate3: " + localDate3);
        
        LocalDate localDate4 = LocalDate.of(1980, 4, 9);
        System.out.println("LocalDate4: " + localDate4);
        
        LocalDate localDate5 = LocalDate.of(1980, Month.APRIL, 9);
        System.out.println("LocalDate5: " + localDate5);
        
        LocalDate localDate6 = LocalDate.ofEpochDay(3629);
        System.out.println("LocalDate6: " + localDate6);
        
        LocalDate localDate7 = LocalDate.ofYearDay(1997, 127);
        System.out.println("LocalDate7: " + localDate7);
        
        LocalDate localDate8 = LocalDate.parse("2018-07-24");
        System.out.println("LocalDate8: " + localDate8);
        
        LocalDate localDate9 = LocalDate.parse("20180724", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("LocalDate9: " + localDate9);
        
        LocalDate localDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println("LocalDate: " + localDate);
    }
}
