/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedLists {

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans=h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            h.next=l2;
        }
        if(l2==null){
            h.next=l1;
        } 
        return ans.next;
}

    public ListNode mergeKLists(ListNode[] lists) {
    int k = lists.length ;
    if(k == 0) return null;
    if(k == 1) return lists[0];

        while(k != 1) {
            //If Odd then merge last with first
            if(k % 2 != 0) {
                lists [0] = merge2Lists(lists[0],lists[k-1]);
            }
            int j =0;
            for(int i=0; i+1<k; i=i+2){
                lists [j++] = merge2Lists(lists[i],lists[i+1]);
            }
            k = k /2;
        } 
        return lists[0];
    }
}

/**Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.

We can merge two sorted linked list in O(n)O(n) time where nn is the total number of nodes in two lists.
Sum up the merge process and we can get: O\big(\sum_{i=1}^{log_{2}{k}}N \big)= O(N\log k)O(∑ 
i=1
log 
2
​	
 k
​	
 N)=O(Nlogk)
Space complexity : O(1)O(1)

We can merge two sorted linked lists in O(1)O(1) space.

Leetcode: https://leetcode.com/problems/merge-k-sorted-lists/**/
