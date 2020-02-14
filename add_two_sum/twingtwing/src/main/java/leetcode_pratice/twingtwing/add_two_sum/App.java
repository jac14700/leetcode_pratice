package leetcode_pratice.twingtwing.add_two_sum;
import java.io.IOException;

import org.javatuples.Pair;

public final class App {
    private App() {
    }
    static class ListNode{
        public int item;
        public ListNode next;
        public ListNode(int val){item = val;}
    };
    public static ListNode input2ListNode(String input) {
        final int last_index = input.length();
        ListNode l = new ListNode(-1);
        ListNode Head = l;
        for (int ptr_idx = 1; ptr_idx <= last_index; ptr_idx++) {
            l.item = Character.getNumericValue(input.charAt(last_index - ptr_idx));
            if (ptr_idx != last_index) {
                l.next = new ListNode(-1);
                l = l.next;
            }
        }
        return Head;
    }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0, p1_val = 0, p2_val = 0;
        ListNode head_of_result = new ListNode(0);
        ListNode result = head_of_result;
        while (l1 != null || l2 != null) {
            p1_val = (l1 != null) ? l1.item : 0;
            p2_val = (l2 != null) ? l2.item : 0;
            sum = carry + p1_val + p2_val;
            carry = sum / 10;
            result = result.next = new ListNode(sum % 10);
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry > 0) {
            result.next = new ListNode(carry);
        }
        return head_of_result.next;
    }

    public static void main(final String[] args) throws IOException {
        final String X = "999999999999991", Y = "9";
        ListNode l_l = input2ListNode(X), s_l = input2ListNode(Y);
        ListNode result = addTwoNumbers(l_l, s_l);
        while(result!=null){
            if(result.item!=-1) System.out.println(result.item);
            result = result.next;
        }
    }    
}