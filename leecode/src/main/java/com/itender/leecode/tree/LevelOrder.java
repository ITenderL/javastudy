package com.itender.leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author itender
 * @date 2023/9/13 14:58
 * @desc 二叉树层序遍历
 */
public class LevelOrder {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 遍历
        traverseTree(root);
        return result;
    }

    private void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        // 解题思路：借助辅助队列先进先出的特性，先将根节点放入队列，判断当队列不为空，获取队列的长度，也就是队列中元素的个数，
        // 当队列中元素个数大于0，队列中的元素出队列，加入到本层的结果集中，同时把出队的元素的左孩子，和右孩子放入队列，本层级的元素个数减一
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int length = queue.size();
            while (length > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                length--;
            }
            result.add(list);
        }
    }
}
