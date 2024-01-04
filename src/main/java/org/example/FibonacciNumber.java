package org.example;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    private static final Map<Integer, Long> memo = new HashMap<>();

    public long iterativeMethod(int n) {  //часова - O(n) просторова - O(1)
        if (n <= 1) {
            return n;
        }

        int fibonacciOne = 0;
        int fibonacciTwo = 1;
        int fibonacci = 0;

        for (int i = 0; i < n - 1; i++) {
            fibonacci = fibonacciOne + fibonacciTwo;
            fibonacciOne = fibonacciTwo;
            fibonacciTwo = fibonacci;
        }

        return fibonacci;
    }

    public long recursiveMethod(int n) {  // часова - O(2^n) просторова - O(n)
        if (n <= 1) {
            return n;
        }

        return recursiveMethod(n - 1) + recursiveMethod(n - 2);
    }

    public Long dynamicProgrammingMethod(int n) { //часова -  O(n) просторова -  O(n)
        if (n <= 1) {
            return (long) n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long fib = dynamicProgrammingMethod(n - 1) + dynamicProgrammingMethod(n - 2);
        memo.put(n, fib);

        return fib;
    }
}
