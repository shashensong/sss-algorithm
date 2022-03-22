package com.sss.simple;

import java.util.HashMap;
import java.util.Map;

/** @title:罗马数字转整数
 *  @Author:杀神松1997
 * 罗马数字包含以下七种字符： I，  V，  X，  L， C， D 和  M。
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数
 */
public class Question13 {
    Map<Character,Integer> map = new HashMap<Character,Integer>(){
        {
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);

        }
    };
    public int solution(String str){
        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            //遍历每个字符，每个字符与下一个字符值比较，如果小于则做减法，大于做加法
            int current = map.get(str.charAt(i));
            if(i < str.length()-1 && current < map.get(str.charAt(i+1))){
                value -= current;
            }
            else {
                value += current;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Question13 question13 = new Question13();
        System.out.println(question13.solution("XIV"));
    }
}
