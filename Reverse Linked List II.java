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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode preNode = sentinel;
        ListNode node = head;
        ListNode postNode = head.next;
        int count = 1;
        while(count < m) {
            count ++;
            preNode = node;
            node = node.next;
            postNode = node.next;
        }
        ListNode mNode = node;
        while(count < n) {
            count ++;
            ListNode temp = postNode.next;
            postNode.next = node;
            node = postNode;
            postNode = temp;
        }
        preNode.next = node;
        mNode.next = postNode;
        return sentinel.next;
    }
}
