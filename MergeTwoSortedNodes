package cd.tij.demo.leetcode;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * @ClassName: cd.tij.demo.leetcode.MergeTwoSortedNodes.class
 * @UserAndTime: saske2-2020/6/16-0:30
 * @Descript: xxxxx
 * @Reference: {@link}
 **/
public class MergeTwoSortedNodes {
    public class seqNode {
        public seqNode(Integer i) {
            this.value = i;
        }

        Integer value;
        seqNode next;
    }


    //创造一个随机数链表，长度为传参的长度
    private seqNode createnode(Integer lengthOfNode) {
        if (lengthOfNode < 1)
            return null;
        seqNode h0 = null;
        h0 = new seqNode(RandomUtils.nextInt(1, 40));
        seqNode tmp = h0;
        for (int i = 1; i < lengthOfNode; i++) {
            seqNode h1 = new seqNode(RandomUtils.nextInt(1, 40));
            tmp.next = h1;
            tmp = h1;
        }
        return h0;
    }

    /**
     * @Author&Time:saske2-11:16-2020/7/22
     * @Description:对链表进行排序，从第二个节点开始，将a[i]插入到之前的a[0]..a[i-1]中
     * {@link Insertion}插入排序
     * @Param:链表头[8,3,1,41,32,12,21,3,7,9,5,15]
     * @return:返回链表头
     **/
    private seqNode insertsortList(seqNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        seqNode pre = head;
        //当前待排序的节点
        seqNode cur = head.next;
        //辅助节点，永远指向头结点
        seqNode temp = new seqNode(0);
        temp.next = head;
        while (cur != null) {
            if (cur.value < pre.value) {
                //先把cur节点从当前链表中删除，然后再把cur节点插入到合适位置
                pre.next = cur.next;
                //从前往后找到node2.val>cur.val,然后把cur节点插入到node1和node2之间
                seqNode node1 = temp;
                seqNode node2 = temp.next;
                while (cur.value > node2.value) {
                    node1 = node2;
                    node2 = node2.next;
                }
                //把cur节点插入到node1和node2之间
                node1.next = cur;
                cur.next = node2;
                //cur节点向后移动一位
                cur = pre.next;

            } else {
                //向后移动
                pre = cur;
                cur = cur.next;
            }
            printSeqNode(temp);
        }
        return temp.next;
    }


    /**
     * @Author&Time:saske2-2020/11/30-23:38
     * @Description:打印链表
     * @Param: -
     * @return: -
    **/
    private void printSeqNode(seqNode head) {
        while (head != null) {
            if(head.next!=null)
                System.out.print(head.value + "->");
            else
                System.out.print(head.value + "->null");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * @Author&Time:saske2-12:47-2020/7/22
     * @Description: {@link Merge}链表的归并排序
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     * https://leetcode-cn.com/problems/merge-sorted-array/
     * @Param:head1和head2都为顺序链表，进行归并排序
     * @return:
     **/
    private seqNode MergeTwoList(seqNode head1, seqNode head2) {
        if (head1 == null && head2 != null)
            return head2;
        if (head1 != null && head2 == null)
            return head1;
        if (head1 == null && head2 == null)
            return null;
        seqNode headsmall = new seqNode(-1);
        seqNode headTotal = headsmall;
        while (head1 != null && head2 != null) {
            if (head1.value > head2.value) {
                headsmall.next = head2;
                head2 = head2.next;
            } else {
                headsmall.next = head1;
                head1 = head1.next;
            }
            headsmall = headsmall.next;
        }
        if (head1 == null) {
            headsmall.next = head2;
        } else {
            headsmall.next = head1;
        }
        return headTotal.next;
    }

    //二分归并所有的lists--太屌了，注意K和idx的运用
    public seqNode mergeKLists(seqNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int k = lists.length;
        //K代表着多少路，idx代表着每次合并之后的路数，当k=idx并且，k<=1的时候代表合并成1路了
        while (k > 1) {
            int idx = 0;
            for (int i = 0; i < k; i += 2) {
                if (i == k - 1) {
                    lists[idx++] = lists[i];
                } else {
                    lists[idx++] = MergeTwoList(lists[i], lists[i + 1]);
                }
            }
            k = idx;
        }
        return lists[0];
    }

    /**
     * 二分归并排序一个链表，其中，要用到函数 MergeTwoList 的功能
     * @return
     **/
    public seqNode MergeSortedRecurseList(seqNode head){
        if (head == null || head.next == null) {
            return head;
        }
        //slow节点是fast节点的一半位置，将链表平均分成两部分
        seqNode fast = head.next,slow = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //右边链表的头结点
        seqNode tmp = slow.next;
        slow.next=null;
        //递归调用左边和右边节点
        seqNode rightlist = MergeSortedRecurseList(tmp);
        seqNode leftlist = MergeSortedRecurseList(head);
        //归并两个递归后的链表，递归的最后一次结果肯定是两个数字的比较
        seqNode reslist = MergeTwoList(leftlist,rightlist);
        return reslist;
    }
    /**
     * @Author&Time:saske2-2020/11/30-23:55
     * @Description:二分归并链表的经典写法，要用到函数{@link MergeTwoList},函数传参调用的时候是:
     * public seqNode MergeSorted(seqNode head){return MergeSortedClassic(head,null);}
     * @Param: -
     * @return: -
    **/
    public seqNode MergeSortedClassic(seqNode head,seqNode tail){
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        seqNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        seqNode mid = slow;
        seqNode list1 = MergeTwoList(head, mid);
        seqNode list2 = MergeTwoList(mid, tail);
        seqNode sorted = MergeSortedClassic(list1, list2);
        return sorted;

    }

    @Test
    public void InsertSortListTests(){
        seqNode s1 = new seqNode(3);
        seqNode s2 = new seqNode(1);
        seqNode s3 = new seqNode(2);
        seqNode s4 = new seqNode(7);
        seqNode s5 = new seqNode(6);
        s1.next=s2;
        s2.next=s3;
        s3.next=s4;
        s4.next=s5;
        printSeqNode(s1);
        System.out.println("+++++++++++++++++++++++开始执行");
        seqNode result1 = insertsortList(s1);
        System.out.println("+++++++++++++++++++++++结束执行");
        printSeqNode(result1);

    }

    @Test
    public void MergeListTest() {
        System.out.println("head1:");
        seqNode head1 = createnode(8);
        printSeqNode(head1);
        head1 = insertsortList(head1);
        printSeqNode(head1);
        ///////////////////////
        System.out.println("head2:");
        seqNode head2 = createnode(10);
        printSeqNode(head2);
        head2 = insertsortList(head2);
        printSeqNode(head2);
        System.out.println("begin to sort two heads:");
        seqNode headall = MergeTwoList(head1,head2);
        printSeqNode(headall);
    }


}
