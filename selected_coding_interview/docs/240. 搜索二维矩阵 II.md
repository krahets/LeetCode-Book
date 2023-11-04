## 解题思路：

> 若使用暴力法遍历矩阵 `matrix` ，则时间复杂度为 $O(NM)$ 。暴力法未利用矩阵 **“从上到下递增、从左到右递增”** 的特点，显然不是最优解法。

如下图所示，我们将矩阵逆时针旋转 45° ，并将其转化为图形式，发现其类似于 **二叉搜索树** ，即对于每个元素，其左分支元素更小、右分支元素更大。因此，通过从 “根节点” 开始搜索，遇到比 `target` 大的元素就向左，反之向右，即可找到目标值 `target` 。

![Picture1.png](https://pic.leetcode-cn.com/6584ea93812d27112043d203ea90e4b0950117d45e0452d0c630fcb247fbc4af-Picture1.png){:width=450}

“根节点” 对应的是矩阵的 “左下角” 和 “右上角” 元素，本文称之为 **标志数** ，以 `matrix` 中的 **左下角元素** 为标志数 `flag` ，则有:

1. 若 `flag > target` ，则 `target` 一定在 `flag` 所在 **行的上方** ，即 `flag` 所在行可被消去。
2. 若 `flag < target` ，则 `target` 一定在 `flag` 所在 **列的右方** ，即 `flag` 所在列可被消去。

### **算法流程：**

1. 从矩阵 `matrix` 左下角元素（索引设为 `(i, j)` ）开始遍历，并与目标值对比：
   - 当 `matrix[i][j] > target` 时，执行 `i--` ，即消去第 `i` 行元素。
   - 当 `matrix[i][j] < target` 时，执行 `j++` ，即消去第 `j` 列元素。
   - 当 `matrix[i][j] = target` 时，返回 $true$ ，代表找到目标值。
2. 若行索引或列索引越界，则代表矩阵中无目标值，返回 $false$ 。

> 每轮 `i` 或 `j` 移动后，相当于生成了“消去一行（列）的新矩阵”， 索引`(i,j)` 指向新矩阵的左下角元素（标志数），因此可重复使用以上性质消去行（列）。

<![Picture2.png](https://pic.leetcode-cn.com/6a083897417b51e94ed84e3483d334078d851e691eb8655b45432372ecdea9d6-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/c301ea07f6081e95d06c07cc23fb0419e67ffdd92c2511201f72c3f86f18c928-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/3f1f6c8af23c89cd3179f486cfb932322ea4fa08ab707dc5e20b9adb243278e9-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/533c0eba70d25e5f7a1930186389a38feae15a91eea771fd388edd1eecc0b129-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/116704601a28972d17b32cc641485a1ab707930504a720160e121b092e9f7084-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/7db0cca850374644eff397880d5cdb3be17a3558a306162955a7ffb31bbf4e5c-Picture7.png)>

## 代码：

```Python []
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        i, j = len(matrix) - 1, 0
        while i >= 0 and j < len(matrix[0]):
            if matrix[i][j] > target: i -= 1
            elif matrix[i][j] < target: j += 1
            else: return True
        return False
```

```Java []
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
```

```C++ []
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int i = matrix.size() - 1, j = 0;
        while(i >= 0 && j < matrix[0].size())
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
};
```

### 复杂度分析：

- 时间复杂度 $O(M+N)$ ：其中，$N$ 和 $M$ 分别为矩阵行数和列数，此算法最多循环 $M+N$ 次。
- 空间复杂度 $O(1)$ : `i`, `j` 指针使用常数大小额外空间。
