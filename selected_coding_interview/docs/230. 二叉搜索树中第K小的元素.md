## 解题思路：

在二叉搜索树中，任意子节点都满足“左子节点 $<$ 根节点 $<$ 右子节点”的规则。因此二叉搜索树具有一个重要性质：**二叉搜索树的中序遍历为递增序列**。

也就是说，本题可被转化为求中序遍历的第 $k$ 个节点。

![Picture1.png](https://pic.leetcode.cn/1690460306-SMjxpo-Picture1.png){:width=500}

为求第 $k$ 个节点，需要实现以下三项工作：

1. 递归遍历时计数，统计当前节点的序号。
2. 递归到第 $k$ 个节点时，应记录结果 $res$ 。
3. 记录结果后，后续的遍历即失去意义，应提前返回。

## 代码：

题目指出：$1 \leq k \leq N$ （二叉搜索树节点个数）；因此无需考虑 $k > N$ 的情况。
若考虑，可以在中序遍历完成后判断 $k > 0$ 是否成立，若成立则说明 $k > N$ 。

```Python []
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def dfs(root):
            if not root: return
            dfs(root.left)
            if self.k == 0: return
            self.k -= 1
            if self.k == 0: self.res = root.val
            dfs(root.right)

        self.k = k
        dfs(root)
        return self.res
```

```Java []
class Solution {
    int res, k;
    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
}
```

```C++ []
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        this->k = k;
        dfs(root);
        return res;
    }
private:
    int res, k;
    void dfs(TreeNode* root) {
        if (root == nullptr) return;
        dfs(root->left);
        if (k == 0) return;
        if (--k == 0) res = root->val;
        dfs(root->right);
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 当树退化为链表，即全部为左子节点时，无论 $k$ 的值大小，递归深度都为 $N$ ，使用 $O(N)$ 时间。
- **空间复杂度 $O(N)$ ：**  当树退化为链表时，系统使用 $O(N)$ 大小的栈空间。
