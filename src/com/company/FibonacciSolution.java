package com.company;

/**
 * Created by yzc on 17/4/2.
 */
public class FibonacciSolution {
    public long fibNormal(int n) {
        if (n <= 1) return n;
        return fibNormal(n-1) + fibNormal(n-2);
    }

    public long fibNormal2(int n) {
        if (n <= 1) return n;
        long fab1 = 0;
        long fab2 = 1;
        long result = 0;
        for (int i = 2; i <= n; i++) {
            result = fab1 + fab2;
            fab1 = fab2;
            fab2 = result;
        }
        return result;
    }

    // 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法？
    // 分析：剑指offer 75页，实际就是一个Fibonacci数列
    public long frogJumpNormal(int n) {
        return fibNormal2(n);
    }

    /*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法？
    与上面的跳台阶问题类似。
    当n>2时，第一次跳有n种选择：第一次只跳1级，那么此时跳法的数目等于后面剩下的n-1级台阶的跳法数目；
    第一次跳2级，那么此时跳法的数目等于后面剩下的n-1级台阶的跳法数目，依次类推，第一次直接跳n级。
    所以，所以n级台阶不同跳法总数为f(n) = f(n-1) + f(n-2) + ... + f(1) + 1。
    利用归纳法可以证明f(n) = 2^(n-1).
    f(n-1) = 2^(n-1-1)，推导出f(n) = 2*f(n-1)
     */
    public long frogJumpAbnormal(int n) {
        if (n <= 1) return n;
        return 2*frogJumpAbnormal(n-1);
    }

    public long frogJumpAbnormal2(int n) {
        if (n <= 1) return n;
        long result = 1;
        // 求2^(n-1)
        for (int i = 0; i <= n-1; i++) {
            result = 2*result;
        }
        return result;
    }
}
