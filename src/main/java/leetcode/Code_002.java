package leetcode;

/**
 * @name
 * @ClassName Code_002
 * @Description https://leetcode-cn.com/problems/add-two-numbers/
 * @author: zdw
 * @date 2019/4/9 15:20
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import common.Common;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Code_002 implements Common {
    private Code_002() {
    }

    private static final Code_002 CODE_002_INSTANCE = new Code_002();

    ListNode listNode = new ListNode(0);
    int[] numVal = new int[]{};

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) throws JsonProcessingException {
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;


        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(9);
        ListNode listNode8 = new ListNode(9);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(9);
        ListNode listNode11 = new ListNode(9);
        ListNode listNode12 = new ListNode(9);
        ListNode listNode13 = new ListNode(9);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;

        ListNode listNode = CODE_002_INSTANCE.addTwoNumbers(listNode1, listNode4);
    }

    public ListNode addTwoNumbers(ListNode firstNode, ListNode secondNode) throws JsonProcessingException {
        //直接遍历，数字相加，考虑进位
        ListNode firstCurrent = firstNode;
        ListNode secondCurrent = secondNode;


        //个位数
        Integer firstVal = firstCurrent.val + secondCurrent.val;
        //进位值
        int extraVal = firstVal / 10;
        //根节点
        ListNode newListNode = new ListNode(firstVal % 10);
        //临时节点
        ListNode tempNode = newListNode;


        //判断是否还有下一个节点
        firstCurrent = firstCurrent.next;
        secondCurrent = secondCurrent.next;
        //判断是否还有数字
        if (firstCurrent == null && secondCurrent == null) {
            //判断进位是否还有值
            if (extraVal != 0) {
                tempNode.next = new ListNode(extraVal);
            }
            return newListNode;
        }

        while (true) {
            int total = 0;
            if (firstCurrent != null) {
                total += firstCurrent.val;
            }
            if (secondCurrent != null) {
                total += secondCurrent.val;
            }

            total = total + extraVal;
            extraVal = total / 10;
            ListNode currentNode = new ListNode(total % 10);
            tempNode.next = currentNode;
            tempNode = currentNode;

            //判断是否还有下一个节点
            firstCurrent = firstCurrent == null ? null : firstCurrent.next;
            secondCurrent = secondCurrent == null ? null : secondCurrent.next;
            //判断是否还有数字
            if (firstCurrent == null && secondCurrent == null) {
                break;
            }
        }


        //判断进位是否还有值
        if (extraVal != 0) {
            tempNode.next = new ListNode(extraVal);
        }

        return newListNode;
    }


}
