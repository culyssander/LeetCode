/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        BigInteger num1 = getIntegerNumber(l1);
        BigInteger num2 = getIntegerNumber(l2);
        BigInteger total = num1.add(num2);

        String text = new StringBuilder(total.toString())
                            .reverse()
                            .toString();

        return convertStringToLinkedList(text);
    }

    private BigInteger getIntegerNumber(ListNode list) {
        ListNode current = list;
        StringBuilder sb = new StringBuilder();

        while(current != null) {
            sb.append(current.val);
            current = current.next;
        }

        return new BigInteger(sb.toString());
    }

    private ListNode reverse(ListNode list) {
        ListNode previous = null;
        ListNode next = null;
        ListNode current = list;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    private ListNode convertStringToLinkedList(String text) {
        ListNode head = null;
        ListNode tail = null; 
        for(int i = 0; i < text.length(); i++) {
            char numString = text.charAt(i);
            ListNode node = new ListNode(Integer.parseInt("" + numString));

            if (head == null) {
                head = node;
                head.next = tail;
            } else {
                tail.next = node;
            }
            tail = node;
        }

        return head;
    }
}