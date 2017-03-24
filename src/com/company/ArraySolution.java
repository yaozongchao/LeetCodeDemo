package com.company;

import java.util.*;

/**
 * Created by yzc on 17/3/23.
 */
public class ArraySolution {

    ///https://leetcode.com/problems/find-all-duplicates-in-an-array/?tab=Description
    public List<Integer> findDuplicates(int[] nums) {
        // 充分利用题中条件，1 ≤ a[i] ≤ n (n = size of array)，可以将值存到数组的下标所在的位置，利用正负配对来找到出现两次的数字
        List<Integer> resultList = new ArrayList<Integer>();
        if (nums.length <= 0)
            return resultList;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                resultList.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }

        return resultList;
    }

    ///https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/?tab=Description
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 与上题类似，充分利用数组下标来描述元素值，出现过的数字，将数组对应下标处的值置为负值，第二遍遍历时检查为正的值就是未出现过的
        List<Integer> resultList = new ArrayList<Integer>();
        if (nums.length <= 0) return resultList;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                resultList.add(i+1);
            }
        }

        return resultList;
    }

    ///https://leetcode.com/problems/merge-sorted-array/?tab=Description
    // 思路：倒着来，把最大的往后存，一步步向前，这样不打乱nums1前面的排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = m+n-1;
        int i = m-1;
        int j = n-1;
        while (j >= 0 && i >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[tail--] = nums1[i--];
            }
            else {
                nums1[tail--] = nums2[j--];
            }
        }

        while (i >= 0) {
            nums1[tail--] = nums1[i--];
        }

        while (j >= 0) {
            nums1[tail--] = nums2[j--];
        }
    }

    /// https://leetcode.com/problems/contains-duplicate/?tab=Description
    // 思路：利用Set数据结构的特性
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (val == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> valSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (valSet.contains(nums[i])) {
                return true;
            }
            valSet.add(nums[i]);
        }
        return false;
    }

    /// https://leetcode.com/problems/contains-duplicate-ii/?tab=Description
    // 思路：借助HashMap存储值和下标，判断值相等的基础上，再判断下标是否满足条件，此处的tricky是将值和下标倒过来存，这样方便取值
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (valMap.containsKey(nums[i])) {
                Integer index = valMap.get(nums[i]);
                if (i - index <= k) {
                    return true;
                }
            }
            valMap.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> valMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> keySet = valMap.keySet();
            for (Integer key: keySet) {
                long bak = valMap.get(key);
                long cur = nums[i];
                long absRet = Math.abs(cur - bak);
                boolean valueOk = absRet <= t;
                boolean indexOk = (i - key) <= k;
                if (valueOk && indexOk) {
                    return true;
                }
            }
            valMap.put(i, nums[i]);
        }

        return false;
    }
}
