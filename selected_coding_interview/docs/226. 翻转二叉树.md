## 解题思路：

**二叉树镜像定义：** 对于二叉树中任意节点 $root$ ，设其左 / 右子节点分别为 $left, right$ ；则在二叉树的镜像中的对应 $root$ 节点，其左 / 右子节点分别为 $right, left$ 。

![Picture1.png](https://pic.leetcode-cn.com/20717714d97fa04d509e4f0525a3089efefc2ea02cc08ce92b77978e9b51f15f-Picture1.png){:width=450}

## 方法一：递归法

根据二叉树镜像的定义，考虑递归遍历（dfs）二叉树，交换每个节点的左 / 右子节点，即可生成二叉树的镜像。

### 递归解析：

1. **终止条件：** 当节点 $root$ 为空时（即越过叶节点），则返回 $null$ 。
2. **递推工作：**
   1. 初始化节点 $tmp$ ，用于暂存 $root$ 的左子节点。
   2. 开启递归 **右子节点** $invertTree(root.right)$ ，并将返回值作为 $root$ 的 **左子节点** 。
   3. 开启递归 **左子节点** $invertTree(tmp)$ ，并将返回值作为 $root$ 的 **右子节点** 。
3. **返回值：** 返回当前节点 $root$ 。

> **Q：** 为何需要暂存 $root$ 的左子节点？
> **A：** 在递归右子节点 “$root.left = invertTree(root.right);$” 执行完毕后， $root.left$ 的值已经发生改变，此时递归左子节点 $invertTree(root.left)$ 则会出问题。

<![Picture2.png](https://pic.leetcode-cn.com/c252a2c9792a0998d0560be8e882db3ad1f2e106b0d56c76fdfef219e55e4ea3-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/3cbcd2849f6ff770d6da0b833b12e301cc5f0a7f9ac6bd42cb10d05485c2d556-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/cd0030363c59130f0148c10ae2429315df94ad0784eb770d7754ee6dc7c18a99-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/bb5609047b8d25d3ecd025788f91cf20c32dcdb2c1567ec765d47aa75b5e4312-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/43eece405220d52a5e988d521858b80f26974157fa2e8a8a9ae4be24ad516e3c-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/507baf32a66f6c69eaba911c177e69591f1e7fed82d5c0cd31632d03b6d0cb73-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/fe80c840e08c4c2778f1fc784729721212bf5a626c94f13828c5bd13ff834646-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/44d8152ca5f18dcefa70eae07ca544ce45c83dd3d6bed5a8954e5bf2b0591b82-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/9f1205d9bf6419c18e88de1494ca67d1328184d7fc3a7b10ea2d18b2f192831c-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/c15e0ee4b1aaf37219c05c1663947159d92ce8315cd08e373db72ed76a8faf28-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/8004f1d71e6cdf27463fd4b88fffa73570bcfc59b368e7b45c71d63cfbb57c22-Picture12.png)>

### 代码：

Python 利用平行赋值的写法（即 $a, b = b, a$ ），可省略暂存操作。其原理是先将等号右侧打包成元组 $(b,a)$ ，再序列地分给等号左侧的 $a, b$ 序列。

```Python []
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return
        tmp = root.left
        root.left = self.invertTree(root.right)
        root.right = self.invertTree(tmp)
        return root
```

```Python []
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return
        root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
        return root
```

```Java []
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
```

```C++ []
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (root == nullptr) return nullptr;
        TreeNode* tmp = root->left;
        root->left = invertTree(root->right);
        root->right = invertTree(tmp);
        return root;
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 其中 $N$ 为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 $O(N)$ 时间。
- **空间复杂度 $O(N)$ ：** 最差情况下（当二叉树退化为链表），递归时系统需使用 $O(N)$ 大小的栈空间。

## 方法二：辅助栈（或队列）

利用栈（或队列）遍历树的所有节点 $node$ ，并交换每个 $node$ 的左 / 右子节点。

### 算法流程：

1. **特例处理：** 当 $root$ 为空时，直接返回 $null$ 。
2. **初始化：** 栈（或队列），本文用栈，并加入根节点 $root$ 。
3. **循环交换：** 当栈 $stack$ 为空时跳出。
   1. **出栈：** 记为 $node$ 。
   2. **添加子节点：** 将 $node$ 左和右子节点入栈。
   3. **交换：** 交换 $node$ 的左 / 右子节点。
4. **返回值：** 返回根节点 $root$ 。

<![Picture13.png](https://pic.leetcode-cn.com/81331bdc63b4c5d6c86463656ba00132496eaf099575b2e18221d6e048661d37-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/99b4c84f372970f8d80c06f34fba5f0749595bdac93778a50053be6f541cfa0d-Picture14.png),![Picture15.png](https://pic.leetcode-cn.com/5503d4ed061383c4e2c01434ce1915d1f8c6fe3c4012cdf4abcdfc3ec86060e2-Picture15.png),![Picture16.png](https://pic.leetcode-cn.com/d9f0b2915de7a92e085ea02560b07b415fd037ac7eefb75771210662ed8f78b4-Picture16.png),![Picture17.png](https://pic.leetcode-cn.com/c8153b754fafb628ad4c1ed9c18e3aabc5f90d21edf5a44ec0ced28fd7d47ac6-Picture17.png),![Picture18.png](https://pic.leetcode-cn.com/861a0a9ba4447757052e2c3e5024fb1cc22b51b851e0adf529c98a9c81127302-Picture18.png),![Picture19.png](https://pic.leetcode-cn.com/7f8cee99b8b07eda3e6e1eb492e046a001081fe50ea41d69856c8997a456afbc-Picture19.png),![Picture20.png](https://pic.leetcode-cn.com/ead0526a3bce7844986c50ba9d8b84b88e5de99f3cf24bc8f875b09388f9c10e-Picture20.png),![Picture21.png](https://pic.leetcode-cn.com/d760f2955e791989e7bea2c8cf5215cc3f37174d7549cc9568624297d9454e80-Picture21.png),![Picture22.png](https://pic.leetcode-cn.com/c45fbb856ba6dc8e482eefad674ce762fb5051a9ddcf04c20d7d95765aa0d268-Picture22.png),![Picture23.png](https://pic.leetcode-cn.com/b0c2b30dbfff1f95c6c23346ee4a7be585d6e6e88316de09f6ea26af175f3d02-Picture23.png),![Picture24.png](https://pic.leetcode-cn.com/5f53c023643258091591e0b9b59140592bbb295a64729f479f5c9381e2be6d68-Picture24.png),![Picture25.png](https://pic.leetcode-cn.com/e70dfd905f7f6940675941ef3380cf6fbf46bea448fbfba79b781816f78c841e-Picture25.png),![Picture26.png](https://pic.leetcode-cn.com/08705f9b4b36ee742cb09aca06303f458699b029dfba1b520f2374d7909322ee-Picture26.png),![Picture27.png](https://pic.leetcode-cn.com/d2f65256baa602a1b85e0d92c5a93c239ca96a1119196eda4140b1dfbbb4f1d3-Picture27.png)>

### 代码：

```Python []
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return
        stack = [root]
        while stack:
            node = stack.pop()
            if node.left: stack.append(node.left)
            if node.right: stack.append(node.right)
            node.left, node.right = node.right, node.left
        return root
```

```Java []
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>() {{ add(root); }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
```

```C++ []
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (root == nullptr) return nullptr;
        stack<TreeNode*> stack;
        stack.push(root);
        while (!stack.empty())
        {
            TreeNode* node = stack.top();
            stack.pop();
            if (node->left != nullptr) stack.push(node->left);
            if (node->right != nullptr) stack.push(node->right);
            TreeNode* tmp = node->left;
            node->left = node->right;
            node->right = tmp;
        }
        return root;
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 其中 $N$ 为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 $O(N)$ 时间。
- **空间复杂度 $O(N)$ ：** 如下图所示，最差情况下，栈 $stack$ 最多同时存储 $\frac{N + 1}{2}$ 个节点，占用 $O(N)$ 额外空间。

![Picture0.png](https://pic.leetcode-cn.com/1614450330-bTAcyj-Picture0.png){:width=450}
