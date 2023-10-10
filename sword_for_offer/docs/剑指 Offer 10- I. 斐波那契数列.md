## 解题思路：

斐波那契数列的定义是 $f(n + 1) = f(n) + f(n - 1)$ ，生成第 $n$ 项的做法有以下几种：

1. **递归法：**
    - **原理：** 把 $f(n)$ 问题的计算拆分成 $f(n-1)$ 和 $f(n-2)$ 两个子问题的计算，并递归，以 $f(0)$ 和 $f(1)$ 为终止条件。
    - **缺点：** 大量重复的递归计算，例如 $f(n)$ 和 $f(n - 1)$ 两者向下递归需要 **各自计算** $f(n - 2)$ 的值。
2. **记忆化递归法：**
    - **原理：** 在递归法的基础上，新建一个长度为 $n$ 的数组，用于在递归时存储 $f(0)$ 至 $f(n)$ 的数字值，重复遇到某数字则直接从数组取用，避免了重复的递归计算。
    - **缺点：** 记忆化存储需要使用 $O(N)$ 的额外空间。
3. **动态规划：**
    - **原理：** 以斐波那契数列性质 $f(n + 1) = f(n) + f(n - 1)$ 为转移方程。
    - 从计算效率、空间复杂度上看，动态规划是本题的最佳解法。

> 下图帮助理解递归法的 “重复计算” 概念。

![Picture1.png](https://pic.leetcode-cn.com/1599882883-mtYecf-Picture1.png){:width=500}

## 动态规划解析：

- **状态定义：** 设 $dp$ 为一维数组，其中 $dp[i]$ 的值代表 斐波那契数列第 $i$ 个数字 。
- **转移方程：** $dp[i + 1] = dp[i] + dp[i - 1]$ ，即对应数列定义 $f(n + 1) = f(n) + f(n - 1)$ ；
- **初始状态：** $dp[0] = 0$, $dp[1] = 1$ ，即初始化前两个数字；
- **返回值：** $dp[n]$ ，即斐波那契数列的第 $n$ 个数字。

## 空间复杂度降低：

> 若新建长度为 $n$ 的 $dp$ 列表，则空间复杂度为 $O(N)$ 。

- 由于 $dp$ 列表第 $i$ 项只与第 $i-1$ 和第 $i-2$ 项有关，因此只需要初始化三个整形变量 `sum`, `a`, `b` ，利用辅助变量 $sum$ 使 $a, b$ 两数字交替前进即可 *（具体实现见代码）* 。
- 节省了 $dp$ 列表空间，因此空间复杂度降至 $O(1)$ 。

## 循环求余法：

> **大数越界：** 随着 $n$ 增大, $f(n)$ 会超过 `Int32` 甚至 `Int64` 的取值范围，导致最终的返回值错误。 

- **求余运算规则：** 设正整数 $x, y, p$ ，求余符号为 $\odot$ ，则有 $(x + y) \odot p = (x \odot p + y \odot p) \odot p$ 。

- **解析：** 根据以上规则，可推出 $f(n) \odot p = [f(n-1) \odot p + f(n-2) \odot p] \odot p$ ，从而可以在循环过程中每次计算 $sum = (a + b) \odot 1000000007$ ，此操作与最终返回前取余等价。

<![Picture2.png](https://pic.leetcode-cn.com/1599882883-jbnPaZ-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/1599882883-ZIXjom-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1599882883-UHnEEL-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1599882883-UHtjpA-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1599882883-jXtHXx-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1599882883-ppWbXc-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1599882883-lyXbyd-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1599882883-vhrJxv-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1599882883-cIpqVP-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/1599882883-NmQlPg-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/1599882883-coycTs-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/1599882883-FZVjJi-Picture13.png)>

## 复杂度分析：

- **时间复杂度 $O(n)$ ：** 计算 $f(n)$ 需循环 $n$ 次，每轮循环内计算操作使用 $O(1)$ 。
- **空间复杂度 $O(1)$ ：** 几个标志变量使用常数大小的额外空间。

## 代码：

```Python []
class Solution:
    def fib(self, n: int) -> int:
        a, b = 0, 1
        for _ in range(n):
            a, b = b, (a + b) % 1000000007
        return a
```

```Java []
class Solution {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
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
    int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
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
    def fib(self, n: int) -> int:
        a, b = 0, 1
        for _ in range(n):
            a, b = b, a + b
        return a % 1000000007
```
