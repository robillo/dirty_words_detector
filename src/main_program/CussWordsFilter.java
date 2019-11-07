package main_program;

import database.raw_database.ParseDirtyWords;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class CussWordsFilter {

    private static List<String> cussWordsList = new ArrayList<>();

    private static String EXAMPLE_STRING_WITH_CUSS = "What the fuck, man!";
    private static String EXAMPLE_STRING_WITHOUT_CUSS = "Hi! I am Sweet as a Sweet Corn!";

    public static void main(String[] args) throws Exception {
        inflateCussWordsList();
        System.out.println(doesSentenceContainCussWord(EXAMPLE_STRING_WITH_CUSS));
    }

    private static void inflateCussWordsList() throws Exception {
        cussWordsList = ParseDirtyWords.getCussWordsList();
    }

    private static boolean doesSentenceContainCussWord(String sentence) {
        for(String slang : cussWordsList) {
            if(isSlangPartOfSentence(slang, sentence.toLowerCase()))
                return true;
        }
        return false;
    }

    private static boolean isSlangPartOfSentence(String slang, String sentence) {
        int M = slang.length();
        int N = sentence.length();

        int lps[] = new int[M];
        int j = 0;

        computeLpsArray(slang, M, lps);

        int i = 0;
        while (i < N) {
            if (slang.charAt(j) == sentence.charAt(i)) {
                j++;
                i++;
            }
            if (j == M)
                return true;

            else if (i < N && slang.charAt(j) != sentence.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return false;
    }

    private static void computeLpsArray(String pat, int M, int lps[]) {

        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {

            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }

            else {
                if (len != 0)
                    len = lps[len - 1];

                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
