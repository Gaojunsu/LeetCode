package com.LeetCode.study;

import android.util.Log;

import com.LeetCode.study.dataStructure.ListNode;


/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * **/

public class AddTwoNumbers implements ResultInterface<ListNode>{

    private ListNode l1;
    private ListNode l2;


    public AddTwoNumbers() {
    }

    public AddTwoNumbers(ListNode l1, ListNode l2) {

        this.l1=l1;
        this.l2=l2;
    }

    @Override
    public ListNode result() {
        ListNode dummyHead = new ListNode(0);
        ListNode  curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }

    @Override
    public void test() {

        l1 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l3;
        l3.next = l5;

        l2 = new ListNode(8);
        ListNode l4 = new ListNode(3);
        ListNode l6 = new ListNode(7);
        l2.next = l4;
        l4.next = l6;

        ListNode result = result();

        while (true){
            Log.w("LeetCode",result.val+"");
            if (result.next==null){
                return;
            }
            result=result.next;
        }

    }
}
