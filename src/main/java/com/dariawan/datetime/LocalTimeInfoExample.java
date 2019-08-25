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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;

public class LocalTimeInfoExample {
    
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime       : " + localTime);
        System.out.println("Hour            : " + localTime.getHour());
        System.out.println("Minute          : " + localTime.getMinute());
        System.out.println("Second          : " + localTime.getSecond());
        System.out.println("Nano            : " + localTime.getNano());
        
        System.out.println("HOUR_OF_DAY     : " + localTime.get(ChronoField.HOUR_OF_DAY));        
        System.out.println("MINUTE_OF_HOUR  : " + localTime.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println("SECOND_OF_MINUTE: " + localTime.get(ChronoField.SECOND_OF_MINUTE));
        
        System.out.println("MINUTE_OF_DAY   : " + localTime.getLong(ChronoField.MINUTE_OF_DAY));
        System.out.println("SECOND_OF_DAY   : " + localTime.getLong(ChronoField.SECOND_OF_DAY));  
        
        System.out.println("#toSecondOfDay  : " + localTime.toSecondOfDay());
        System.out.println("#toNanoOfDay    : " + localTime.toNanoOfDay());
        System.out.println("#toEpochSecond  : " + localTime.toEpochSecond(LocalDate.now(), ZoneOffset.UTC));
    }
}
