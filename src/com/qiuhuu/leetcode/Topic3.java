package com.qiuhuu.leetcode;

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author : hu yang
 * @date : 2020-10-10 10:49
 *
 * 思路：设定一个滑动块 chunk，将每个字符依次放入chunk，放入时chunk里面值重复
 *      则当前最大长度 chunk.length
 *      清空 chunk ，下一个字符开始位置 chunk.length
 *      直到最大长度
 */
public class Topic3 {
    public static void main(String[] args) {
        Topic3 topic3 = new Topic3();
        // abcabcbb 3  ohomm 3 bbbbb 1 pwwkew 3
        String in = "pwwkew";
        int out = topic3.lengthOfLongestSubstring1(in);
        System.out.println(out);

    }
    //pwwkew
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 0,count =0;
        Set<Character> chunk = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            count++;
            chunk.add(chars[i]);
            if (chunk.size() != count){
                if (max < chunk.size()){
                    max = chunk.size();
                }
                i = i-1;
                chunk.clear();
                count = 0;
            }else if(chunk.size() == s.length()){
                return s.length();
            }else {
                if (max < chunk.size()){
                    max = chunk.size();
                }
            }
        }
        return max;
    }



    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        ArrayList<Character> chunk = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            //出现重复的 则删除重复数据之前的所有数据
            if (chunk.contains(chars[i])) {
                if (max < chunk.size()) {
                    max = chunk.size();
                }
                Iterator<Character> iterator = chunk.iterator();
                while (iterator.hasNext()) {
                    Character next = iterator.next();
                    iterator.remove();
                    if (next == chars[i]) {
                        chunk.add(chars[i]);
                        break;
                    }
                }
            } else {
                chunk.add(chars[i]);
                if (max < chunk.size() && i==s.length()-1) {
                    max = chunk.size();
                }
            }
        }
        return max;
    }
}
