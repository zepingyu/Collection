package leedcode;

public class Solution {

    /**
     * 19. 删除链表的倒数第 N 个结点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode begin = head, end = head;
        while (end.next != null && n > 0) {
            end = end.next;
            n--;
        }

        //删除数字为链表长度
        if (n == 1) {
            head = head.next;
            return  head;
        }

        while (end.next != null) {
            begin = begin.next;
            end = end.next;
        }

        //删除第n个节点
        if (begin.next != null && begin.next.next != null) {
            begin.next = begin.next.next;
        } else {
            begin.next = null;
        }

        return  head;
    }

    /**
     * 239. 滑动窗口最大值
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[(nums.length - k) + 1];
        int max = nums[0];
        int secondMax = nums[0];
        int index = 0;
        while (index < k) {
            max = Math.max(max, nums[index]);
            index++;
        }

        int resultIndex = 0;
        result[resultIndex] = max;
        while (index <= nums.length - 1) {
            resultIndex++;
            if (result[resultIndex - 1] != nums[index - k]) {
                result[resultIndex] = Math.max(result[resultIndex - 1], nums[index]);
            } else {
                result[resultIndex] = Math.max(secondMax, nums[index]);
            }
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxSlidingWindow(nums, 3).toString());
    }

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

