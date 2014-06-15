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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode preNode = sentinel;
        ListNode curHead = head;
        ListNode node = head;
        ListNode postNode = head.next;
        int size = 1;
        while(node.next != null) {
            node = node.next;
            size ++;
        }
        node = head;
        int group = size / k;
        int rest = size % k;
        while(group != 0) {
            int count = 1;
            while(count < k) {
                ListNode temp = postNode.next;
                postNode.next = node;
                node = postNode;
                postNode = temp;
                count ++;
            }
            preNode.next = node;
            preNode = curHead;
            curHead.next = postNode;
            curHead = postNode;
            if(group != 1) {
                node =postNode;
                postNode = postNode.next;
            }
            group --;
        }
        return sentinel.next;
    }
}
