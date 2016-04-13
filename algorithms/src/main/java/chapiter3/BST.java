package chapiter3;

/**
 * Created by lsy on 2016/4/13.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

//    public Value get(Key key) {
//        get(root, key);
//    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            get(x.left, key);
        } else if (cmp > 0) {
            get(x.right, key);
        }
        return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public String toString() {
        if (root == null) {
            return "";
        }
        outStr(root);
        return "";
    }

    private void outStr(Node x) {
        if (x.left == null && x.right == null) {
            System.out.println(x.key + ":" + x.val);
            return;
        }
        if (x.left != null) {
            outStr(x.left);
        }
        System.out.println(x.key + ":" + x.val);
        if (x.right != null) {
            outStr(x.right);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.put(5, "x");
        bst.put(3, "x");
        bst.put(4, "x");
        bst.put(10, "x");
        bst.put(8, "x");
        bst.put(7, "x");
        bst.put(14, "x");
        bst.put(13, "x");
        System.out.println(bst);
    }
}
