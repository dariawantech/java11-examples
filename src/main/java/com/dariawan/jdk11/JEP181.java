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

import java.lang.reflect.Method;

/**
 * JEP 181: Nest-Based Access Control
 */
public class JEP181 {

    public static class World1 {

        private void sayHello(String name) {
            System.out.println("from World1: Hello " + name);
        }
    }

    public static class World2 {

        public void sayHello() throws Exception {
            final World1 world1 = new World1();

            // this is working
            world1.sayHello("Alice");

            // this is not working before
            // but working from java 11
            try {
                final Method m = World1.class.getDeclaredMethod("sayHello", String.class);
                m.invoke(world1, "Beatrice");
            }
            catch (NoSuchMethodException nsm) {
                throw new Exception("NoSuchMethodException thrown: " + nsm.getMessage());
            }
            catch (IllegalAccessException ex) {
                throw new Exception("Cannot access sayHello through getDeclaredMethod", ex);
            }
        }
    }

    public static void main(String[] args) {

        try {
            new World2().sayHello();
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}

/*
Output:
------
from World1: Hello Alice
from World1: Hello Beatrice
*/