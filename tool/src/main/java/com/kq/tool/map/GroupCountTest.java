package com.kq.tool.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author kq
 * @date 2022-05-11 15:02
 * @since 2020-0630
 */
public class GroupCountTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList() {
            {
                add(12);
                add(20);
                add(12);
                add(22);
                add(22);
                add(23);
                add(159);
                add(12);
            }
        };

        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println(map.values());
        System.out.println(map.values().stream().collect(Collectors.toSet()));
        System.out.println(map.values().stream().collect(Collectors.toSet()).contains(1L));
    }

}
