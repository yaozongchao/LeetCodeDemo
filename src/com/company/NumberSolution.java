package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yzc on 2017/3/24.
 */
public class NumberSolution {
    public int addDigits(int num) {
        int result = 0;
        while (num > 0) {
            result = result + num % 10;
            num /= 10;
        }
        if (result > 9) {
            return addDigits(result);
        }
        else {
            return result;
        }
    }

    ///https://leetcode.com/problems/happy-number/?tab=Description
    static HashSet<Integer> valSet = new HashSet<Integer>();
    public boolean isHappy(int n) {
        valSet.add(n);
        int result = 0;
        // 重要：拆出整数中每一位数字做运算
        while (n > 0) {
            result = result + (int)Math.pow(n%10, 2);
            n /= 10;
        }
        if (result == 1) {
            valSet.clear();
            return true;
        }
        else if (valSet.contains(result)){
            valSet.clear();
            return false;
        }
        else {
            return isHappy(result);
        }
    }

    // 取整数的约数
    public static List<Integer> primeFactors(int num) {
        List<Integer> result = new ArrayList<Integer>();
        int n = num;
        for (int i = 2; i <= n; i++) {
            while (n%i == 0) {
                result.add(i);
                n /= i;
            }
        }
        return result;
    }

    ///https://leetcode.com/problems/ugly-number/?tab=Description
    // 先取约数，然后检查约数是否在范围内
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        List<Integer> result = new ArrayList<Integer>();
        int n = num;
        for (int i = 2; i <= n; i++) {
            while (n%i == 0) {
                result.add(i);
                n /= i;
            }
        }
        for(Integer val: result) {
            if (val != 2 && val != 3 && val != 5) {
                return false;
            }
        }
        return true;
    }

    public boolean isUgly2(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        while (num%2 == 0) {
            num /= 2;
        }

        while (num%3 == 0) {
            num /= 3;
        }

        while (num%5 == 0) {
            num /=5;
        }

        return num == 1;
    }

    ///https://leetcode.com/problems/count-primes/?tab=Description,
    // 0,1都不是质数，质数就是只能被1和自身整除的数
    public boolean isPrime(int num) {
        if (num <= 0 || num == 1) return false;
        /*
            2 × 6 = 12
            3 × 4 = 12
            4 × 3 = 12
            6 × 2 = 12
            As you can see, calculations of 4 × 3 and 6 × 2 are not necessary.
         */
        for (int i = 2; i*i <= num; i++) {
            if (num%i == 0 && i != num) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    ///https://leetcode.com/problems/excel-sheet-column-title/?tab=Description
    public String convertToTitle(int n) {
        // 其实就是一个数制转换问题，26进制
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            n--; // tricky，对应字符的位置
            builder.insert(0, (char)('A' + n%26));
            n = n/26;
        }
        return builder.toString();
    }
}
