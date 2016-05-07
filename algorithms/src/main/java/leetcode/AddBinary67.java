package leetcode;

/**
 * Created by lsy on 2016/4/21.
 */
public class AddBinary67 {
    public static String addBinary(String a, String b) {
        char[] chA = a.toCharArray();
        char[] chB = b.toCharArray();
        StringBuffer s = new StringBuffer("");
        int carry = 0;
        int length = chA.length > chB.length ? chA.length : chB.length;
        for (int i = 0; i <= length - 1; i++) {
            int tempA = 0, tempB = 0;
            tempA = (chA.length - 1 - i >= 0) ? (chA[chA.length - 1 - i] - 48) : 0;
            tempB = (chB.length - 1 - i >= 0) ? (chB[chB.length - 1 - i] - 48) : 0;
            //下面两句如果用switch，效率会降低很多，这里降低86ms
            s = s.insert(0, (tempA + tempB + carry) % 2);
            carry = (tempA + tempB + carry) / 2;
        }
        if (carry == 1)
            s = s.insert(0, 1);
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
