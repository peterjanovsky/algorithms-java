package com.pjanof.algorithms.problems;

public class AddNumbers {

    public AddNumbers() { }

    private ListNode recurse(ListNode l1, ListNode l2, int carry) {
        ListNode retNode = null;
        int result = 0;

        System.out.format("Iteration\n");

        // calculate place value, including carry from previous calculation
        if ((l1 != null) && (l2 != null)) {
            result = l1.val + l2.val + carry;
            System.out.format("First List: %d Second List: %d, Carry: %d\n", l1.val, l2.val, carry);
            retNode = recurse(l1.next, l2.next, ((result >= 10) ? 1 : 0));
        }
        else if (l1 != null) {
            result = l1.val + carry;
            System.out.format("First List: %d Second List: NULL, Carry: %d\n", l1.val, carry);
            retNode = recurse(l1.next, null, ((result >= 10) ? 1 : 0));
        }
        else if (l2 != null) {
            result = l2.val + carry;
            System.out.format("First List: NULL Second List: %d, Carry: %d\n", l2.val, carry);
            retNode = recurse(null, l2.next, ((result >= 10) ? 1 : 0));
        }
        else {
            // did the previous calculation result in a remainder
            if (carry > 0) {
                // node representing calculated place value
                ListNode node = new ListNode(carry);
                return node;
            } else return null;
        }

        System.out.format("Instantiating Node: %d\n", result);

        // node representing calculated place value
        ListNode node = null;
        if (result >= 10) node = new ListNode(result - 10);
        else node = new ListNode(result);

        // link nodes
        node.next = retNode;

        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return (recurse(l1, l2, 0));
    }
}
