package com.fuyun.alg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bl05959 on 2016/10/12.
 */
public class StrTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("HelloWorld", "HelloMars", "HelloWorldMars", "FuyunTest", "Foo");
        System.out.println(match(list, "H"));
        System.out.println(match(list, "HeW"));
        System.out.println(match(list, "HeM"));
        System.out.println(match(list, "HeWM"));
    }
    private static List<String> match(List<String> all, String pattern) {
        String regex = "^" + pattern.replaceAll("(?<!^)(?=[A-Z])", "[a-z]*") + "\\w*$";
        return all.stream().filter(str -> str.matches(regex)).collect(Collectors.toList());
    }
}
