package str;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharacterCounting {
    public static void main(String[] args) {
        Map<Character, Integer> result_v1 = countCharacters("Stringggoing");
        System.out.println("result_v1 = " + result_v1);

        Map<Character, Long> result_v2 = countCharactersV2("Stringggoing");
        System.out.println("result_v2 = " + result_v2);

        Map<String, Integer> result_v3 = countCharactersV3("Stringggoing");
        System.out.println("result_v3 = " + result_v3);

        Map<String, Long> result_v4 = countCharactersV4("Stringggoing");
        System.out.println("result_v4 = " + result_v4);
    }


    public static Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }

        return map;
    }


    public static Map<Character, Long> countCharactersV2(String str) {

        return str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }


    public static Map<String, Integer> countCharactersV3(String str) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            int codePoint = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(codePoint));
            if (Character.charCount(codePoint) == 2) {
                i++;
            }

            map.compute(ch, (k, v) -> v == null ? 1 : v+1);
        }

        return map;
    }

    public static Map<String, Long> countCharactersV4(String str) {

        return str.codePoints()
                .mapToObj(ch -> String.valueOf(Character.toChars(ch)))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
    }



}
