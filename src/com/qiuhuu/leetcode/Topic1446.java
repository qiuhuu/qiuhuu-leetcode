package com.qiuhuu.leetcode;

/**
 * 1446. 连续字符
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * 请你返回字符串的能量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 示例 2：
 *
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * 示例 3：
 *
 * 输入：s = "triplepillooooow"
 * 输出：5
 * 示例 4：
 *
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 * 示例 5：
 *
 * 输入：s = "tourist"
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 * @author : hu yang
 * @date : 2020-10-10 15:51
 *
 * 思路：滑动块
 */
public class Topic1446 {
    public static void main(String[] args) {
        Topic1446 topic1446 = new Topic1446();
        //leetcode 2 hooraaaaaaaaaaay 11 abbcccddddeeeeedcba 5
        int i = topic1446.maxPower1("j");
        System.out.println(i);
    }

    public int maxPower(String s) {
        int max = 0; //最大出现次数
        int print = 0;//记录值
        for (int i = 0; i < s.length();) {
            print = s.charAt(i);
            int maximum = 1; // 当前最大连续
            int next = i+1;//下一个值
            while (next!=s.length() && print == s.charAt(next)){
                next++;
                maximum++;
            }
            i=next; // 设置下一个坐标起始点
            max = Math.max(max,maximum);
        }
        return max;
    }

    public int maxPower1(String s) {
        int max = 0; //最大出现次数
        int print = 1;//记录值
        for (int i = 0; i < s.length();i++) {
            int next = i+1;
            if (next == s.length()){
                max = Math.max(max,print);
            }else if (s.charAt(i) == s.charAt(next)){
                print++;
            }else {
                max = Math.max(max,print);
                print = 1;
            }

        }
        return max;
    }
}
