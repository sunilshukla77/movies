package com.movie.type;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        String s = "He hit the ball so hard that the ball flew away and we lost the BALL";
        String[] strArray = s.split("\\s");
        // Both are okay
        String[] strArray1 = s.split(" ");
        List<String> lsValue= Arrays.asList(strArray);
        Set<String> st = (Set<String>) lsValue.stream()
                .filter(i-> Collections.frequency(lsValue, i)>1)
                .skip(1).limit(1)
                .collect(Collectors.toSet());
        st.forEach(System.out::println);

        Map<String, Long> frequencyMap = lsValue.stream().map(String::toLowerCase)
                .filter(i-> Collections.frequency(lsValue, i)>1)
                .filter(val->!val.equals("the"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(frequencyMap);
    }
}
