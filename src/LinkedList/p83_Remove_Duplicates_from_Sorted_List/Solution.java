package p83_Remove_Duplicates_from_Sorted_List;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;

    }
}
