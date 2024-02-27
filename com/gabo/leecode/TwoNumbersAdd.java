package com.gabo.leecode;

/**
 * 02.两数相加 mid
 *
 * @Author gaboness
 * @Date 2024/02/27 11:24:00
 */
public class TwoNumbersAdd {
    public static void main(String[] args) {
        // 342 + 465 = 807 -> 708
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        System.out.println(l1);
        System.out.println(l4);
        System.out.println(addTwoNumbers(l1, l4));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2->4->3
        // 5->6->4
        // 7->0->8
        ListNode vNode = new ListNode(0);
        ListNode cur = vNode;
        int carry = 0;

        while (l1!=null || l2!=null) {
            int a = (l1!=null)?l1.val:0;
            int b = (l2!=null)?l2.val:0;
            int sum = a + b + carry;
            carry = sum/10;
            sum = sum %10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1!=null) {
                l1 = l1.next;
            }
            if (l2!=null) {
                l2 = l2.next;
            }
        }
        if (carry >= 1) {
            cur.next = new ListNode(carry);
        }
        return vNode.next;

//        //设置一个虚拟结点
//        ListNode dummy = new ListNode(0);
//        //设置一个可移动指针，存储当前结点
//        ListNode cur = dummy;
//        //设置一个进位指针
//        int carry = 0;
//
//        while (l1 != null || l2 != null) {
//            //取当前位的值，如果当前位空，就补0，保证两个整数的位数相同
//            int a = (l1 != null) ? l1.val : 0;
//            int b = (l2 != null) ? l2.val : 0;
//            int sum = a + b + carry;
//
//            //进位值
//            carry = sum / 10;
//            //当前位的值
//            sum %= 10;
//            //创建一个新的结点保存当前结点的值
//            cur.next = new ListNode(sum);
//            //链表结点后移
//            cur = cur.next;
//            //将两个链表往后移
//            if (l1 != null) l1 = l1.next;
//            if (l2 != null) l2 = l2.next;
//        }
//        //如果最后两个数相加有进位值，将进位数赋予新的结点
//        //结点值在0~9，故进位最多为1
//        if (carry == 1) {
//            cur.next = new ListNode(carry);
//        }
//        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        // 循环打印ListNode的val值，并且用->拼接，
        StringBuilder builder = new StringBuilder();
        builder.append(val).append("->");
        ListNode cur = this.next;
        while(cur!=null) {
            builder.append(cur.val).append("->");
            cur = cur.next;
        }
        return builder.toString();
    }
}
