package linkedlist;

public class LC_2 {
    /* https://leetcode.com/problems/add-two-numbers/ */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        Integer l1Res = flat(l1);
        Integer l2Res = flat(l2);

        result = createNewList(l1Res+l2Res);
        return result;
    }

    public ListNode addTwoNumbersCarry(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;

            carry = sum / 10;
            temp.next = new ListNode(sum %10);
            temp = temp.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) l2 = l2.next;
        }
        return result.next;
    }

    private ListNode createNewList(int result) {
        ListNode listNode = new ListNode();
        ListNode tmp = listNode;
        while(result > 0) {
            int temp = result%10;
            tmp.val = temp;
            result /= 10;
            if (result != 0){
                tmp.next = new ListNode();
            }
            tmp = tmp.next;
        }
        return listNode;
    }

    private Integer flat(ListNode l) {
        if(l == null) {
            return 0;
        }
        return l.val + flat(l.next)*10;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = new LC_2().addTwoNumbersCarry(l1, l2);

        while (l3 != null) {
            System.out.print(l3.val + "->");
            l3 = l3.next;
        }
    }
}
