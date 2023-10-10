## 解题思路：

本题删除值为 `val` 的节点分需为两步：定位节点、修改引用。

1. **定位节点：** 遍历链表，直到 `head.val == val` 时跳出，即可定位目标节点。
2. **修改引用：** 设节点 `cur` 的前驱节点为 `pre` ，后继节点为 `cur.next` ；则执行 `pre.next = cur.next` ，即可实现删除 `cur` 节点。

![Picture1.png](https://pic.leetcode-cn.com/1613757478-NBOvjn-Picture1.png){:align=center width=450}

### 算法流程：

1. **特例处理：** 当应删除头节点 `head` 时，直接返回 `head.next` 即可。
2. **初始化：** `pre = head` , `cur = head.next` 。
3. **定位节点：** 当 `cur` 为空 **或** `cur` 节点值等于 `val` 时跳出。
   1. 保存当前节点索引，即 `pre = cur` 。
   2. 遍历下一节点，即 `cur = cur.next` 。
4. **删除节点：** 若 `cur` 指向某节点，则执行 `pre.next = cur.next` ；若 `cur` 指向 $\text{null}$ ，代表链表中不包含值为 `val` 的节点。
5. **返回值：** 返回链表头部节点 `head` 即可。

<![Picture2.png](https://pic.leetcode-cn.com/1599417705-BpuWiY-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/1599417705-RNAPbt-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1599417705-dIljCU-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1599417705-nRNZwN-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1599417705-XmugFY-Picture6.png)>

## 代码：

```Python []
class Solution:
    def deleteNode(self, head: ListNode, val: int) -> ListNode:
        if head.val == val: return head.next
        pre, cur = head, head.next
        while cur and cur.val != val:
            pre, cur = cur, cur.next
        if cur: pre.next = cur.next
        return head
```

```Java []
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }
}
```

```C++ []
class Solution {
public:
    ListNode* deleteNode(ListNode* head, int val) {
        if(head->val == val) return head->next;
        ListNode *pre = head, *cur = head->next;
        while(cur != nullptr && cur->val != val) {
            pre = cur;
            cur = cur->next;
        }
        if(cur != nullptr) pre->next = cur->next;
        return head;
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** $N$ 为链表长度，删除操作平均需循环 $N/2$ 次，最差 $N$ 次。
- **空间复杂度 $O(1)$ ：** `cur`, `pre` 占用常数大小额外空间。
