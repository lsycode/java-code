package algo4.chapiter3;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
import utils.In;

/**
 * Created by lsy on 2016/4/13.
 */

public class Chapiter3 {

    public static void main(String[] args) {
        System.out.println(Common.START);
        System.out.println(Common.FINISH);
    }


    public static void test() {
        ST<String, Integer> st;
        st = new ST<String, Integer>();

        for (int i = 0; !In.isEmpty(); i++) {
            String key = In.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }


    public static void frequencyCounter() {
        int minlen = 1;
        ST<String, Integer> st = new ST<String, Integer>();
        while (!In.isEmpty()) {
            String word = In.readString();
            if (word.length() < minlen) {
                continue;
            }
            if (!st.contains(word)) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }
        }
        String max = " ";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        StdOut.println(max + " " + st.get(max));
    }
}
