package chapiter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsy on 2016/4/13.
 */
public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }

    public void delete(Key key) {
        if (first.key.equals(key)) {
            first = null;
        }
        for (Node x = first; x.next != null; x = x.next) {
            if (x.next.key.equals(key)) {
                x.next = x.next.next;
            }
        }
    }

    public Integer size() {
        int i = 0;
        Node x = first;
        if (x == null) {
            return i;
        }
        i = 1;
        while (x.next != null) {
            i++;
        }
        return i;
    }

    public List<Key> keys() {
        List<Key> list = new ArrayList<Key>();
        if (first == null) {
            return list;
        }
        for (Node x = first; x.next != null; x = x.next) {
            list.add(x.key);
        }
        return list;
    }
}
