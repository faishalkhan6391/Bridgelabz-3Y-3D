package Level2;

import java.util.Scanner;

public class WordLengthDemo {

    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); 
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] manualSplit(String text) {
        int len = getLength(text);
        int spaceCount = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        String[] words = new String[spaceCount + 1];
        int start = 0, wordIndex = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words[wordIndex] = text.substring(start, i);
                wordIndex++;
                start = i + 1;
            }
        }
        words[wordIndex] = text.substring(start, len);

        return words;
    }

    public static String[][] getWordWithLength(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = manualSplit(text);
        String[][] wordWithLength = getWordWithLength(words);

        System.out.println("Word\tLength");
        for (int i = 0; i < wordWithLength.length; i++) {
            System.out.println(wordWithLength[i][0] + "\t" + Integer.parseInt(wordWithLength[i][1]));
        }
    }
}
