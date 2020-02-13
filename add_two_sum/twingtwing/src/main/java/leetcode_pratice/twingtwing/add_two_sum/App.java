package leetcode_pratice.twingtwing.add_two_sum;
import java.io.IOException;

import org.javatuples.Pair;

public final class App {
    private App() {
    }
    static class ListNode{

        public int item;
        
        public ListNode next;

        public ListNode pre;
        public ListNode(int val){
            item = val;
        }
    };
    public static ListNode input2ListNode(String input) {
        final int last_index = input.length();
        ListNode l = new ListNode(-1);
        ListNode Head = l;
        for (int ptr_idx = 1; ptr_idx <= last_index; ptr_idx++) {
            l.item = Character.getNumericValue(input.charAt(last_index - ptr_idx));
            if (ptr_idx != last_index) {
                l.next = new ListNode(-1);
                ListNode tmp = l;
                l = l.next;
                l.pre = tmp;
            }
        }
        return Head;
    }

    public static Pair<String, String> max_and_List(String X, String Y) {//put larger digits num in the front, and the smaller in the back
        final Pair<String, String> pair;
        if (X.length() >= Y.length()) {
            pair = Pair.with(X, Y);
        } else {
            pair = Pair.with(Y, X);
        }
        return pair;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1 is set to be the larger digits one, even if l1's is equal to l2's
        int carry = 0, sum = 0, c_digi;
        ListNode p1 = l1, p2 = l2, result = new ListNode(-1), head_of_result;
        head_of_result = result;
        try{	
                while(!(carry ==0 && p1.item==-1)){
                if(p2!=null && p1.item !=-1)sum = carry + p1.item + p2.item;//when p2!=-1 p1 wont be -1, normal type
                else if(p1.item !=-1 && p2==null) sum = carry + p1.item;// when p2 == -1
                else if(p1.item ==-1) sum = carry;//when p1 ==-1 , p2 will be -1

                carry = sum /10;
                c_digi = sum %10;
                result.item = c_digi;
                result.next = new ListNode(-1);
                result = result.next;
                if(p1!=null) p1 = p1.next;
                if(p2!=null) p2 = p2.next;
            }
        }catch(NullPointerException e){
            if(carry>0) result.item = carry;//when p1 ==-1 , p2 will be -1
            return head_of_result;
        }
        return head_of_result;

    }

    public static void main(final String[] args) throws IOException {
        final String X = "1";
        final String Y = "9";
        final Pair<String, String> pair = max_and_List(X, Y);
        ListNode l_l = input2ListNode(pair.getValue0()), s_l = input2ListNode(pair.getValue1());
        ListNode result = addTwoNumbers(l_l, s_l);
        while(result!=null){
            if(result.item!=-1) System.out.println(result.item);
            result = result.next;
        }
    }    
}