package com.itender.leecode.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author itender
 * @date 2023/9/6 9:46
 * @desc
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * <p>
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * <p>
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入："abbaca"
     * 输出："ca"
     * 解释：
     * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     *
     * @param s
     * @return
     */
    public static String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (deque.isEmpty() || deque.peek() != c) {
                deque.push(c);
            }else {
                deque.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.insert(0, deque.pop());
        }
        return result.toString();
    }
}
