package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by yzc on 17/3/23.
 */
public class StringSolution {
    // 知识点
    // 1.StringBuilder; 2.charAt(i); 3.双指针，从头到尾，从尾到头同时遍历

    // 344. Reverse String https://leetcode.com/problems/reverse-string/#/description
    /*
    Write a function that takes a string as input and returns the string reversed.

    Example:
    Given s = "hello", return "olleh".
    */

    public String reverseString(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    // 541. Reverse String II
    // https://leetcode.com/problems/reverse-string-ii/#/description
    // while遍历 + begin/end双指针
    public String reverseStringII(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int beginIndex = 0, endIndex = 0;
        while (beginIndex < s.length()) {
            // first k
            endIndex = beginIndex + k <= s.length() ? endIndex + k : s.length();
            sb.append((new StringBuilder(s.substring(beginIndex, endIndex))).reverse().toString());

            if (endIndex >= s.length()) break;

            // second k
            beginIndex = endIndex;
            endIndex = beginIndex + k <= s.length() ? beginIndex + k : s.length();
            sb.append(s.substring(beginIndex, endIndex));

            beginIndex = endIndex;
        }

        return sb.toString();
    }

    public String reverseWords(String s) {
        String[] splitArray = s.trim().split(" +");
        Collections.reverse(Arrays.asList(splitArray));
        return String.join(" ", splitArray);
    }

    // 345. Reverse Vowels of a String https://leetcode.com/problems/reverse-vowels-of-a-string/#/description
    // 双指针遍历
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 0) return s;
        String vowels = "aeiouAEIOU";
        char[] charArray = s.toCharArray();
        int beginIndex = 0;
        int endIndex = s.length() - 1;
        while (beginIndex < endIndex) {
            while (beginIndex < endIndex && !vowels.contains(charArray[beginIndex]+"")) {
                beginIndex++;
            }
            while (beginIndex < endIndex && !vowels.contains(charArray[endIndex]+"")) {
                endIndex--;
            }

            char tmp = charArray[beginIndex];
            charArray[beginIndex] = charArray[endIndex];
            charArray[endIndex] = tmp;

            beginIndex++;
            endIndex--;
        }
        return new String(charArray);
    }

    /// https://leetcode.com/problems/is-subsequence/?tab=Solutions
    public boolean isSubsequence(String s, String t) {
        if (s.length() <= 0) return true;
        int indexT = 0;
        int indexS = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
            }
            if (indexS == s.length()) {
                return true;
            }

            indexT++;
        }
        return false;

    }

    // https://leetcode.com/problems/excel-sheet-column-number/?tab=Description
    public int titleToNumber(String s) {
        // 数制转换，类比成十进制就好理解了
        int result = 0;
        for(int i = 0 ; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
