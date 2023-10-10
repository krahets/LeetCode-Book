### 思路：

- 生成一个 `n×n` 空矩阵 `mat`，随后模拟整个向内环绕的填入过程：
    - 定义当前左右上下边界 `l,r,t,b`，初始值 `num = 1`，迭代终止值 `tar = n * n`；
    - 当 `num <= tar` 时，始终按照 `从左到右` `从上到下` `从右到左` `从下到上` 填入顺序循环，每次填入后：
        - 执行 `num += 1`：得到下一个需要填入的数字；
        - 更新边界：例如从左到右填完后，上边界` t += 1`，相当于上边界向内缩 1。
    - 使用`num <= tar`而不是`l < r || t < b`作为迭代条件，是为了解决当`n`为奇数时，矩阵中心数字无法在迭代过程中被填充的问题。
- 最终返回 `mat` 即可。  

![Picture1.png](https://pic.leetcode-cn.com/ccff416fa39887c938d36fec8e490e1861813d3bba7836eda941426f13420759-Picture1.png){:width=500}

### 代码：

```Java []
class Solution {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
}
```

```Python []
class Solution:
    def generateMatrix(self, n: int) -> [[int]]:
        l, r, t, b = 0, n - 1, 0, n - 1
        mat = [[0 for _ in range(n)] for _ in range(n)]
        num, tar = 1, n * n
        while num <= tar:
            for i in range(l, r + 1): # left to right
                mat[t][i] = num
                num += 1
            t += 1
            for i in range(t, b + 1): # top to bottom
                mat[i][r] = num
                num += 1
            r -= 1
            for i in range(r, l - 1, -1): # right to left
                mat[b][i] = num
                num += 1
            b -= 1
            for i in range(b, t - 1, -1): # bottom to top
                mat[i][l] = num
                num += 1
            l += 1
        return mat
```
