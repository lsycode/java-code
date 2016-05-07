package algo4.chapiter5;

/**
 * Created by lsy on 2016/4/19.
 */
public class Alphabet {
    public static final Alphabet BINARY = new Alphabet("01");


    private char[] alphabet;
    private int[] inverse;
    private int R;

    public Alphabet(String alpha) {
        boolean[] unicode = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < alpha.length(); i++) {
            char c = alpha.charAt(i);
            if (unicode[c]) {
                throw new IllegalArgumentException("Illegal alphabet: repeated character = '" + c + "'");
            }
            unicode[c] = true;
        }
        alphabet = alpha.toCharArray();
        R = alpha.length();
        inverse = new int[Character.MAX_VALUE];
        for (int i = 0; i < inverse.length; i++) {
            inverse[i] = -1;
        }
        for (int c = 0; c < R; c++) {
            inverse[alphabet[c]] = c;
        }
    }

    private Alphabet(int R) {
        alphabet = new char[R];
        inverse = new int[R];
        this.R = R;

        for (int i = 0; i < R; i++) {
            alphabet[i] = (char) i;
        }

        for (int i = 0; i < R; i++) {
            inverse[i] = i;
        }
    }

    public Alphabet() {
        this(256);
    }

    public boolean contains(char c) {
        return inverse[c] != -1;
    }

    public int R() {
        return this.R;
    }

    public int lgR() {
        int lgR = 0;
        for (int t = R - 1; t >= 1; t /= 2) {
            lgR++;
        }
        return lgR;
    }

    public int toIndex(char c) {
        if (c >= inverse.length || inverse[c] == -1) {
            throw new IllegalArgumentException("Character " + c + " not in alphabet");
        }
        return inverse[c];
    }

    public int[] toIndices(String s) {
        char[] source = s.toCharArray();
        int[] target = new int[s.length()];
        for (int i = 0; i < source.length; i++)
            target[i] = toIndex(source[i]);
        return target;
    }

    public char toChar(int index) {
        if (index < 0 || index >= R) {
            throw new IndexOutOfBoundsException("AlphabetTest index out of bounds");
        }
        return alphabet[index];
    }


}
