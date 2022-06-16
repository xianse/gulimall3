package com.xunqi.common;

import com.xunqi.common.timeconsum.TimeRecord;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/***
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 *
 *     answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 *     answer[i] == "Fizz" 如果 i 是 3 的倍数。
 *     answer[i] == "Buzz" 如果 i 是 5 的倍数。
 *     answer[i] == i （以字符串形式）如果上述条件全不满足。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class fizzbuzz {

    @TimeRecord(methodDesc = "stream消耗时长")
    public static List<String> a(int n) {
        List<String> ans = IntStream.range(0, n+1).mapToObj(i -> {
            if (i % 3 == 0 && i % 5 == 0) {
                return "FizzBuzz";
            } else if (i % 3 == 0) {
                return "Fizz";
            } else if (i % 5 == 0) {
                return "Buzz";
            } else {
                return String.valueOf(i);
            }
        }).collect(Collectors.toList());
        return  ans;
    }

    @TimeRecord(methodDesc = "list消耗时长")
    public static  List<String> bb(int n) {
        List<String>ans=new LinkedList<String>();
        for(int i=1;i<=n;i++){
            if(i%3==0&&i%5==0){
                ans.add("FizzBuzz");
            }
            else if(i%3==0){
                ans.add("Fizz");
            }
            else if(i%5==0){
                ans.add("Buzz");
            }
            else{
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> a = a(150000);
        System.out.println(a);
        bb(150000);
    }
}
