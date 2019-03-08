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
package com.dariawan.jdk11;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JEP181Nest {

    public class Nested1 {
        
        public class Nested1ClasA {            
        }
        
        public class Nested1ClasB {            
        }
    }

    public class Nested2 {
    }

    public static void main(String[] args) {
        testNests(JEP181Nest.class);
        testNests(Nested1.class);
        testNests(Nested2.class);
        testNests(Nested1.Nested1ClasA.class);
        testNests(Nested1.Nested1ClasB.class);
        
        System.out.println("*** testIsNestmateOf: ***");
        
        testIsNestmateOf(JEP181Nest.class, Nested1.class);
        testIsNestmateOf(JEP181Nest.class, Nested2.class);
        testIsNestmateOf(JEP181Nest.class, Nested1.Nested1ClasA.class);
        testIsNestmateOf(JEP181Nest.class, Nested1.Nested1ClasB.class);
        testIsNestmateOf(Nested1.class, Nested1.Nested1ClasA.class);
        testIsNestmateOf(Nested1.class, Nested1.Nested1ClasB.class);
        testIsNestmateOf(Nested1.class, Nested2.class);
        testIsNestmateOf(Nested2.class, Nested1.Nested1ClasA.class);
        testIsNestmateOf(Nested2.class, Nested1.Nested1ClasB.class);        
    }

    private static void testNests(Class<?> cls) {
        System.out.printf("*** Nests for class: %s ***%n", cls.getSimpleName());
        System.out.println("Nest Host:");
        System.out.println(cls.getNestHost().getSimpleName());
        Class<?>[] nestMembers = cls.getNestMembers();        
        System.out.println("Nest Members:\n" +
                Arrays.stream(nestMembers).map(Class::getSimpleName)
                      .collect(Collectors.joining("\n")));       
    }

    private static void testIsNestmateOf(Class<?> cls1, Class<?> cls2) {
        System.out.printf("%s isNestmateOf %s = %s%n", 
                cls1.getSimpleName(), cls2.getSimpleName(), cls1.isNestmateOf(cls2));
    }
}
