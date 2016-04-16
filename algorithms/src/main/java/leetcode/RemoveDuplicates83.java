package leetcode;

/**
 * Created by lsy on 2016/4/15.
 */


public class RemoveDuplicates83 {
    private ListNode root;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode node) {
            val = x;
            next = node;
        }
    }

    public void push(int x) {
        if (root == null) {
            root = new ListNode(x, null);
            return;
        }
        push(x, root);
    }

    private void push(int x, ListNode node) {
        if (node.next == null) {
            node.next = new ListNode(x, null);
            return;
        }
        push(x, node.next);
    }

    public void deleteDuplicates() {
        if (root == null) {
            return;
        }
        deleteDuplicates(root);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        head.next=diff(head.next,head.val);
        deleteDuplicates(head.next);
        return head;
    }

    public ListNode diff(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        if (head.val != x) {
            return head;
        }
        return diff(head.next, x);
    }

    public String toString() {
        print(root);
        return "";
    }

    private void print(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        print(node.next);
    }

    public static void main(String[] args) {
        RemoveDuplicates83 r = new RemoveDuplicates83();
        r.push(1);
        r.push(1);
        r.push(1);
        r.deleteDuplicates();
        System.out.println(r);
    }
}
