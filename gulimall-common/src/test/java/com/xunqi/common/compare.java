package com.xunqi.common;

public class compare {
    public static void main(String[] args) {
        String s1="str";
        String s2="ing";
        String s3="str"+"ing";
        String s4=s1+s2;
        String s5="string";
        System.out.println(s3==s4);
        System.out.println(s3==s5);
        final String s6="str";
        final String s7="ing";
        String s8=s6+s7;
        String s9=new StringBuilder().append(s1).append(s2).toString();
        System.out.println(s9);
        System.out.println(s4==s9);
        System.out.println(s9==s5);
        System.out.println(s9==s3);
        System.out.println(s5==s8);
    }
}
