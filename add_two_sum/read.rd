**link node by java 
you can add two different digits numbers, such as 321+9 = 330

First of all, I sort two input of addTwoNumbers(ListNode l1, ListNode l2), 
put larger digits num in the front and the smaller in the back trough Pair<String, String> max_and_List fun

in addTwoNumbers(ListNode l1, ListNode l2):
if(p2!=null && p1.item !=-1)sum = carry + p1.item + p2.item;
else if(p1.item !=-1 && p2==null) sum = carry + p1.item;
else if(p1.item ==-1) sum = carry;

this three conditions is to deal with three different condition, such as 321+9 = 330 or 321+111 = 432 or even 321+700 = 1021
btw, I initialize every value(item) as -1
