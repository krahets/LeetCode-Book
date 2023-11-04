## 解题思路：

普通情况：设前驱节点 `pre` 、当前节点 `cur` 、后继节点 `cur.next` ，则执行 `pre.next = cur.next` 可**将节点 `cur` 从链表中删除**。

![ccw-02-03.001.png](https://pic.leetcode-cn.com/1642318280-EhKkoi-ccw-02-03.001.png)

本题仅传入「待删除节点 `node` 」，由于普通链表只有「单向指针」，因此无法访问到 `node` 的「前驱节点」，进而无法使用以上方法删除节点 `node` 。

为了删除节点 `node` ，可使用以下方法：

1. 复制后继节点 `node.next` 的「节点值」至节点 `node` ；
2. 使用上述方法将 `node.next` 从链表中删除即可；

> 如下图所示，示例链表 $4 \rightarrow 5 \rightarrow 1 \rightarrow 9$ 和待删除节点 $5$ ，完成删除后链表变为 $4 \rightarrow 1 \rightarrow 9$ 。

<![ccw-02-03.002.png](https://pic.leetcode-cn.com/1642318280-aVKlYf-ccw-02-03.002.png),![ccw-02-03.003.png](https://pic.leetcode-cn.com/1642318280-hCxwrw-ccw-02-03.003.png),![ccw-02-03.004.png](https://pic.leetcode-cn.com/1642318280-LfvVjd-ccw-02-03.004.png)>

## 代码：

> 后三个 Tab 为「代码注释解析」。

```Python []
class Solution:
    def deleteNode(self, node):
        node.val = node.next.val
        node.next = node.next.next
```

```Java []
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```

```C++ []
class Solution {
public:
    void deleteNode(ListNode* node) {
        node->val = node->next->val;
        node->next = node->next->next;
    }
};
```

```Python []
class Solution:
    def deleteNode(self, node):
        # 复制 node.next 到 node
        node.val = node.next.val
        # 从链表中删除 node.next
        node.next = node.next.next
```

```Java []
class Solution {
    public void deleteNode(ListNode node) {
        // 复制 node.next 到 node
        node.val = node.next.val;
        // 从链表中删除 node.next
        node.next = node.next.next;
    }
}
```

```C++ []
class Solution {
public:
    void deleteNode(ListNode* node) {
        // 复制 node.next 到 node
        node->val = node->next->val;
        // 从链表中删除 node.next
        node->next = node->next->next;
    }
};
```

### 复杂度分析：

**时间复杂度 $O(1)$ ：** 使用常数时间。

**空间复杂度 $O(1)$ ：** 使用常数大小额外空间。
