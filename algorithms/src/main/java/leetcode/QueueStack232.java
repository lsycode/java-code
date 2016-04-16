package leetcode;

/**
 * Created by lsy on 2016/4/14.
 */
public class QueueStack232 {
    private Node root;

    class Node {
        private int x;
        private Node next;

        public Node(int x, Node next) {
            this.x = x;
            this.next = next;
        }
    }

    public void push(int x) {
        if (root == null) {
            root = new Node(x, null);
            return;
        }
        push(root, x);
    }

    private void push(Node n, int x) {
        if (n.next == null) {
            n.next = new Node(x, null);
            return;
        }
        push(n.next, x);
    }

    public int peek() {
        return root == null ? null : root.x;
    }

    public boolean empty() {
        return root == null;
    }

    public void pop() {
        if (root == null) {
            return;
        }
        if (root.next == null) {
            root = null;
            return;
        }
        root = root.next;

    }

    public static void main(String[] args) {
        QueueStack232 q = new QueueStack232();
        q.push(1);
        q.pop();
        q.empty();
    }
}
