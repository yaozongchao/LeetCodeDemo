package com.company;

import java.util.*;

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


    // 求二叉树中的结点个数
    public int getTreeNodeCount(TreeNode root) {
        if (root == null) return 0;
        return getTreeNodeCount(root.left) + getTreeNodeCount(root.right) + 1;
    }

    // 求二叉树的深度
    // 104. Maximum Depth of Binary Tree
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/#/description
    public int getTreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getTreeDepth(root.left), getTreeDepth(root.right)) + 1;
    }

    // 前序遍历（记忆方法：对应后序遍历，前序是指：根结点 -> 左结点 -> 右节点，后序是指：左结点 -> 右节点 -> 根结点）
    public void preOrderTraverse(TreeNode root, List<Integer> resultArray) {
        if (root == null) return;
        resultArray.add(root.val);
        preOrderTraverse(root.left, resultArray);
        preOrderTraverse(root.right, resultArray);
    }

    public void backOrderTraverse(TreeNode root, List<Integer> resultArray) {
        if (root == null) return;
        preOrderTraverse(root.left, resultArray);
        preOrderTraverse(root.right, resultArray);
        resultArray.add(root.val);
    }

    public void middleOrderTraverse(TreeNode root, List<Integer> resultArray) {
        if (root == null) return;
        preOrderTraverse(root.left, resultArray);
        resultArray.add(root.val);
        preOrderTraverse(root.right, resultArray);
    }

    // 分层遍历二叉树（按层次从上往下，从左往右）分析见剑指offer第138页
    // 广度优先遍历的思路是先将起始节点放入队列，队列不空，接下来每一次从队列的头部取出一个结点，遍历这个结点后把从它能到达的结点都依次放入队列。
    // 重复这个遍历过程，直到队列中的结点全部被遍历为止
    public void levelOrderTraverse(TreeNode root, List<Integer> resultArray) {
        if (root == null) return;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            resultArray.add(node.val);
            if (node.left != null) {
                queue.push(node.left);
            }
            else if (node.right != null) {
                queue.push(node.right);
            }
        }
    }

    // 二叉树中和为某一值的路径
    public void findPath(TreeNode root, int num, List<List<Integer>> resultList) {
        if (root == null) return;
        List<Integer> pathList = new ArrayList<Integer>();
        int currentSum = 0;
        p_findPath(root, num, pathList, currentSum, resultList);
    }

    private void p_findPath(TreeNode root, int num, List<Integer> pathList, int currentSum, List<List<Integer>> resultList) {
        currentSum = currentSum + root.val;
        pathList.add(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == num && isLeaf) {
            List<Integer> list = new ArrayList<Integer>(pathList);
            resultList.add(list);
        }

        if (root.left != null) {
            p_findPath(root.left, num, pathList, currentSum, resultList);
        }

        if (root.right != null) {
            p_findPath(root.right, num, pathList, currentSum, resultList);
        }

        currentSum = currentSum - root.val;
        pathList.remove(pathList.size()-1);
    }




}
