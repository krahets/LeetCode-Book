### 解题思路：

- 这类链表题目一般都是使用双指针法解决的，例如寻找距离尾部第 `K` 个节点、寻找环入口、寻找公共尾部入口等。

##### 算法流程：

1. **双指针第一次相遇：** 设两指针 `fast`，`slow` 指向链表头部 `head`，`fast` 每轮走 $2$ 步，`slow` 每轮走 $1$ 步；

   1. **第一种结果：** `fast` 指针走过链表末端，说明链表无环，直接返回 `null`；

      - TIPS: 若有环，两指针一定会相遇。因为每走 $1$ 轮，`fast` 与 `slow` 的间距 $+1$，`fast` 终会追上 `slow`；

   2. **第二种结果：** 当`fast == slow`时， 两指针在环中 **第一次相遇** 。下面分析此时`fast` 与 `slow`走过的 **步数关系** ：

      - 设链表共有 $a+b$ 个节点，其中 **链表头部到链表入口** 有 $a$ 个节点（不计链表入口节点）， **链表环** 有 $b$ 个节点（这里需要注意，$a$ 和 $b$ 是未知数，例如图解上链表 $a=4$ , $b=5$）；设两指针分别走了 $f$，$s$ 步，则有：

      1. `fast` 走的步数是`slow`步数的 $2$ 倍，即 $f = 2s$；（**解析：** `fast` 每轮走 $2$ 步）
      2. `fast` 比 `slow`多走了 $n$ 个环的长度，即 $f = s + nb$；（ **解析：** 双指针都走过 $a$ 步，然后在环内绕圈直到重合，重合时 `fast` 比 `slow` 多走 **环的长度整数倍** ）；

      - 以上两式相减得：$f = 2nb$，$s = nb$，即`fast`和`slow` 指针分别走了 $2n$，$n$ 个 **环的周长** （注意： $n$  是未知数，不同链表的情况不同）。

2. **目前情况分析：** 

   - 如果让指针从链表头部一直向前走并统计步数`k`，那么所有 **走到链表入口节点时的步数** 是：`k=a+nb`（先走 $a$ 步到入口节点，之后每绕 $1$ 圈环（ $b$ 步）都会再次到入口节点）。
   - 而目前，`slow` 指针走过的步数为 $nb$ 步。因此，我们只要想办法让 `slow` 再走  $a$  步停下来，就可以到环的入口。
   - 但是我们不知道 $a$  的值，该怎么办？依然是使用双指针法。我们构建一个指针，此指针需要有以下性质：此指针和`slow` 一起向前走 `a` 步后，两者在入口节点重合。那么从哪里走到入口节点需要 $a$ 步？答案是链表头部`head`。

3. **双指针第二次相遇：**

   - `slow`指针 **位置不变** ，将`fast`指针重新 **指向链表头部节点** ；`slow`和`fast`同时每轮向前走 $1$ 步；
     - TIPS：此时 $f = 0$，$s = nb$ ；
   - 当 `fast` 指针走到$f = a$ 步时，`slow` 指针走到步$s = a+nb$，此时 **两指针重合，并同时指向链表环入口** 。

4. **返回`slow`指针指向的节点。**

##### **复杂度分析：**

- **时间复杂度** $O(N)$ ：第二次相遇中，慢指针须走步数 $a < a + b$；第一次相遇中，慢指针须走步数 $a + b - x < a + b$，其中 $x$ 为双指针重合点与环入口距离；因此总体为线性复杂度；
- **空间复杂度** $O(1)$ ：双指针使用常数大小的额外空间。

<![Picture1.png](https://pic.leetcode-cn.com/a4788076d4f3ad247c2023f92bb1585d05c5132ece7ed1205e2e171e25648adc-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/4ccc10d8af901acf43f4db0e5cd0e3c537aeb2346f57ad66c92cb9cbba0f1f73-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/5bfd893f81962daed27dd9fc3c96e426b168f4e940e5ab7541c323ee416548ec-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/387bfbbe71b3f1d462f72472b8168b894b7c41907e8a66bb770cd7a7ad04d48d-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/54d3a446f6acf92de2e51e639fb4f05abffa468334a778bd74c63f990cd73276-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/9a319387f7fe8d3c3acb9d6bc0bc9f7471ccff6699115db724a99d2acb7b68ca-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/f3977a8e28b45952e01334c1c86d70e3e822c913f81318108052aea81e365788-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/114969493875dcdca1d1bea8fb997643975d25b4ddb185dd071a185ed435cccd-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/c7ab2f7023d5f8c7fcae71280b56c1ec6acf65f634ef82d61713fcff1ea2ee75-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/af490a825982d42be6baf7e87a3e1cf181420bb9f46aa0ccbb190719c8b4dd92-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/f31767986757b751bfec07f824714044611b4a54bf8e794b2f4684a175dde044-Picture11.png)>{:width=500}
{:align=center}

### 代码：

```Python []
class Solution(object):
    def detectCycle(self, head):
        fast, slow = head, head
        while True:
            if not (fast and fast.next): return
            fast, slow = fast.next.next, slow.next
            if fast == slow: break
        fast = head
        while fast != slow:
            fast, slow = fast.next, slow.next
        return fast
```

```Java []
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
```
