package com.xunqi.common;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.text.StrBuilder;
import org.bouncycastle.jcajce.provider.digest.SHA1;

import java.sql.SQLOutput;
import java.time.Year;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 6, 33, 33, 5, 22, 7, 66, 88, 9, 5, 66, 33, 9};
        List<Integer> list = Arrays.stream(arr).collect(Collectors.toList());
        LinkedHashMap<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (s1, s2) -> s2, LinkedHashMap::new));
        Optional maxOptional = collect.entrySet().stream().max(
                Comparator.comparing(Map.Entry::getValue)).map(s1 -> s1.getValue());
        System.out.println(collect);
        StrBuilder strBuilder = new StrBuilder();
        collect.entrySet().stream().filter(
                s1 -> s1.getValue() == maxOptional.get()).forEach((x) -> {
            strBuilder.append(x.getKey()).append(",");
        });
        String substring = strBuilder.toString().substring(0, strBuilder.toString().length() - 1);
        System.out.println("出现次数最多的数字有:" + substring);
        System.out.println("出现了" + maxOptional.get() + "次");

    }
}
