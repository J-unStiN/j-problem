package str;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNotRepeatedCharacter {
    public static void main(String[] args) {
        char c = firstNotRepeatedCharacter("hello world!");
        System.out.println(c);

        char c2 = firstNotRepeatedCharacterV2("hello world!");
        System.out.println(c2);

        String c3 = firstNotRepeatedCharacterV3("hello world!");
        System.out.println(c3);
    }


    public static char firstNotRepeatedCharacter(String str) {
        final int ASCII_CODES = 256;

        int[] flags = new int[ASCII_CODES];

        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (flags[c] == -1) {
                flags[c] = i;
            } else {
                flags[c] = -2;
            }
        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }


    public static char firstNotRepeatedCharacterV2(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    public static String firstNotRepeatedCharacterV3(String str) {
//        Map<Integer, Long> collect = str.codePoints()
//                .mapToObj(it -> it)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Long> collect2 = str.codePoints()
                .mapToObj(it -> it)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Integer cp = collect2.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(e -> e.getKey())
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }



}
