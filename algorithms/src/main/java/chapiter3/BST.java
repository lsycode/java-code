package chapiter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    public Value get(Key key) {
        Node x = get(root, key);
        return x == null ? null : x.val;
    }

    private Node get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        }
        return x;
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
        print(root);
        return "";
    }

    private void print(Node x) {
        if (x == null) {
            return;
        }
        print(x.left);
        // System.out.println(x.key + ":" + x.val);
        System.out.printf(x.key + ":" + x.val + "   ");
        print(x.right);
    }


    public Key min() {
        return root == null ? null : min(root).key;
    }

    private Node min(Node x) {
        return x.left == null ? x : min(x.left);
    }

    public Key floor(Key key) {
        return root == null ? null : floor(root, key).key;
    }

    public Key max() {
        return root == null ? null : max(root).key;
    }

    private Node max(Node x) {
        return x.right == null ? x : max(x.right);
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        return t == null ? x : t;
    }

    public Key ceiling(Key key) {
        return root == null ? null : ceiling(root, key).key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp > 0) {
            return floor(x.right, key);
        }
        Node t = floor(x.left, key);
        return t == null ? x : t;
    }

    private boolean hasLeft(Node x) {
        return x.left == null ? false : true;
    }

    private boolean hasRight(Node x) {
        return x.right == null ? false : true;
    }

    public Key select(int k) {
        return root == null ? null : select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int leftSize = size(x.left);
        if (k < leftSize) {
            return select(x.left, k);
        } else if (k > leftSize) {
            return select(x.right, k - leftSize - 1);
        }
        return x;
    }

    public int rank(Key key) {
        return root == null ? null : rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(x.left, key);
        } else if (cmp > 0) {
            return size(x.left) + 1 + rank(x.right, key);
        }
        return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x == null) {
            return null;
        }
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteKey(Key key) {
        deleteKey(root, key);
    }

    private Node deleteKey(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = deleteKey(x.left, key);
        } else if (cmp > 0) {
            x.right = deleteKey(x.right, key);
        } else {
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    public List<Key> keys() {
        return keys(min(), max());
    }

    public List<Key> keys(Key lo, Key hi) {
        List<Key> list = new ArrayList<Key>();
        keys(root, list, lo, hi);
        return list;
    }

    private void keys(Node x, List<Key> list, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, list, lo, hi);
        }
        if (cmphi > 0) {
            keys(x.right, list, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            list.add(x.key);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.put(5, "x5");
        bst.put(3, "x3");
        bst.put(4, "x4");
        bst.put(10, "x10");
        bst.put(8, "x8");
        bst.put(7, "x7");
        bst.put(14, "x14");
        bst.put(13, "x13");
        System.out.println(bst);
//        for (int i = 0; i < 9; i++) {
//            bst.deleteMin();
//            System.out.println(bst);
//        }
        List<Integer> list = bst.keys(7,9);
        System.out.println(list);
    }
}
