## 解题思路：

根据题目描述， 链表 $l_1$ , $l_2$ 是 **递增** 的，因此容易想到使用双指针 $l_1$ 和 $l_2$ 遍历两链表，根据 $l_1.val$ 和 $l_2.val$ 的大小关系确定节点添加顺序，两节点指针交替前进，直至遍历完毕。

**引入伪头节点：** 由于初始状态合并链表中无节点，因此循环第一轮时无法将节点添加到合并链表中。解决方案：初始化一个辅助节点 $dum$ 作为合并链表的伪头节点，将各节点添加至 $dum$ 之后。

![Picture1.png](https://pic.leetcode-cn.com/e4c8c97883da50d81498fd1f1e6cdd575429bd65f9f2babb00dc2b709f7ad8b2-Picture1.png){:width=400}

### 算法流程：

1. **初始化：** 伪头节点 $dum$ ，节点 $cur$ 指向 $dum$ 。
2. **循环合并：** 当 $l_1$ 或 $l_2$ 为空时跳出。
   1. 当 $l_1.val < l_2.val$ 时： $cur$ 的后继节点指定为 $l_1$ ，并 $l_1$ 向前走一步。
   2. 当 $l_1.val \geq l_2.val$ 时： $cur$ 的后继节点指定为 $l_2$ ，并 $l_2$ 向前走一步 。
   3. 节点 $cur$ 向前走一步，即 $cur = cur.next$ 。
3. **合并剩余尾部：** 跳出时有两种情况，即 $l_1$ 为空 **或** $l_2$ 为空。
   1. 若 $l_1 \ne null$ ： 将 $l_1$ 添加至节点 $cur$ 之后。
   2. 否则： 将 $l_2$ 添加至节点 $cur$ 之后。
4. **返回值：** 合并链表在伪头节点 $dum$ 之后，因此返回 $dum.next$ 即可。

<![Picture2.png](https://pic.leetcode-cn.com/8e45c2e2ff31973a3ea6dc610f8e3f0a9d4b9fcf8583560bdb1c05119aa7989e-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/05455e3fb731d5a7648e37c8c8457b0ceb150de3b0527a78f634b7a860c18027-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/e3ffa4ba33af05fcf44ea49f25c9e60aef5b3c3d3354153a28e4bfa4d1dc8efc-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/9129290dd20a1e08204ee2163827d1a8221504e793925706bd222c2bf6c0cf73-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/9f8886d4cee6c5388bf0bd6fb10cbdf221cda2d5ef0658cafd59b5ee40b8cf76-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/cb95607fe27ce4d33f0be29e3654fb493b3ef30a021b873224557e653b25c83e-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/2522ef8e15165bf431023944c21415aacdd5bb5f3a326e054afe719f381a5b7c-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/847b824db3b595061ef654d4f0371df28e7a8f1c659c171599272aab737b0aff-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/37df2fe55b9cb1f1014a545a5342a1612f7960c45058cc2ed1c11126008c2e76-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/07fd5c0b5fca93187466b8243dd43a16eed603c53a3e6582b7e7eaa1fe32c74c-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/3b7c0eb170a0cbcb6b82f3f1f8d6847edaaa9a7a92c3cb7a6c7c2e48f5fa8e9f-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/a205af9de048c533b61719f86f64b3df6b91ad3b61343d6111439dca86e65110-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/a92a8e0154079d0aafed45c6a5a5f72079bf05c2246c9655f9c7e593eaebdaf1-Picture14.png),![Picture15.png](https://pic.leetcode-cn.com/e3f9ea9e458d4fbe1e79002648df4b317c14a56426baa3b417078ead13b1537b-Picture15.png),![Picture16.png](https://pic.leetcode-cn.com/16d64263051da9ac16aafec27694f8c925c5f4f0cc854e494ce21b3065f4411f-Picture16.png),![Picture17.png](https://pic.leetcode-cn.com/e6716316657e534835459fb5c3df99c5b8873da3a67af1eb1b9e27837245087e-Picture17.png)>

## 代码：

Python 三元表达式写法 `A if x else B` ，代表当 $x = True$ 时执行 $A$ ，否则执行 $B$ 。

```Python []
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        cur = dum = ListNode(0)
        while list1 and list2:
            if list1.val < list2.val:
                cur.next, list1 = list1, list1.next
            else:
                cur.next, list2 = list2, list2.next
            cur = cur.next
        cur.next = list1 if list1 else list2
        return dum.next
```

```Java []
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dum.next;
    }
}
```

```C++ []
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* dum = new ListNode(0);
        ListNode* cur = dum;
        while (list1 != nullptr && list2 != nullptr) {
            if (list1->val < list2->val) {
                cur->next = list1;
                list1 = list1->next;
            }
            else {
                cur->next = list2;
                list2 = list2->next;
            }
            cur = cur->next;
        }
        cur->next = list1 != nullptr ? list1 : list2;
        return dum->next;
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(M+N)$ ：** $M, N$ 分别为链表 $l_1$, $l_2$ 的长度，合并操作需遍历两链表。
- **空间复杂度 $O(1)$ ：** 节点引用 $dum$ , $cur$ 使用常数大小的额外空间。
