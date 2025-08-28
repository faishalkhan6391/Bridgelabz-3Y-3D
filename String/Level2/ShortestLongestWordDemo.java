package Level2;

import java.util.Scanner;

public class ShortestLongestWordDemo {

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

    public static int[] findShortestLongest(String[][] wordWithLength) {
        int shortestIndex = 0, longestIndex = 0;
        int shortestLen = Integer.parseInt(wordWithLength[0][1]);
        int longestLen = shortestLen;

        for (int i = 1; i < wordWithLength.length; i++) {
            int len = Integer.parseInt(wordWithLength[i][1]);
            if (len < shortestLen) {
                shortestLen = len;
                shortestIndex = i;
            }
            if (len > longestLen) {
                longestLen = len;
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = manualSplit(text);
        String[][] wordWithLength = getWordWithLength(words);
        int[] indexes = findShortestLongest(wordWithLength);

        System.out.println("Words with Length:");
        for (int i = 0; i < wordWithLength.length; i++) {
            System.out.println(wordWithLength[i][0] + " -> " + Integer.parseInt(wordWithLength[i][1]));
        }

        System.out.println("\nShortest Word: " + wordWithLength[indexes[0]][0] +
                           " (Length: " + wordWithLength[indexes[0]][1] + ")");
        System.out.println("Longest Word: " + wordWithLength[indexes[1]][0] +
                           " (Length: " + wordWithLength[indexes[1]][1] + ")");
    }
}
