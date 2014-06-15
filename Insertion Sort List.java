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
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pnode = sentinel;
        ListNode node = head;
        while(node != null) {
            ListNode temp = node.next;
            ListNode cpnode = sentinel;
            ListNode cnode = sentinel.next;
            while(cnode != node) {
                if(node.val < cnode.val) {
                    pnode.next = node.next;
                    cpnode.next = node;
                    node.next = cnode;
                    break;
                }
                else {
                    cpnode = cnode;
                    cnode = cnode.next;
                }
            }
            if(temp != node.next) {
                node = temp;
            }
            else {
                pnode = node;
                node = node.next;
            }
        }
        return sentinel.next; 
    }
}
