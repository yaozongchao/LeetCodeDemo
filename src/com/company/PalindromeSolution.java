package com.company;

/**
 * Created by yzc on 17/3/29.
 */
public class PalindromeSolution {
    // 判断数字是不是回文
    // 思路：将数字逆转，再和原数字比较
    public boolean isPalindrome(int x) {
        long reverse = 0;
        long origin = x;
        while (x > 0) {
            reverse = reverse*10 + x%10;
            x = x/10;
        }
        return reverse == origin;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 0) return true;
        int startIndex = 0;
        int tailIndex = s.length() - 1;
        while (startIndex < tailIndex) {
            char cHead = s.charAt(startIndex);
            char cTail = s.charAt(tailIndex);
            if (!Character.isLetterOrDigit(cHead)) {
                startIndex++;
            }
            else if (!Character.isLetterOrDigit(cTail)) {
                tailIndex--;
            }
            else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                startIndex++;
                tailIndex--;
            }
        }
        return true;
    }
}
