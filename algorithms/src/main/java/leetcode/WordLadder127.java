package leetcode;

import java.util.*;

/**
 * Created by lsy on 2016/4/16.
 */
public class WordLadder127 {

    public static int ladderLength(String beginWord, String endWord, String[] array) {

        if(beginWord.length()==1){
            for (int i = 0; i < array.length; i++){
                if(beginWord==array[i]||endWord==array[i]){
                    return 2;
                }
                return 0;
            }
        }
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (!similarity(beginWord, array[i])) {
                continue;
            }
            lable:
            for (int j = i; j < array.length; j++) {
                if (!similarity(endWord, array[j])) {
                    continue;
                }
                for (int k = i; k < j; k++) {
                    if (!similarity(array[k], array[k + 1])) {
                        break lable;
                    }
                }
                if (i == j) {
                    return 3;
                }
                int len = j - i + 1;
                if (min == 0 || min > len) {
                    min = len;
                    continue;
                }
            }
        }
        return min;

    }

    public static boolean similarity(String A, String B) {
        char[] c1 = A.toCharArray();
        char[] c2 = B.toCharArray();
        int diff = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                if (++diff == 2) {
                    return false;
                }
            }
        }
        return diff==1?true:false;
    }

    public static void main(String[] args) {
        Set<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        String[] array = new String[]{"hot", "dot", "dog", "lot", "log"};
        String[] array2 = new String[]{"hot", "dog"};
        String[] array3 = new String[]{"a", "b","c"};
        System.out.println(ladderLength("a", "c", array3));
    }
}
