package com.itender.leecode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author itender
 * @date 2023/9/13 16:25
 * @desc 二叉树最小深度
 */
public class MinDepth {
    public int minDepth(TreeNode root){
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
}
