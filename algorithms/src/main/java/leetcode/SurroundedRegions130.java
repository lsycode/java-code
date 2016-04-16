package leetcode;

/**
 * Created by lsy on 2016/4/16.
 */
public class SurroundedRegions130 {
    public static void solve(char[][] board) {

        if (board == null || board.length == 0) {
            System.out.println("[]");
            return;
        }
        int length1 = board.length;
        int length2 = board[0].length;
        char o = 'o';
        char[][] result = new char[length1][length2];
        for (int i = 0; i < length2; i++) {
            if (o == board[0][i]) {
                result[0][i] = o;
            }
            if (o == board[length1 - 1][i]) {
                result[length1 - 1][i] = o;
            }
        }
        for (int i = 0; i < length1; i++) {
            if (o == board[i][0]) {
                result[i][0] = o;
            }
            if (o == board[i][length2 - 1]) {
                result[i][length2 - 1] = o;
            }
        }

        int p = 1;
        int minlength = length1 < length2 ? length1 : length2;
        int len = minlength / 2;
        if (minlength % 2 == 1) {
            len++;
        }
        while (p < len) {
            for (int i = p; i < length2 - p; i++) {
                if (o == board[p - 1][i] && o == board[p][i]) {
                    result[p][i] = o;
                }
                if (o == board[length1 - p][i] && o == board[length1 - 1 - p][i]) {
                    result[length1 - 1 - p][i] = o;
                }
            }

            for (int i = p; i < length1 - p; i++) {
                if (o == board[i][p - 1] && o == board[i][p]) {
                    result[i][p] = o;
                }
                if (o == board[i][length2 - p] && o == board[i][length2 - 1 - p]) {
                    result[i][length2 - 1 - p] = o;
                }
            }
            p++;
        }
        out(result);
    }

    public static void out(char[][] result) {
        for (char c1[] : result) {
            for (char c2 : c1) {
                System.out.printf(c2 == 'o' ? "o" : "x");
            }
            System.out.println();
        }
    }

    public static char[][] toChar(String[] str) {

        char[][] ch = new char[str.length][str[0].length()];
        for (int i = 0; i < str.length; i++) {
            ch[i] = str[i].toCharArray();
        }
        return ch;
    }

    public static void main(String[] args) {
//        int size = 4;
//        char o = 'o';
//        char[][] board = new char[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                board[i][j] = 'x';
//            }
//        }
//        board[1][1] = o;
//        board[1][2] = o;
//        board[2][2] = o;
//        board[3][1] = o;
//        solve(board);

//        char[][] board2 = null;
//        solve(board2);

        String[] s1 = {"xoxoxo", "oxoxox", "xoxoxo", "oxoxox"};
        char[][] ch = toChar(s1);
        solve(ch);
    }
}
