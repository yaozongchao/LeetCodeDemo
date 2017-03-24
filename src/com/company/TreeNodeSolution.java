package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by yzc on 17/3/23.
 */
public class TreeNodeSolution {
    TreeSet<Integer> mTreeSet = new TreeSet<Integer>();
    Integer min = Integer.MAX_VALUE;

    public TreeNode createTreeNode(int[] nums) {
        if (nums == null || nums.length <= 0) return null;
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            buildTreeNode(root, nums[i]);
        }
        return root;
    }

    public void buildTreeNode(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left == null) {
                TreeNode newLeft = new TreeNode(val);
                root.left = newLeft;
            }
            else {
                buildTreeNode(root.left, val);
            }
        }
        else {
            if (root.right == null) {
                TreeNode newRight = new TreeNode(val);
                root.right = newRight;
            }
            else {
                buildTreeNode(root.right, val);
            }
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        levelMaker(resultList, root, 0);
        return resultList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                result += root.left.val;
            }
            else {
                result += sumOfLeftLeaves(root.left);
            }
        }
        result += sumOfLeftLeaves(root.right);

        return result;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return 1+Math.max(depth(root.left), depth(root.right));
    }

    ///https://leetcode.com/problems/minimum-absolute-difference-in-bst/?tab=Description
    //思路：利用TreeSet的特性，以及两个方法floor/ceiling
    //floor：返回set中小于或等于指定数据的最大数据，如果不存在，返回null
    //ceiling：返回set中大于或等于指定数据的最小数据，如果不存在，返回null

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        if (!mTreeSet.isEmpty()) {
            if (mTreeSet.ceiling(root.val) != null) {
                int curLargeMin = mTreeSet.ceiling(root.val);
                if (Math.abs(curLargeMin - root.val) < min) {
                    min = Math.abs(curLargeMin - root.val);
                }
            }

            if (mTreeSet.floor(root.val) != null) {
                int curLessMax = mTreeSet.floor(root.val);
                if (Math.abs(root.val - curLessMax) < min) {
                    min = Math.abs(root.val - curLessMax);
                }
            }
        }
        mTreeSet.add(root.val);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);

        return min;
    }

    ///https://leetcode.com/problems/binary-tree-paths/?tab=Description
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<String>();
        if (root != null) {
            addTreePath(root, "", result);
        }
        return result;
    }

    public void addTreePath(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }

        if (root.left != null) {
            addTreePath(root.left, path + root.val + "->", result);
        }

        if (root.right != null) {
            addTreePath(root.right, path + root.val + "->", result);
        }
    }

}
