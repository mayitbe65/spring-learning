package com.spring.demo.jdk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        Integer[] arr = new Integer[]{1, 1, 1, 2, 2, 3};
        Arrays.asList(arr).forEach(element -> {
            map.compute(element, (k, v) -> {
                System.out.println(element);
                System.out.println(k);
                System.out.println(v);
                System.out.println("--------");
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        });
        System.out.println(map);
    }
}
