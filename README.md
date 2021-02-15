# 1. Backtracking
```
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```
* 排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
* 组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。

[89.Gray Code](https://leetcode-cn.com/problems/gray-code/)

[93. Restore IP Addresses](https://leetcode-cn.com/problems/restore-ip-addresses/)

# 2. Dynamic Programing
[5. Longest Palindromic Substring](https://leetcode-cn.com/problems/longest-palindromic-substring/)

[滚动数组思想](https://leetcode-cn.com/problems/unique-paths-ii/solution/bu-tong-lu-jing-ii-by-leetcode-solution-2/)

## Linklist
[21. Merge Two Sorted Lists](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
[动画解释](https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/)
### Two point
双指针模板
```
// Initialize slow & fast pointers
ListNode slow = head;
ListNode fast = head;
/**
 * Change this condition to fit specific problem.
 * Attention: remember to avoid null-pointer error
 **/
while (slow != null && fast != null && fast.next != null) {
    slow = slow.next;           // move slow pointer one step each time
    fast = fast.next.next;      // move fast pointer two steps each time
    if (slow == fast) {         // change this condition to fit specific problem
        return true;
    }
}
return false;   // change return value to fit specific problem
```
1. 在调用 next 字段之前，始终检查节点是否为空。  
获取空节点的下一个节点将导致空指针错误。例如，在我们运行 fast = fast.next.next 之前，需要检查 fast 和 fast.next 不为空。

2. 仔细定义循环的结束条件。

* [判断是否有环](https://leetcode-cn.com/problems/linked-list-cycle/)  
**方法:**：快慢指针是否相遇
* 判断环的入口  
**方法**：从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点， 那么当这两个指针相遇的时候就是 环形入口的节点
* 判断环的长度
* 返回倒数第k个节点  
**方法:** 让一个指针先走k步，然后两个指针一起走, 前面的走完时，后面的指针的位置即在倒数第k个位置 
* 返回中间节点  
**方法:** 快慢指针，快2慢1，快指针到达尾部，慢指针的位置即为中间的位置。偶数时，慢指针落在中间的前一个位置上
* [链表相交](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)  
**方法：** 双指针，先得到两个链表的长度差，两个指针再从距尾部相同距离的位置遍历，则相交的位置即为所求位置
* [删除倒数第n个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)  
**方法：** 使用一个dummy节点解决删除头节点的问题 可用一个指针和一个记录长度的变量完成
* [反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)  
**方法：** 使用双指针，1)cur指向head, pre指向null, 2)用tmp保存curr的下个节点, 3)将curr.next指向pre, 4)pre和curr分别向后移动一步.
递归方法不懂 
* [奇偶链表](https://leetcode-cn.com/problems/odd-even-linked-list/)  
**方法：** 将奇节点放在一个链表里，偶链表放在另一个链表里。然后把偶链表接在奇链表的尾部。使用了3个指针。
* [回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)  
**方法：** 反转一半链表后，将两个链表的节点按顺序一一比较
* [旋转链表](https://leetcode-cn.com/problems/rotate-list/)  
**方法：** 先将链表变为环，再找出新的头节点，切断环
  
1) [2. Add Two Numbers](https://leetcode-cn.com/problems/add-two-numbers/)
## 递归
1. [21. Merge Two Sorted Lists](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
[动画解释](https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/)
2. [24. Swap Nodes in Pairs](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)
3. [92. Reverse Linked List II](https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/)
# 3. Array
## 双指针
1) [283. Move Zeroes](https://leetcode-cn.com/problems/move-zeroes/)  
[解法](https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/)
2) [26. Remove Duplicates from Sorted Array](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)  
[题解](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/)
   
3) [11. Container With Most Water](https://leetcode-cn.com/problems/container-with-most-water/)
4) [15. 3Sum](https://leetcode-cn.com/problems/3sum/)
如何避免重复的结果? 排序!
   
5) [16. 3Sum Closest](https://leetcode-cn.com/problems/3sum-closest/)

# Binary Search
二分查找一般由三个主要部分组成：
1) 预处理 —— 如果集合未排序，则进行排序。
2) 二分查找 —— 使用循环或递归在每次比较后将查找空间划分为两半。
3) 后处理 —— 在剩余空间中确定可行的候选者。
## 模板 1
```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length - 1;
  while(left <= right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid - 1; }
  }

  // End Condition: left > right
  return -1;
}
```
区分语法

- 初始条件：left = 0, right = length-1
- 终止：left > right
- 向左查找：right = mid-1
- 向右查找：left = mid+1

## 模板二
```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length;
  while(left < right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid; }
  }

  // Post-processing:
  // End Condition: left == right
  if(left != nums.length && nums[left] == target) return left;
  return -1;
}
```

### 区分语法

- 初始条件：left = 0, right = length
- 终止：left == right
- 向左查找：right = mid
- 向右查找：left = mid+1

## 模板三
```java
int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0)
        return -1;

    int left = 0, right = nums.length - 1;
    while (left + 1 < right){
        // Prevent (left + right) overflow
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }

    // Post-processing:
    // End Condition: left + 1 == right
    if(nums[left] == target) return left;
    if(nums[right] == target) return right;
    return -1;
}
```
区分语法

- 初始条件：left = 0, right = length-1
- 终止：left + 1 == right
- 向左查找：right = mid
- 向右查找：left = mid

## 题目
1) [局部有序二分查找 33. Search in Rotated Sorted Array](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
2) [153. Find Minimum in Rotated Sorted Array](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)
3) [34. Find First and Last Position of Element in Sorted Array](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
4) [没理解题目意思 658. Find K Closest Elements](https://leetcode-cn.com/problems/find-k-closest-elements/)

# 滑动窗口
1) [3. Longest Substring Without Repeating Characters](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

# String
1) [不懂 6. ZigZag Conversion](https://leetcode-cn.com/problems/zigzag-conversion/)

# Math and String
- `currChar - '0'`: 可将字符转为数字
- 将int转为字符串
    1) `String s = String.valueOf(a);`
    2) `String s1 = a + "";`
    3) `String s2 = Integer.toString(a);`

1) [7. Reverse Integer](https://leetcode-cn.com/problems/reverse-integer/)
[溢出](https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/)
   
2) [8. String to Integer (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)
3) [9. Palindrome Number](https://leetcode-cn.com/problems/palindrome-number/)
4) [28. Implement strStr()](https://leetcode-cn.com/problems/implement-strstr/)
> 涉及KMP算法

# 栈
1) [20. Valid Parentheses](https://leetcode-cn.com/problems/valid-parentheses/)