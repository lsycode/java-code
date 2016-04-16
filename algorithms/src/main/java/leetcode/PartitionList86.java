package leetcode;

/**
 * Created by lsy on 2016/4/15.
 */
public class PartitionList86 {
    private ListNode root;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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

    public void partition(int x) {
        root = partition(root, x);
    }

    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode bef = new ListNode(0);
        ListNode aft = new ListNode(0);
        ListNode aftH = aft;
        ListNode befH = bef;
        while (head!=null){
            if(head.val<x){
                bef.next=head;
                bef=bef.next;
            }else{
                aft.next=head;
                aft=aft.next;
            }
            head=head.next;
        }
        aft.next=null;
        bef.next=aftH.next;
        return befH.next;
    }

    private void swapNext(ListNode A,ListNode B){
        ListNode temp1= deleteNext(A);
        ListNode temp2= deleteNext(B);
        putToNext(A,temp2);
        putToNext(B,temp1);

    }

    private ListNode deleteNext(ListNode node){

        if(node.next==null){
            return node;
        }
        ListNode temp = node.next;
        node.next=node.next.next;
        temp.next=null;
        return temp;
    }

    private void putToNext(ListNode node,ListNode next){
        ListNode temp = node.next;
        node.next=next;
        next.next=temp;
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
        PartitionList86 r = new PartitionList86();
//        r.push(1);
//        r.push(4);
//        r.push(3);
//        r.push(2);
//        r.push(5);
//        r.push(2);
        r.push(2);
        r.push(1);

        r.partition(2);
        System.out.println(r);
    }

}
