## 解题思路：

如下图所示，题目要求实现链表所有「值 $< x$ 节点」出现在「值 $\geq x$ 节点」前面。

![ccw-02-04.001.png](https://pic.leetcode-cn.com/1642327155-ZeSkst-ccw-02-04.001.png)

根据题意，考虑通过「新建两个链表」实现原链表分割，算法流程为：

1. 新建两个链表  `sml_dummy` , `big_dummy` ，分别用于添加所有「节点值 $< x$ 」、「节点值 $\geq x$ 」的节点。
2. 遍历链表 `head` 并依次比较各节点值 `head.val` 和 $x$ 的大小：
   1. 若 `head.val < x` ，则将节点 `head` 添加至链表 `sml_dummy` 最后面；
   2. 若 `head.val >= x` ，则将节点 `head` 添加至链表 `big_dummy` 最后面；
3. 遍历完成后，拼接 `sml_dummy` 和 `big_dummy` 链表。
4. 最终返回头节点 `sml_dummy.next` 即可。

<![ccw-02-04.002.png](https://pic.leetcode-cn.com/1642327155-xLTdTX-ccw-02-04.002.png),![ccw-02-04.003.png](https://pic.leetcode-cn.com/1642327155-jJlwxG-ccw-02-04.003.png),![ccw-02-04.004.png](https://pic.leetcode-cn.com/1642327155-dicsYf-ccw-02-04.004.png),![ccw-02-04.005.png](https://pic.leetcode-cn.com/1642327155-KosKZc-ccw-02-04.005.png),![ccw-02-04.006.png](https://pic.leetcode-cn.com/1642327155-evywNA-ccw-02-04.006.png),![ccw-02-04.007.png](https://pic.leetcode-cn.com/1642327155-sdwSde-ccw-02-04.007.png),![ccw-02-04.008.png](https://pic.leetcode-cn.com/1642327155-BxynoK-ccw-02-04.008.png),![ccw-02-04.009.png](https://pic.leetcode-cn.com/1642327155-MYEJFo-ccw-02-04.009.png),![ccw-02-04.010.png](https://pic.leetcode-cn.com/1642327155-LdwqVO-ccw-02-04.010.png),![ccw-02-04.011.png](https://pic.leetcode-cn.com/1642327155-NxYFeF-ccw-02-04.011.png),![ccw-02-04.012.png](https://pic.leetcode-cn.com/1642327155-zogRwU-ccw-02-04.012.png),![ccw-02-04.013.png](https://pic.leetcode-cn.com/1642327155-sLExdO-ccw-02-04.013.png),![ccw-02-04.014.png](https://pic.leetcode-cn.com/1642327155-wIQrOv-ccw-02-04.014.png),![ccw-02-04.015.png](https://pic.leetcode-cn.com/1642327155-FkWiMG-ccw-02-04.015.png),![ccw-02-04.016.png](https://pic.leetcode-cn.com/1642327155-hIruVw-ccw-02-04.016.png),![ccw-02-04.017.png](https://pic.leetcode-cn.com/1642327155-wrsDFm-ccw-02-04.017.png),![ccw-02-04.018.png](https://pic.leetcode-cn.com/1642327155-lBdwnV-ccw-02-04.018.png),![ccw-02-04.019.png](https://pic.leetcode-cn.com/1642327155-qsNphx-ccw-02-04.019.png),![ccw-02-04.020.png](https://pic.leetcode-cn.com/1642327155-yCXnFe-ccw-02-04.020.png),![ccw-02-04.021.png](https://pic.leetcode-cn.com/1642327155-OakeVD-ccw-02-04.021.png),![ccw-02-04.022.png](https://pic.leetcode-cn.com/1642327155-KiYlVi-ccw-02-04.022.png)>

## 代码：

> 后三个 Tab 为「代码注释解析」。

```Python []
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        sml_dummy, big_dummy = ListNode(0), ListNode(0)
        sml, big = sml_dummy, big_dummy
        while head:
            if head.val < x:
                sml.next = head
                sml = sml.next
            else:
                big.next = head
                big = big.next
            head = head.next
        sml.next = big_dummy.next
        big.next = None
        return sml_dummy.next
```

```Java []
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smlDummy = new ListNode(0), bigDummy = new ListNode(0);
        ListNode sml = smlDummy, big = bigDummy;
        while (head != null) {
            if (head.val < x) {
                sml.next = head;
                sml = sml.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        sml.next = bigDummy.next;
        big.next = null;
        return smlDummy.next;
    }
}
```

```C++ []
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode *smlDummy = new ListNode(0), *bigDummy = new ListNode(0);
        ListNode *sml = smlDummy, *big = bigDummy;
        while (head != nullptr) {
            if (head->val < x) {
                sml->next = head;
                sml = sml->next;
            } else {
                big->next = head;
                big = big->next;
            }
            head = head->next;
        }
        sml->next = bigDummy->next;
        big->next = nullptr;
        return smlDummy->next;
    }
};
```

```Python []
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        # 新建两个链表
        sml_dummy, big_dummy = ListNode(0), ListNode(0)
        # 遍历链表
        sml, big = sml_dummy, big_dummy
        while head:
            # 将 < x 的节点加入 sml 节点后
            if head.val < x:
                sml.next = head
                sml = sml.next
            # 将 >= x 的节点加入 big 节点后
            else:
                big.next = head
                big = big.next
            head = head.next
        # 拼接两链表
        sml.next = big_dummy.next
        big.next = None
        return sml_dummy.next
```

```Java []
class Solution {
    public ListNode partition(ListNode head, int x) {
        // 新建两个链表
        ListNode smlDummy = new ListNode(0), bigDummy = new ListNode(0);
        // 遍历链表
        ListNode sml = smlDummy, big = bigDummy;
        while (head != null) {
            // 将 < x 的节点加入 sml 节点后
            if (head.val < x) {
                sml.next = head;
                sml = sml.next;
            // 将 >= x 的节点加入 big 节点后
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        // 拼接两链表
        sml.next = bigDummy.next;
        big.next = null;
        return smlDummy.next;
    }
}
```

```C++ []
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        // 新建两个链表
        ListNode *smlDummy = new ListNode(0), *bigDummy = new ListNode(0);
        // 遍历链表
        ListNode *sml = smlDummy, *big = bigDummy;
        while (head != nullptr) {
            // 将 < x 的节点加入 sml 节点后
            if (head->val < x) {
                sml->next = head;
                sml = sml->next;
            // 将 >= x 的节点加入 big 节点后
            } else {
                big->next = head;
                big = big->next;
            }
            head = head->next;
        }
        // 拼接两链表
        sml->next = bigDummy->next;
        big->next = nullptr;
        return smlDummy->next;
    }
};
```

### 复杂度分析：

**时间复杂度 $O(N)$ ：** 其中 $N$ 为链表长度；遍历链表使用线性时间。

**空间复杂度 $O(1)$ ：** 假头节点使用常数大小的额外空间。
