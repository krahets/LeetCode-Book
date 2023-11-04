## 解题思路

考虑借助快慢双指针  `fast`,  `slow` ，「快指针 `fast`」每轮走 2 步，「慢指针 `slow`」每轮走 1 步。`fast` 的步数恒为 `slow` 的 2 倍，因此当快指针遍历完链表时，慢指针就指向链表中间节点。而由于长度为偶数的链表**有两个中间节点**，因此需要分两种情况考虑：

- **链表长度为奇数：** 当 `fast` 走到链表「尾节点」时，`slow` 正好走到「中间节点」。
- **链表长度为偶数：** 当 `fast` 走到「null」时（越过「尾节点」后），`slow` 正好走到「第二个中间节点」。

总结以上规律，应在当 `fast` **遇到或越过尾节点** 时跳出循环，并返回 `slow` 即可。

![figures.gif](https://pic.leetcode-cn.com/1656953441-Kshqch-figures.gif)

> 上为动态图，下为静态图，内容一致。

<![Slide1.png](https://pic.leetcode-cn.com/1656953445-SCzBMv-Slide1.png),![Slide2.png](https://pic.leetcode-cn.com/1656953445-xCVeYT-Slide2.png),![Slide3.png](https://pic.leetcode-cn.com/1656953445-iDjeeB-Slide3.png),![Slide4.png](https://pic.leetcode-cn.com/1656953445-NAeOKh-Slide4.png),![Slide5.png](https://pic.leetcode-cn.com/1656953445-ekLqlL-Slide5.png),![Slide6.png](https://pic.leetcode-cn.com/1656953445-ZzzYhl-Slide6.png),![Slide7.png](https://pic.leetcode-cn.com/1656953445-JLSUpj-Slide7.png)>

## 代码

**拓展思考：** 若题目要求返回「第一个中间节点」，则应在 `fast` **遇到尾节点或其前驱节点** 时跳出循环。此时，修改判断条件为 `while fast.next and fast.next.next` 即可。

```Python []
class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        return slow
```

```Java []
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

```C++ []
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode *fast = head, *slow = head;
        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
        }
        return slow;
    }
};
```

## 复杂度分析

- **时间复杂度 $O(N)$ ：** 其中 $N$ 为链表长度。 `fast` 遍历完链表需 $\frac{N}{2}$ 轮迭代，使用 $O(\frac{N}{2}) = O(N)$ 线性时间。
- **空间复杂度 $O(1)$ ：** 节点指针  `fast` , `slow` 使用常数大小空间。
