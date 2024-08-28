package com.itender.interview.thread;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author itender
 * @date 2023/12/13/ 21:12
 * @desc
 */
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            if(str.equals("23:59")) {
                System.out.println("22:22");
                return;
            }
            int cur = 0;
            String[] arr = str.split(":");
            String s = arr[0] + arr[1];
            if (s.startsWith("0")) {
                while (s.startsWith("0") && s.length() > 1) {
                    s = s.substring(1, s.length() - 1);
                    cur = Integer.parseInt(s);
                }
            }else {
                cur = Integer.parseInt(s);
            }
            String fir = s.substring(0, 1);
            String sec = s.substring(1, 2);
            String thr = s.substring(2, 3);
            String fo = s.substring(3, 4);
            String[] strArr = new String[] {fir, sec, thr, fo};
            List<String> strList = new ArrayList<>();
            for (int i = 0; i < strArr.length; i++) {
                String first = strArr[i];
                for (int j = 0; j < strArr.length; j++) {
                    String second = strArr[j];
                    for (int k = 0; k < strArr.length; k++) {
                        String third = strArr[k];
                        for (int l = 0; l < strArr.length; l++) {
                            String fourth = strArr[l];
                            String timeStr = first + second + third + fourth;
                            while (timeStr.startsWith("0") && timeStr.length() > 1) {
                                timeStr = timeStr.substring(1, timeStr.length() - 1);
                            }
                            strList.add(timeStr);
                        }
                    }
                }
            }
            List<Integer> integerList = new ArrayList<>();
            for (String s1 : strList) {
                integerList.add(Integer.parseInt(s1));
            }
            int finalCur = cur;
            List<Integer> filterList = integerList.stream().filter(x -> x > finalCur).sorted().collect(Collectors.toList());
            String targetStr = String.valueOf(filterList.get(0));
            while (targetStr.length() < 4) {
                targetStr = "0" + targetStr;
            }
            String pre = targetStr.substring(0, 2);
            String suffix = targetStr.substring(2, 4);
            System.out.println(pre + ":" + suffix);
        }
    }
}
