/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode preMark = sentinel;
        ListNode mark = sentinel.next;
        while(mark.val < x) {
            preMark = mark;
            mark = mark.next;
            if(mark == null)
                return head;
        }
        ListNode preNode = mark;
        ListNode node = mark.next;
        while(node != null) {
            if(node.val < x) {
            preNode.next = node.next;
            preMark.next = node;
            preMark = node;
            node.next = mark;
            node = preNode.next;
            }
            else {
                preNode = node;
                node = node.next;
            }
        }
        return sentinel.next;
    }
}
