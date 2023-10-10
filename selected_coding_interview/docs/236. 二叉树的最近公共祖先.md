#### 解题思路：

**祖先的定义：** 若节点 $p$ 在节点 $root$ 的左（右）子树中，或 $p = root$ ，则称 $root$ 是 $p$ 的祖先。

**最近公共祖先的定义：** 设节点 $root$ 为节点 $p, q$ 的某公共祖先，若其左子节点 $root.left$ 和右子节点 $root.right$ 都不是 $p,q$ 的公共祖先，则称 $root$ 是 “最近的公共祖先” 。

![Picture1.png](https://pic.leetcode-cn.com/1599885247-rxcHcZ-Picture1.png){:width=450}

根据以上定义，若 $root$ 是 $p, q$ 的 **最近公共祖先** ，则只可能为以下情况之一：

1. $p$ 和 $q$ 在 $root$ 的子树中，且分列 $root$ 的 **异侧**（即分别在左、右子树中）；
2. $p = root$ ，且 $q$ 在 $root$ 的左或右子树中；  
3. $q = root$ ，且 $p$ 在 $root$ 的左或右子树中；  

![Picture2.png](https://pic.leetcode-cn.com/1599885247-mgYjRv-Picture2.png){:width=450}

考虑通过递归对二叉树进行先序遍历，当遇到节点 $p$ 或 $q$ 时返回。从底至顶回溯，当节点 $p, q$ 在节点 $root$ 的异侧时，节点 $root$ 即为最近公共祖先，则向上返回 $root$ 。

##### 递归解析：

1. **终止条件：**
   1. 当越过叶节点，则直接返回 $null$ ；
   2. 当 $root$ 等于 $p, q$ ，则直接返回 $root$ ；
2. **递推工作：**
   1. 开启递归左子节点，返回值记为 $left$ ；
   2. 开启递归右子节点，返回值记为 $right$ ；
3. **返回值：** 根据 $left$ 和 $right$ ，可展开为四种情况；
   1. 当 $left$ 和 $right$ **同时为空** ：说明 $root$ 的左 / 右子树中都不包含 $p,q$ ，返回 $null$ ；
   2. 当 $left$ 和 $right$ **同时不为空** ：说明 $p, q$ 分列在 $root$ 的 **异侧** （分别在 左 / 右子树），因此 $root$ 为最近公共祖先，返回 $root$ ；
   3. 当 $left$ **为空** ，$right$ **不为空** ：$p,q$ 都不在 $root$ 的左子树中，直接返回 $right$ 。具体可分为两种情况：
      1. $p,q$ 其中一个在 $root$ 的 **右子树** 中，此时 $right$ 指向 $p$（假设为 $p$ ）； 
      2. $p,q$ 两节点都在 $root$ 的 **右子树** 中，此时的 $right$ 指向 **最近公共祖先节点** ；
   4. 当 $left$ **不为空** ， $right$ **为空** ：与情况 `3.` 同理；

> 观察发现， 情况 `1.` 可合并至 `3.` 和 `4.` 内，详见文章末尾代码。

<![Picture3.png](https://pic.leetcode-cn.com/1599885247-KpxUys-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1599885247-azGPkG-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1599885247-hIMEfJ-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1599885247-UMCTfd-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1599885247-SLOIAX-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1599885247-JGxmmL-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1599885247-lVrUTd-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1599885247-VTPazU-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/1599885247-KePYfU-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/1599885247-xkRUDm-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/1599885247-SFdLoP-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/1599885247-YOUEcd-Picture14.png),![Picture15.png](https://pic.leetcode-cn.com/1599885247-HcncTq-Picture15.png),![Picture16.png](https://pic.leetcode-cn.com/1599885247-oeFNkc-Picture16.png),![Picture17.png](https://pic.leetcode-cn.com/1599885247-DjiiMY-Picture17.png),![Picture18.png](https://pic.leetcode-cn.com/1599885247-SkpSEn-Picture18.png),![Picture19.png](https://pic.leetcode-cn.com/1599885247-jFDBar-Picture19.png),![Picture20.png](https://pic.leetcode-cn.com/1599885247-GEkXRi-Picture20.png)>

##### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 其中 $N$ 为二叉树节点数；最差情况下，需要递归遍历树的所有节点。
- **空间复杂度 $O(N)$ ：** 最差情况下，递归深度达到 $N$ ，系统使用 $O(N)$ 大小的额外空间。

##### 代码：

```Python []
class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        if not root or root == p or root == q: return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if not left: return right
        if not right: return left
        return root
```

```Java []
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
```

```C++ []
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == nullptr || root == p || root == q) return root;
        TreeNode *left = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);
        if(left == nullptr) return right;
        if(right == nullptr) return left;
        return root;
    }
};
```

情况 `1.` , `2.` , `3.` , `4.` 的展开写法如下。

```Python []
class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        if not root or root == p or root == q: return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if not left and not right: return # 1.
        if not left: return right # 3.
        if not right: return left # 4.
        return root # 2. if left and right:
```

```Java []
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }
}
```

```C++ []
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == nullptr || root == p || root == q) return root;
        TreeNode *left = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);
        if(left == nullptr && right == nullptr) return nullptr; // 1.
        if(left == nullptr) return right; // 3.
        if(right == nullptr) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }
};
```
