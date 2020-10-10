package com.qiuhuu.leetcode;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例:
 * * 输入: numbers = [2, 7, 11, 15], target = 9
 * * 输出: [1,2]
 * * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @author : qiuhuu
 * @date : 2020-07-20 17-23
 */
public class Topic167 {

    public static void main(String[] args) {
        int[] number = {4,5,7,8,9,13};
        int target = 15;

        long startTime1 = System.currentTimeMillis();
        int[] ints = new Topic167().twoSum(number, target);
        long endTime1 = System.currentTimeMillis()-startTime1;
        System.out.println("twoSum："+ Arrays.toString(ints)+" , 用时："+endTime1);

        long startTime2 = System.currentTimeMillis();
        int[] ints2 = new Topic167().twoSum2(number, target);
        long endTime2 = System.currentTimeMillis()-startTime2;
        System.out.println("twoSum2："+ Arrays.toString(ints2)+" , 用时："+endTime2);
    }

    /**
     * 爆破模式
     * @param number 有序数组
     * @param target 目标值
     * @return 返回一个有序数组中 两个值相加等于目标值的下标数组
     */
    public int[] twoSum(int[] number, int target){
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length; j++) {
                if (number[i]+number[j]==target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[2];
    }
    /**
     * 双向指针模式
     * @param number 有序数组
     * @param target 目标值
     * @return 返回一个有序数组中 两个值相加等于目标值的下标数组
     */
    public int[] twoSum2(int[] number, int target){
        int left=0,right=number.length - 1;
        while (left < right){
            int sum = number[left]+number[right];
            if (sum == target){
                return new int[]{left+1,right+1};
            }else if (sum > target){
                right--;
            }else {
                left++;
            }
        }
        return new int[2];
    }
}
