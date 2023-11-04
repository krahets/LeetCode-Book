## 解题思路：

**I. 按层打印：** 题目要求的二叉树的 **从上至下** 打印（即按层打印），又称为二叉树的 **广度优先搜索**（BFS）。BFS 通常借助 **队列** 的先入先出特性来实现。

**II. 每层打印到一行：** 将本层全部节点打印到一行，并将下一层全部节点加入队列，以此类推，即可分为多行打印。

![Picture1.png](https://pic.leetcode-cn.com/a58477c74c96779c265ce3028def7625d16042895d2c21f7fb0293df7b213276-Picture1.png){:width=400}

### 算法流程：

1. **特例处理：** 当根节点为空，则返回空列表 `[]` 。
2. **初始化：** 打印结果列表 `res = []` ，包含根节点的队列 `queue = [root]` 。
3. **BFS 循环：** 当队列 `queue` 为空时跳出。
   1. 新建一个临时列表 `tmp` ，用于存储当前层打印结果。
   2. **当前层打印循环：** 循环次数为当前层节点数（即队列 `queue` 长度）。
      1. **出队：** 队首元素出队，记为 `node`。
      2. **打印：** 将 `node.val` 添加至 `tmp` 尾部。
      3. **添加子节点：** 若 `node` 的左（右）子节点不为空，则将左（右）子节点加入队列 `queue` 。
   3. 将当前层结果 `tmp` 添加入 `res` 。
4. **返回值：** 返回打印结果列表 `res` 即可。

<![Picture2.png](https://pic.leetcode-cn.com/2aaa6b8a29c2cc3b5bf90cafc2a2d26c3fa0691ea9ad3d2139826c9fa20e5325-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/af416e73f4c3ee15a92e895697f1e8da09a225958db3697ae68083dfd835a5b0-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/435a8f39b8365bf7fdbdac6ad3f952d3d86552703cf6c6d8986811d23cef41ee-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/5bb17b9bdbe2b6f2cc82adfa80beb09a269ee1988c87e0301f8104e0e3ea72fb-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/5ecd431e77936c8cfdfe67ce18592ba3b1bd786818fed8728dc4c1303de5029e-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/aaa30c224754d66181d906fca0989e4e3c78b4359659a9e5627339993642fc47-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/8bd6149dc6b5245b652e55aa86f311fceed164058b70a56eb859a0e94f1e5884-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/9dc9b25624dc3a2e34498df7e0ad62fb4d4f1344b8a357000316d30da66ea1d2-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/12083cf216791dc6dbe6261feb1677dc9548215f6739a4465fd0aa042faa1284-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/87e1cd8e79655516f5881421153b16d8dbb3f4aea59d925b0aa89016cfc690b0-Picture11.png)>

## 代码：

Python 中使用 collections 中的双端队列 `deque()` ，其 `popleft()` 方法可达到 $O(1)$ 时间复杂度；列表 list 的 `pop(0)` 方法时间复杂度为 $O(N)$ 。

```Python []
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        res, queue = [], collections.deque()
        queue.append(root)
        while queue:
            tmp = []
            for _ in range(len(queue)):
                node = queue.popleft()
                tmp.append(node.val)
                if node.left: queue.append(node.left)
                if node.right: queue.append(node.right)
            res.append(tmp)
        return res
```

```Java []
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
```

```C++ []
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode*> que;
        vector<vector<int>> res;
        if (root != nullptr) que.push(root);
        while (!que.empty()) {
            vector<int> tmp;
            for(int i = que.size(); i > 0; --i) {
                root = que.front();
                que.pop();
                tmp.push_back(root->val);
                if (root->left != nullptr) que.push(root->left);
                if (root->right != nullptr) que.push(root->right);
            }
            res.push_back(tmp);
        }
        return res;
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** $N$ 为二叉树的节点数量，即 BFS 需循环 $N$ 次。
- **空间复杂度 $O(N)$ ：** 最差情况下，即当树为平衡二叉树时，最多有 $N/2$ 个树节点**同时**在 `queue` 中，使用 $O(N)$ 大小的额外空间。
