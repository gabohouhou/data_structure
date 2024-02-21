package com.gabo.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 01.两数之和
 * @Author: gabo
 * @Date: 2024/02/20 21:54
 **/
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum1(nums,target)));
    }

    /**
     * 第一种：暴力解法
     * 	双层for循环。从数组第一个元素开始循环遍历，依次和后面的元素求和，直到和为target为止。
     * 时间复杂度：O(n^2)；
     * 空间复杂度：O(1);
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 第二种：Hash表解法
     * 	 for循环+hash表。遍历数组，判断哈希表中是否存在target-当前元素值，如果存在，则返回（map中的target-当前元素值的下标，当前遍历索引），如果不存在，则将当前元素值，当前遍历索引存入哈希表中。
     * 时间复杂度：O(n)；
     * 空间复杂度：O(n);
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
