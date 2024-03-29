package p5_longestpalindromicsubstring;

import java.util.Scanner;

public class Solution {
    // 暴力解法
    /*
    public String longestPalindrome(String s){
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换为字符数组，这一步非必须
        char[] charArray = s.toCharArray();
        //枚举所有长度严格大于1的子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++){
                // 可保证 j-i+1可保证得出的时最长子串
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    //验证子串s[left .. right] 是否为回文串
    private boolean validPalindromic(char[] charArray, int left, int right){
        while (left < right){
            if (charArray[left] != charArray[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String longestPalindromic = new Solution().longestPalindrome("ba");
        System.out.println(longestPalindromic);

    }
     */


    // Dynamic Programing
    public String longestPalindrome(String s){
        int len = s.length();
        if (len < 2) return s;
        int maxlen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i...j] 是否是回文串
        // 状态转移方程: dp[i][j] = dp[i+1][j-1] && (s[i] == s[j])
        // dp[i+1][j-1]表示的除去两边字符的子串情况
        // 边界条件：j - 1 - (i+1) + 1 < 2, 整理的 j - i < 3, 状态转移方程建立在子串长度大于2的前提下
        // 默认为false
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            // i < j 表示只填对角线上半部分的值
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等 返回 false
                if (charArray[i] != charArray[j]) dp[i][j] = false;
                else{
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }

                // 记录最长回文字串
                // 只要 dp[i][j] == true 成立，就表示字串 s[i...j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxlen){
                    maxlen =  j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);

    }
    // 中心扩散法
    // 分为两种情况：
    // 1. 中心字符与相邻两边不相等
    // 2. 中心字符与相邻两边相等，此时要把所有相等的字符串作为中心
    public String longestPalindrome1(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            // 向左寻找与当前相等的字符
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            // 向右寻找与当前相等的字符
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            // 向中心的两边寻找对称相等的字符
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            // 记录最长回文字符串的起始位置
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String res = new Solution().longestPalindrome1(scanner.next());
            System.out.println(res);
        }
    }
}
