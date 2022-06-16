package com.xunqi.common;

import org.junit.Test;

/**
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级。也可以跳n阶 求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * n=1 1
 * n=2  2
 * n=3  4
 * n=4  1111 112 121 211 22 31 13 4 =8
 * n=5 11111 1112 1121 1211 2111 122 212 221 113 131 311 14 41 5 32 23 =16
 *
 * 1 n  f(n-1)+f(n-2)+...+f(1)
 *  n-1 f(n-2)+...+f(1)
 * 数据范围：0≤n≤400 \leq n \leq 400≤n≤40
 * 要求：时间复杂度：O(n)O(n)O(n) ，空间复杂度： O(1)O(1)O(1)
 *
 *
 */
public class 跳台阶 {
@Test
public  void  aa(){
    int n = 5;
    //1左移n-1位
    System.out.println(1<<n-1);;
}
    public  static void main(String[] args) {
        int n = 7;
        if(n==1||n==2){
            System.out.println(n);
        }

        int temp=0;
        int second = 2;
        int first=1;
        for (int i = 3; i <=n; i++) {
            temp=second;
            second=first+second;
            first=temp;
        }
        System.out.println(second);;
    }

}
