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
package com.dariawan.codes;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public interface Number {
    
    default int sumPrimeNumbers(int... nums) {
        return sum(n -> isPrimeNumber(n), nums);
    }
    
    default long countPrimeNumbers(int... nums) {
        return count(n -> isPrimeNumber(n), nums);
    }
    
    default void printPrimeNumbers(int... nums) {
        print(n -> isPrimeNumber(n), nums);
    }
    
    private boolean isPrimeNumber(int num) {
        boolean isPrime = true;
        for(int divisor = 2; divisor <= num / 2; divisor++) {
            if (num % divisor == 0) {
                isPrime = false;
                break; // num is not a prime, no reason to continue checking
            }
        }
        return isPrime;
    }
    
    private int sum(IntPredicate predicate, int... nums) {
        return IntStream.of(nums).filter(predicate).sum();
    }
    
    private long count(IntPredicate predicate, int... nums) {
        return IntStream.of(nums).filter(predicate).count();
    }
    
    private void print(IntPredicate predicate, int... nums) {
        IntStream.of(nums).filter(predicate).forEach(x -> Number.print(x));
        System.out.println();
    }
    
    private static void print(int n) {
        System.out.print(n + " ");
    }
}
