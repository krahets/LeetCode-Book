## 解题思路：

相比于上一题 [102. 二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/)，这道题额外要求 **打印顺序交替变化**。

![Picture1.png](https://pic.leetcode-cn.com/9513dcb034f5dcdea947a2f667b3d380df4f8732da6397778e00718b77584010-Picture1.png){:width=400}

## 方法一：层序遍历 + 双端队列

- 利用双端队列的两端皆可添加元素的特性，设打印列表（双端队列） `tmp` ，并规定：
  - 奇数层 则添加至 `tmp` **尾部** ，
  - 偶数层 则添加至 `tmp` **头部** 。

### 算法流程：

1. **特例处理：** 当树的根节点为空，则直接返回空列表 `[]` 。
2. **初始化：** 打印结果空列表 `res` ，包含根节点的双端队列 `deque` 。
3. **BFS 循环：** 当 `deque` 为空时跳出。
   1. 新建列表 `tmp` ，用于临时存储当前层打印结果。
   2. **当前层打印循环：** 循环次数为当前层节点数（即 `deque` 长度）。
      1. **出队：** 队首元素出队，记为 `node`。
      2. **打印：** 若为奇数层，将 `node.val` 添加至 `tmp` 尾部；否则，添加至 `tmp` 头部。
      3. **添加子节点：** 若 `node` 的左（右）子节点不为空，则加入 `deque` 。
   3. 将当前层结果 `tmp` 转化为 list 并添加入 `res` 。
4. **返回值：** 返回打印结果列表 `res` 即可。

<![Picture2.png](https://pic.leetcode-cn.com/f558b222e3ba3662d3582f114736a3a73e4ac49d3d7673b86be408479bdef524-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/a499d6c3fe9bef6be1ea4ae665e307b29eb608bb7d63dd7c143e9d91f4be76ac-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/568358dbc58b54a710c8f698250fe23519c2ccd0ceb3c098530b6aca67c3344c-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/598a4e9ace5854c0114130b349101add2b18e10120c57375fd69365892d57e17-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/60aacb8f27c26c46929f1ccd0ba56f340389eb4c370bf3669712fcf4117558e1-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/6c1cf508aa660f2fbb1bf724e8a1cab24eadf2889b83b7cfead07152c285a941-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/335f1930d37da63c1cedd0798a0c37d0b0b2901493c7fc476fc9ed2144c76b24-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/bec5d57e0a349ea209c22bb1cf9bb4ffc6a5b1bcfae79caa97fb9a87546f95c5-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/387355a0b771c69610119c4da142a1252baba3aab5a99e43ca387cedac162560-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/c9bbd82ee2727d3387cda111ea47146599acc5e984ad73a8260f56cb7deb11e4-Picture11.png)>

### 代码：

Python 中使用 collections 中的双端队列 `deque()` ，其 `popleft()` 方法可达到 $O(1)$ 时间复杂度；列表 list 的 `pop(0)` 方法时间复杂度为 $O(N)$ 。

Java 中将链表 LinkedList 作为双端队列使用。

```Python []
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        res, deque = [], collections.deque([root])
        while deque:
            tmp = collections.deque()
            for _ in range(len(deque)):
                node = deque.popleft()
                if len(res) % 2 == 0: tmp.append(node.val) # 奇数层 -> 插入队列尾部
                else: tmp.appendleft(node.val) # 偶数层 -> 插入队列头部
                if node.left: deque.append(node.left)
                if node.right: deque.append(node.right)
            res.append(list(tmp))
        return res
```

```Java []
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) tmp.addLast(node.val);
                else tmp.addFirst(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** $N$ 为二叉树的节点数量，即 BFS 需循环 $N$ 次，占用 $O(N)$ ；双端队列的队首和队尾的添加和删除操作的时间复杂度均为 $O(1)$ 。
- **空间复杂度 $O(N)$ ：** 最差情况下，即当树为满二叉树时，最多有 $N/2$ 个树节点 **同时** 在 `deque` 中，使用 $O(N)$ 大小的额外空间。

## 方法二：层序遍历 + 双端队列（奇偶层逻辑分离）

- 方法一代码简短、容易实现；但需要判断每个节点的所在层奇偶性，即冗余了 $N$ 次判断。
- 通过将奇偶层逻辑拆分，可以消除冗余的判断。

### 算法流程：

> 与方法一对比，仅 BFS 循环不同。

- **BFS 循环：** 循环打印奇 / 偶数层，当 `deque` 为空时跳出。
    1. **打印奇数层：** **从左向右** 打印，**先左后右** 加入下层节点。
    2. 若 `deque` 为空，说明向下无偶数层，则跳出。
    3. **打印偶数层：** **从右向左** 打印，**先右后左** 加入下层节点。

### 代码：

```Python []
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        res, deque = [], collections.deque()
        deque.append(root)
        while deque:
            tmp = []
            # 打印奇数层
            for _ in range(len(deque)):
                # 从左向右打印
                node = deque.popleft()
                tmp.append(node.val)
                # 先左后右加入下层节点
                if node.left: deque.append(node.left)
                if node.right: deque.append(node.right)
            res.append(tmp)
            if not deque: break # 若为空则提前跳出
            # 打印偶数层
            tmp = []
            for _ in range(len(deque)):
                # 从右向左打印
                node = deque.pop()
                tmp.append(node.val)
                # 先右后左加入下层节点
                if node.right: deque.appendleft(node.right)
                if node.left: deque.appendleft(node.left)
            res.append(tmp)
        return res
```

```Java []
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) deque.add(root);
        while (!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                // 先左后右加入下层节点
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            res.add(tmp);
            if (deque.isEmpty()) break; // 若为空则提前跳出
            // 打印偶数层
            tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                // 先右后左加入下层节点
                if (node.right != null) deque.addFirst(node.right);
                if (node.left != null) deque.addFirst(node.left);
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        deque<TreeNode*> deque;
        vector<vector<int>> res;
        if (root != NULL) deque.push_back(root);
        while (!deque.empty()) {
            // 打印奇数层
            vector<int> tmp;
            for(int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode* node = deque.front();
                deque.pop_front();
                tmp.push_back(node->val);
                // 先左后右加入下层节点
                if (node->left != NULL) deque.push_back(node->left);
                if (node->right != NULL) deque.push_back(node->right);
            }
            res.push_back(tmp);
            if (deque.empty()) break; // 若为空则提前跳出
            // 打印偶数层
            tmp.clear();
            for(int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode* node = deque.back();
                deque.pop_back();
                tmp.push_back(node->val);
                // 先右后左加入下层节点
                if (node->right != NULL) deque.push_front(node->right);
                if (node->left != NULL) deque.push_front(node->left);
            }
            res.push_back(tmp);
        }
        return res;
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 同方法一。
- **空间复杂度 $O(N)$ ：** 同方法一。

## 方法三：层序遍历 + 倒序

- 此方法的优点是只用列表即可，无需其他数据结构。
- **偶数层倒序：** 若 `res` 的长度为 **奇数** ，说明当前是偶数层，则对 `tmp` 执行 **倒序** 操作。

<![Picture12.png](https://pic.leetcode-cn.com/8e05160224f36ce5acb4ac9b96eaa141779b6b6d6153ae794082206ad5481f77-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/5bf8f63845dbbbe6a56e17a2dadf1b87d3f97e99702bdce1ad8eddfeadeeaa89-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/4d610a5b6b7375eaba712e73e96c8e29e5d041378332ca2e00e0a6415bfd3890-Picture14.png),![Picture15.png](https://pic.leetcode-cn.com/34d3a083c42f8eaa21eacb98f7f3d731b7264a1e424908788abe8edd3387228e-Picture15.png),![Picture16.png](https://pic.leetcode-cn.com/a61fcdeb1dacd14b2849898f8c6506394586debf3e67550aa5ad8e2f9e8dcac4-Picture16.png),![Picture17.png](https://pic.leetcode-cn.com/6897ae8b2dcc14f6cf012df34bfed98a2ea4d831b6515de9bd2db363968e217a-Picture17.png),![Picture18.png](https://pic.leetcode-cn.com/0fe9e90477e1a3762ad0c3f7877d6acfdc5b7090466a26dca2ef03242192209f-Picture18.png),![Picture19.png](https://pic.leetcode-cn.com/f24f424fe5d1799694db1128d7d8ed1b91a7d2c4920f1a2704a03aad14afec38-Picture19.png),![Picture20.png](https://pic.leetcode-cn.com/b31f1ce86db66b141430c693085273e241676a3071ee6fa2b374509361b14012-Picture20.png),![Picture21.png](https://pic.leetcode-cn.com/422986f0e798f155b2cf94e95d3febf5739d6a22e5ddfb1fc10dec0289f7b543-Picture21.png),![Picture22.png](https://pic.leetcode-cn.com/0301e32e08f8b2d25a9806bc986b7d5507ec681df3bf386d5c12c37c9dcf6036-Picture22.png)>

### 代码：

```Python []
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
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
            res.append(tmp[::-1] if len(res) % 2 else tmp)
        return res
```

```Java []
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if (res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }
}
```

```C++ []
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        queue<TreeNode*> que;
        vector<vector<int>> res;
        if (root != NULL) que.push(root);
        while (!que.empty()) {
            vector<int> tmp;
            for(int i = que.size(); i > 0; i--) {
                TreeNode* node = que.front();
                que.pop();
                tmp.push_back(node->val);
                if (node->left != NULL) que.push(node->left);
                if (node->right != NULL) que.push(node->right);
            }
            if (res.size() % 2 == 1) reverse(tmp.begin(),tmp.end());
            res.push_back(tmp);
        }
        return res;
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** $N$ 为二叉树的节点数量，即 BFS 需循环 $N$ 次，占用 $O(N)$ 。**共完成** 少于 $N$ 个节点的倒序操作，占用 $O(N)$ 。
- **空间复杂度 $O(N)$ ：** 最差情况下，即当树为满二叉树时，最多有 $N/2$ 个树节点**同时**在 `queue` 中，使用 $O(N)$ 大小的额外空间。
