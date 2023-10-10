## 解题思路：

题目要求的二叉树的 **从上至下** 打印（即按层打印），又称为二叉树的 **广度优先搜索**（BFS）。
BFS 通常借助 **队列** 的先入先出特性来实现。

![Picture1.png](https://pic.leetcode-cn.com/a872b50fa42011748437ec9123d8f77a104b3d528880efca8b212f91d115f835-Picture1.png){:width=400}

### 算法流程：

1. **特例处理：** 当树的根节点为空，则直接返回空列表 `[]` ；
2. **初始化：** 打印结果列表 `res = []` ，包含根节点的队列 `queue = [root]` ；
3. **BFS 循环：** 当队列 `queue` 为空时跳出；
    1. **出队：** 队首元素出队，记为 `node`；
    2. **打印：** 将 `node.val` 添加至列表 `tmp` 尾部；
    3. **添加子节点：** 若 `node` 的左（右）子节点不为空，则将左（右）子节点加入队列 `queue` ；
4. **返回值：** 返回打印结果列表 `res` 即可。

<![Picture2.png](https://pic.leetcode-cn.com/1943050c7d48251cadc2c52545ce067a8fbec1c6b1960ef287c51a18fec55dd7-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/1605540168-GqnDPn-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/ec82e40de2bfb211f8195545ee1b72d5fb4c9c5518c49e61874182ff142c359f-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/3e0bf6c4209905c972ae73a3793323b59352f4cb219d218ce238baeb7a4f815b-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/352c729f306dd3c6d3a8ea04c90eb5fbfb1607ae8b5dcf1e57a4124d77bb4a17-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/bdbad0817bdf85ba5f4d01e8d06f6dc82b295f15f27498ed8e314344707c9cd2-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/5e54460c69fcef7fb86277da6b8d132dbe652bdf540558ae0a5c8b22ae94a49e-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/49c7a62abdd0e1a5af2ada6fd1f0e5f10e7304fe60c321e9e674bf3814db5ad8-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/8eea301df52d3e40e95cd42b871b560859a9fcb867507338dd98ff5d5a5fb5be-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/782e1e35a19754d4ab9d19e1c44504ec364c13007b5d12ecf5598e7af7149758-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/fcfeb4448d3123c19122d18babb93ef110ea693fb809427d8eb63cef59d03888-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/b9a578c85d3bb8c08170809f0f61f18db52e1cb74c7f5439d313f7aaba1eaa6c-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/d6cc7b71c747140178c5096b489ae4dbf246121dac61dfe24c253ba28c0402b1-Picture14.png),![Picture15.png](https://pic.leetcode-cn.com/ee5d52b5bdc79d5ec04d82a6249e7e03aaa4707be4384aa29cc960d48066e290-Picture15.png),![Picture16.png](https://pic.leetcode-cn.com/8ffed118931f0c49efcd1acd637a832e7e885083d6f40fc7f6b0fc6b42099a57-Picture16.png),![Picture17.png](https://pic.leetcode-cn.com/0626f28e8c1aff530808ce78863f6dcca4ffda747acfaeb831572f5fff90f597-Picture17.png),![Picture18.png](https://pic.leetcode-cn.com/d7a1a57e60db621c5213a170ff8bb8ad2545ea4cfd07ca98b12525aea38ad38a-Picture18.png)>

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** $N$ 为二叉树的节点数量，即 BFS 需循环 $N$ 次。
- **空间复杂度 $O(N)$ ：** 最差情况下，即当树为平衡二叉树时，最多有 $N/2$ 个树节点**同时**在 `queue` 中，使用 $O(N)$ 大小的额外空间。

## 代码：

Python 中使用 collections 中的双端队列 `deque()` ，其 `popleft()` 方法可达到 $O(1)$ 时间复杂度；列表 list 的 `pop(0)` 方法时间复杂度为 $O(N)$ 。

```Python []
class Solution:
    def levelOrder(self, root: TreeNode) -> List[int]:
        if not root: return []
        res, queue = [], collections.deque()
        queue.append(root)
        while queue:
            node = queue.popleft()
            res.append(node.val)
            if node.left: queue.append(node.left)
            if node.right: queue.append(node.right)
        return res
```

```Java []
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}
```

```C++ []
class Solution {
public:
    vector<int> levelOrder(TreeNode* root) {
        vector<int> res;
        if(!root) return res;
        TreeNode*> que;
        que.push(root);
        while(!que.empty()){
            TreeNode* node = que.front();
            que.pop();
            res.push_back(node->val);
            if(node->left) que.push(node->left);
            if(node->right) que.push(node->right);
        }
        return res;
    }
};
```
