package com.xunqi.common;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class listtoarray {
    public static void main(String[] args) {
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A","xx"
        };
        Integer[]arr={3,2,6,33,33,22,7,66,88,9,5,66,33,9};
        List<Integer> collect1 = Arrays.stream(arr).collect(Collectors.toList());
        List<String> list = Arrays.asList(s);
        System.out.println("list1:"+list);

        System.out.println(collect1);
        List<Integer> collect2 = collect1.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("collect2"+collect2);

        LinkedHashMap<Integer, Long> collect3 = collect1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (m1, m2) -> m2,
                        LinkedHashMap::new));
        System.out.println("collect3"+collect3);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return String.valueOf(o1.length()).compareTo(String.valueOf(o2.length()));
            }
        });
        System.out.println("list2:"+list);
        Map<String, String> collect = list.stream().map(s1 -> {
            System.out.print(s1.length()+"==");
            return s1;
        }).filter(s1 -> {
            boolean b = s1.length() == 5;
            return b;
        }).collect(Collectors.toMap(s1 -> s1, s1 -> s1));

        System.out.println(collect.toString());
        //没有指定类型的话会报错
        s=list.toArray(new String[0]);

        System.out.println(collect.size());

    }
}
