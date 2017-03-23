package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yzc on 17/3/23.
 */
public class TreeNodeSolution {
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


}
