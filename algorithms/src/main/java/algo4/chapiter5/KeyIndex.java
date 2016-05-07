//package algo4.chapiter5;
//
///**
// * Created by lsy on 2016/4/19.
// */
//public class KeyIndex {
//
//    private int key;
//    private String value;
//
//    public KeyIndex(int key, String value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public int key() {
//        return this.key;
//    }
//
//    public String value() {
//        return this.value;
//    }
//
//    public static int[] order(KeyIndex[] a, int R) {
//        int N = a.length;
//        String[] aux = new String[N];
//        int[] count = new int[R + 1];
//        for (int i = 0; i < a.length; i++) {
//            count[a[i].key + 1]++;
//        }
//
//    }
//}
