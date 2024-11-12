package str;

public class WordReverse {
    public static void main(String... args) {
        String wordReverse = wordReverse("word 1Reverse");
        System.out.println("wordReverse = " + wordReverse);

        String wordReverseV2 = wordReverseV2("word 1Reverse");
        System.out.println("wordReverseV2 = " + wordReverseV2);

        String wordReverseV3 = wordReverseV3("word 1Reverse");
        System.out.println("wordReverseV3 = " + wordReverseV3);
    }


    public static String wordReverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }


    public static String wordReverseV2(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length/2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length -1 - i];
            chars[chars.length -1 - i] = temp;
        }

        return new String(chars);
    }

    public static String wordReverseV3(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            StringBuilder reverse = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reverse.append(word.charAt(i));
            }

            sb.append(reverse).append(" ");
        }

        return sb.toString();
    }


}
