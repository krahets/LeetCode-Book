## 解题思路：

如下图所示，题目要求将链表反转。本文介绍迭代（双指针）、递归两种实现方法。

![Picture1.png](https://pic.leetcode-cn.com/1604779288-WXygqL-Picture1.png){:width=400}

## 方法一：迭代（双指针）

考虑遍历链表，并在访问各节点时修改 `next` 引用指向，算法流程见注释。

<![Picture2.png](https://pic.leetcode-cn.com/1604779288-fMPcDn-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/1604779288-jExDGV-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1604779444-fENrGT-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1604779288-GaydTj-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1604779288-gowIkz-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1604779288-VWjYQd-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1604779288-DyVPZm-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1604779288-yyhJIv-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1604779288-nZLbad-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/1604779288-OLQNEW-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/1604779288-MHParU-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/1604779288-CaAUfb-Picture13.png)>

### 代码：

```Python []
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        cur, pre = head, None
        while cur:
            tmp = cur.next # 暂存后继节点 cur.next
            cur.next = pre # 修改 next 引用指向
            pre = cur      # pre 暂存 cur
            cur = tmp      # cur 访问下一节点
        return pre
```

```Java []
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while(cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }
}
```

```C++ []
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode *cur = head, *pre = nullptr;
        while(cur != nullptr) {
            ListNode* tmp = cur->next; // 暂存后继节点 cur.next
            cur->next = pre;           // 修改 next 引用指向
            pre = cur;                 // pre 暂存 cur
            cur = tmp;                 // cur 访问下一节点
        }
        return pre;
    }
};
```

利用 Python 语言的平行赋值语法，可以进一步简化代码（但可读性下降）：

```Python []
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        cur, pre = head, None
        while cur:
            cur.next, pre, cur = pre, cur, cur.next
        return pre
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 遍历链表使用线性大小时间。
- **空间复杂度 $O(1)$ ：** 变量 `pre` 和 `cur` 使用常数大小额外空间。

## 方法二：递归

考虑使用递归法遍历链表，当越过尾节点后终止递归，在回溯时修改各节点的 `next` 引用指向。

### `recur(cur, pre)` 递归函数：

1. 终止条件：当 `cur` 为空，则返回尾节点 `pre` （即反转链表的头节点）；
2. 递归后继节点，记录返回值（即反转链表的头节点）为 `res` ；
3. 修改当前节点 `cur` 引用指向前驱节点 `pre` ；
4. 返回反转链表的头节点 `res` ；

### `reverseList(head)` 函数：

调用并返回 `recur(head, null)` 。传入 `null` 是因为反转链表后， `head` 节点指向 `null` ；

<![Picture14.png](https://pic.leetcode-cn.com/1604779288-qqLwjR-Picture14.png),![Picture15.png](https://pic.leetcode-cn.com/1604779288-ZENdRv-Picture15.png),![Picture16.png](https://pic.leetcode-cn.com/1604779288-seTNVj-Picture16.png),![Picture17.png](https://pic.leetcode-cn.com/1604779288-sLdyLs-Picture17.png),![Picture18.png](https://pic.leetcode-cn.com/1604779288-jxqzsM-Picture18.png),![Picture19.png](https://pic.leetcode-cn.com/1604779288-ezRpYf-Picture19.png),![Picture20.png](https://pic.leetcode-cn.com/1604779288-CupRFr-Picture20.png),![Picture21.png](https://pic.leetcode-cn.com/1604779288-fEyTvV-Picture21.png),![Picture22.png](https://pic.leetcode-cn.com/1604779288-ZoKASJ-Picture22.png),![Picture23.png](https://pic.leetcode-cn.com/1604779700-EVamXi-Picture23.png),![Picture24.png](https://pic.leetcode-cn.com/1604779700-APVBqI-Picture24.png),![Picture25.png](https://pic.leetcode-cn.com/1604779700-zBKSUx-Picture25.png)>

### 代码：

```Python []
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        def recur(cur, pre):
            if not cur: return pre     # 终止条件
            res = recur(cur.next, cur) # 递归后继节点
            cur.next = pre             # 修改节点引用指向
            return res                 # 返回反转链表的头节点
        
        return recur(head, None)       # 调用递归并返回
```

```Java []
class Solution {
    public ListNode reverseList(ListNode head) {
        return recur(head, null);    // 调用递归并返回
    }
    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = recur(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }
}
```

```C++ []
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        return recur(head, nullptr);           // 调用递归并返回
    }
private:
    ListNode* recur(ListNode* cur, ListNode* pre) {
        if (cur == nullptr) return pre;        // 终止条件
        ListNode* res = recur(cur->next, cur); // 递归后继节点
        cur->next = pre;                       // 修改节点引用指向
        return res;                            // 返回反转链表的头节点
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 遍历链表使用线性大小时间。
- **空间复杂度 $O(N)$ ：** 遍历链表的递归深度达到 $N$ ，系统使用 $O(N)$ 大小额外空间。
