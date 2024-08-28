package com.itender.leecode.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author itender
 * @date 2023/9/7 17:54
 * @desc
 */
public class EvalRPN {
    public static void main(String[] args) {

    }

    /**
     * 根据 逆波兰表示法，求表达式的值。
     * <p>
     * 有效的运算符包括 + ,  - ,  * ,  / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * <p>
     * 说明：
     * <p>
     * 整数除法只保留整数部分。 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     * <p>
     * 示例 1：
     * <p>
     * 输入: ["2", "1", "+", "3", " * "]
     * 输出: 9
     * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     * 示例 2：
     * <p>
     * 输入: ["4", "13", "5", "/", "+"]
     * 输出: 6
     * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
     * 示例 3：
     * <p>
     * 输入: ["10", "6", "9", "3", "+", "-11", " * ", "/", " * ", "17", "+", "5", "+"]
     * <p>
     * 输出: 22
     * <p>
     * 解释:该算式转化为常见的中缀算术表达式为：
     * <p>
     * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     * = ((10 * (6 / (12 * -11))) + 17) + 5
     * = ((10 * (6 / -132)) + 17) + 5
     * = ((10 * 0) + 17) + 5
     * = (0 + 17) + 5
     * = 17 + 5
     * = 22
     * 逆波兰表达式：是一种后缀表达式，所谓后缀就是指运算符写在后面。
     * <p>
     * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
     * <p>
     * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
     * <p>
     * 逆波兰表达式主要有以下两个优点：
     * <p>
     * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
     * <p>
     * 适合用栈操作运算：遇到数字则入栈；遇到运算符则取出栈顶两个数字进行计算，并将结果压入栈中。
     *
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                deque.push(deque.pop() + deque.pop());
            }else if ("-".equals(token)) {
                deque.push(-deque.pop() + deque.pop());
            }else if ("*".equals(token)) {
                deque.push(deque.pop() * deque.pop());
            }else if ("/".equals(token)) {
                int i = deque.pop();
                int j = deque.pop();
                deque.push(j / i);
            } else {
                deque.push(Integer.parseInt(token));
            }
        }
        return deque.pop();
    }
}
