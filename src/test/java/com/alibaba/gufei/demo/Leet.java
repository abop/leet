package com.alibaba.gufei.demo;

public class Leet {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("abcba"));
    }

    private static int compareCharAt(String s, int index1, int index2) {
        return s.charAt(index1) - s.charAt(index2);
    }

    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        String palindrome = s.substring(0, 1);
        int core = 0;
        int left, right;
        while (core < len - 1) {

            left = right = core;

            while (right + 1 < s.length() && s.charAt(core) == s.charAt(right + 1)) {
                right++;
            }
            core = (left + right) / 2 + 1;

            while (left - 1 >= 0 && right + 1 < len) {
                if (s.charAt(left - 1) == s.charAt(right + 1)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (right - left + 1 > palindrome.length()) {
                palindrome = s.substring(left, right + 1);
            }
        }
        return palindrome;
    }

    private static String getLongestPalindrome(String s, int len, int tHead, int tTail) {
        while (tHead - 1 >= 0 && tTail + 1 < len) {
            if (compareCharAt(s, tHead - 1, tTail + 1) == 0) {
                tHead--;
                tTail++;
            } else {
                break;
            }
        }
        return s.substring(tHead, tTail + 1);
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        String palindrome = s.substring(0, 1);
        for (int head = 0, tail = len - 1;
             head < tail;
             head++, tail = len - 1) {
            int tHead = head, tTail = tail;
            while (tHead < tTail) {
                if (compareCharAt(s, tHead, tTail) == 0) {
                    tHead++;
                    tTail--;
                } else {
                    tail--;
                    tTail = tail;
                    tHead = head;
                }
            }
            if (
                // 第一个条件可以省略
                // head < tail &&
                    tail - head + 1 > palindrome.length()) {
                palindrome = s.substring(head, tail + 1);
            }
        }

        return palindrome;
    }
}
