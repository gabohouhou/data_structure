package com.gabo.leecode;

/**
 * 04.请你找出并返回这两个正序数组的 中位数 。 hard
 *
 * @Author gaboness
 * @Date 2024/03/01 09:27:00
 */
public class MedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 6}; // 5
        int[] nums2 = {33, 88, 100};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 确保 nums1 是较短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        // 使用二分查找在较短的数组中找到合适的位置
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // 如果 partitionX 是 0，表示没有元素在左边，用 Integer.MIN_VALUE 代替
            // 如果 partitionX 是 x，表示没有元素在右边，用 Integer.MAX_VALUE 代替
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            // 对 nums2 做同样的处理
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // 检查是否找到了正确的位置
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // 如果总长度是偶数，中位数是左边最大值和右边最小值的平均数
                // 如果总长度是奇数，中位数是左边的最大值
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { // 如果 nums1 的左边部分太大，需要向左移动
                high = partitionX - 1;
            } else { // 如果 nums2 的左边部分太大，需要向右移动
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}
