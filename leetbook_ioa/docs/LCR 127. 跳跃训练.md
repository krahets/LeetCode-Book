## 解题思路：

设跳上 $n$ 级平台有 $f(n)$ 种跳法。在所有跳法中，青蛙的最后一步只有两种情况： **跳上 $1$ 级或 $2$ 级平台**。

1. **当为 $1$ 级平台：** 剩 $n-1$ 个平台，此情况共有 $f(n-1)$ 种跳法；
2. **当为 $2$ 级平台：** 剩 $n-2$ 个平台，此情况共有 $f(n-2)$ 种跳法。

即 $f(n)$ 为以上两种情况之和，即 $f(n)=f(n-1)+f(n-2)$ ，以上递推性质为斐波那契数列。因此，本题可转化为 **求斐波那契数列第 $n$ 项的值** ，唯一的不同在于起始数字不同。

- 跳跃训练问题： $f(0)=1$ ,  $f(1)=1$ , $f(2)=2$ ；
- 斐波那契数列问题： $f(0)=0$ , $f(1)=1$ , $f(2)=1$ 。

![Picture1.png](https://pic.leetcode-cn.com/1599883153-UckfTw-Picture1.png){:align=center width=500}

### 动态规划解析：

- **状态定义：** 设 $dp$ 为一维数组，其中 $dp[i]$ 的值代表斐波那契数列的第 $i$ 个数字。
- **转移方程：** $dp[i + 1] = dp[i] + dp[i - 1]$ ，即对应数列定义 $f(n + 1) = f(n) + f(n - 1)$ ；
- **初始状态：** $dp[0] = 1$, $dp[1] = 1$ ，即初始化前两个数字；
- **返回值：** $dp[n]$ ，即斐波那契数列的第 $n$ 个数字。

### 空间优化：

> 若新建长度为 $n$ 的 $dp$ 列表，则空间复杂度为 $O(N)$ 。

- 由于 $dp$ 列表第 $i$ 项只与第 $i-1$ 和第 $i-2$ 项有关，因此只需要初始化三个整形变量 `sum`, `a`, `b` ，利用辅助变量 $sum$ 使 $a, b$ 两数字交替前进即可 *（具体实现见代码）* 。
- 因为节省了 $dp$ 列表空间，因此空间复杂度降至 $O(1)$ 。

### 循环求余法：

> **大数越界：** 随着 $n$ 增大, $f(n)$ 会超过 `Int32` 甚至 `Int64` 的取值范围，导致最终的返回值错误。

- **求余运算规则：** 设正整数 $x, y, p$ ，求余符号为 $\odot$ ，则有 $(x + y) \odot p = (x \odot p + y \odot p) \odot p$ 。
- **解析：** 根据以上规则，可推出 $f(n) \odot p = [f(n-1) \odot p + f(n-2) \odot p] \odot p$ ，从而可以在循环过程中每次计算 $sum = a + b \odot 1000000007$ ，此操作与最终返回前取余等价。

<![Picture2.png](https://pic.leetcode-cn.com/1599883153-iXEZvr-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/1599883153-MjJsdM-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1599883153-kMaCBQ-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1599883153-jVtBVj-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1599883153-EsemaN-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1599883153-wznsCe-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1599883153-mVlvjo-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1599883153-zzFSWJ-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1599883153-LmZgWM-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/1599883153-jSUeMz-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/1599883153-kRKefY-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/1599883153-vEYzWk-Picture13.png)>

## 代码：

```Python []
class Solution:
    def trainWays(self, num: int) -> int:
        a, b = 1, 1
        for _ in range(num):
            a, b = b, (a + b) % 1000000007
        return a
```

```Java []
class Solution {
    public int trainWays(int num) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < num; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
```

```C++ []
class Solution {
public:
    int trainWays(int num) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < num; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
};
```

由于 Python 中整形数字的大小限制取决计算机的内存（可理解为无限大），因此也可不考虑大数越界问题；但当数字很大时，加法运算的效率也会降低，因此不推荐此方法。

```Python []
# 不考虑大数越界问题
class Solution:
    def trainWays(self, num: int) -> int:
        a, b = 1, 1
        for _ in range(num):
            a, b = b, a + b
        return a % 1000000007
```

### 复杂度分析：

- **时间复杂度 $O(n)$ ：** 计算 $f(n)$ 需循环 $n$ 次，每轮循环内计算操作使用 $O(1)$ 。
- **空间复杂度 $O(1)$ ：** 几个标志变量使用常数大小的额外空间。
