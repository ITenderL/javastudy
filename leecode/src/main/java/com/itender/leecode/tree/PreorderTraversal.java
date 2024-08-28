package com.itender.leecode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author itender
 * @date 2023/9/13 9:35
 * @desc 二叉树前序遍历-递归
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        // int[] root = new int[]{1, null, 2, 3};
        // System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    public static void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // 前序遍历顺序，中，左，右
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }


    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 非递归方式；采用栈，遍历顺序中，左，右，根节点先进栈，循环判断如果栈不为空，根节点出栈，加入到结果集中
        // 然后出栈节点的右节点不为空，右节点先进栈；左节点不为空左节点进栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
