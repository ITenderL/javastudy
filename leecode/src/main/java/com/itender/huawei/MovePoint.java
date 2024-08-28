package com.itender.huawei;

/**
 * @author itender
 * @date 2023/11/10/ 20:40
 * @desc
 */
public class MovePoint {

    /**
     * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
     * <p>
     * 输入：
     * <p>
     * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
     * <p>
     * 坐标之间以;分隔。
     * <p>
     * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
     * <p>
     * 下面是一个简单的例子 如：
     * <p>
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     * <p>
     * 处理过程：
     * <p>
     * 起点（0,0）
     * <p>
     * +   A10   =  （-10,0）
     * <p>
     * +   S20   =  (-10,-20)
     * <p>
     * +   W10  =  (-10,-10)
     * <p>
     * +   D30  =  (20,-10)
     * <p>
     * +   x    =  无效
     * <p>
     * +   A1A   =  无效
     * <p>
     * +   B10A11   =  无效
     * <p>
     * +  一个空 不影响
     * <p>
     * +   A10  =  (10,-10)
     * <p>
     * 结果 （10， -10）
     * <p>
     * 数据范围：每组输入的字符串长度满足
     * 1
     * ≤
     * �
     * ≤
     * 10000
     * <p>
     * 1≤n≤10000  ，坐标保证满足
     * −
     * 2
     * 31
     * ≤
     * �
     * ,
     * �
     * ≤
     * 2
     * 31
     * −
     * 1
     * <p>
     * −2
     * 31
     * ≤x,y≤2
     * 31
     * −1  ，且数字部分仅含正数
     * 输入描述：
     * 一行字符串
     * <p>
     * 输出描述：
     * 最终坐标，以逗号分隔
     * <p>
     * 示例1
     * 输入：
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     * 复制
     * 输出：
     * 10,-10
     * 复制
     * 示例2
     * 输入：
     * ABC;AKL;DA1;
     * 复制
     * 输出：
     * 0,0
     *
     * @param args
     */
    public static void main(String[] args) {

        int x = 0;
        int y = 0;
        String str = "A10;S20;W10;D30;X;A1A;B10A11;;A10;";
        String[] arr = str.split(";");
        for (String s : arr) {
            if (s == null || s.trim().length() == 0) {
                continue;
            }
            String prefix = s.substring(0, 1);
            if (!"A".equals(prefix) && !"S".equals(prefix)
                    && !"D".equals(prefix) && !"W".equals(prefix)) {
                continue;
            }
            int num = 0;
            try {
                num = Integer.parseInt(s.substring(1));
            } catch (Exception e) {
                continue;
            }
            if ("A".equals(prefix)) {
                x -= num;
            }
            if ("D".equals(prefix)) {
                x += num;
            }
            if ("S".equals(prefix)) {
                y -= num;
            }
            if ("W".equals(prefix)) {
                y += num;
            }
        }
        System.out.println(x +","+y);
    }
}

