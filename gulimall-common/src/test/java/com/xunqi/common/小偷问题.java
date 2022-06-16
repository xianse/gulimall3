package com.xunqi.common;

import org.junit.Test;

/**
 * 从全部房子中能偷到的最大金额
 */
public class 小偷问题 {

    public static void main(String[] args) {
        int [] nums={1,2,3,4,5,6};
        int pre=0;
        int curr=0;
        for (int i :nums) {
            System.out.println(i);
            int temp= Math.max(curr,pre+i);
            pre=curr;
            curr=temp;
        }
        System.out.println(curr);
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额
     */

    @Test
    public  void a() {
        int [] nums={3,8,3,4,5,2,7,8};
        int sum1=0;
        int sum2=0;
        int max=0;
        for (int i=0;i<nums.length;i+=2 ) {
            int k=i+1;
            sum1+=nums[i];
            sum2+=nums[k];
            k+=2;
        }
        max=Math.max(sum1,sum2);
        System.out.println(sum1+"=="+sum2);
        System.out.println(max);
    }
}
