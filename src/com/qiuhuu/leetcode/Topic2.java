package com.qiuhuu.leetcode;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author : qiuhuu
 * @date : 2020-07-24 15:27
 */
public class Topic2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = new Topic2().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return null;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0 ,num2 = 0,sum,count =0 ;
        do{
            num1 += l1.val * (Math.pow(10,count));
            count++;
        }while ((l1 = l1.next) !=null);

        count=0;

        do{
            num2 += l2.val * (Math.pow(10,count));
            count++;
        }while ((l2 = l2.next) !=null);
        sum = num1+num2;
        ListNode result = null;
        char[] sumChars = String.valueOf(sum).toCharArray();
        count = sumChars.length -1 ;
        do{
            result.val = sumChars[count];
            count --;
        }while (count < 0);

        return result;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
