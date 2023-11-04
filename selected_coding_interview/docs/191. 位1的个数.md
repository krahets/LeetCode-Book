## 方法一：逐位判断

根据 **与运算** 定义，设二进制数字 $n$ ，则有：

- 若 $n \& 1 = 0$ ，则 $n$ 二进制 **最右一位** 为 $0$ 。
- 若 $n \& 1 = 1$ ，则 $n$ 二进制 **最右一位** 为 $1$ 。

根据以上特点，考虑以下 **循环判断** ：

1. 判断 $n$ 最右一位是否为 $1$ ，根据结果计数。
2. 将 $n$ 右移一位（本题要求把数字 $n$ 看作无符号数，因此使用 **无符号右移** 操作）。

### 算法流程：

1. 初始化数量统计变量 $res = 0$ 。
2. 循环逐位判断： 当 $n = 0$ 时跳出。
   1. **`res += n & 1` ：** 若 $n \& 1 = 1$ ，则统计数 $res$ 加一。
   2. **`n >>= 1` ：** 将二进制数字 $n$ 无符号右移一位（ Java 中无符号右移为 "$>>>$" ） 。
3. 返回统计数量 $res$ 。

<![Picture2.png](https://pic.leetcode-cn.com/196a1e24f89c3291d8462f1a2bdab87dde8590d4c04d964d503db8dcaf5fda72-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/4f4d43ed85b87c9dba12e0b3f3f3a8760f90e8e23d33d19ebabb3ad3c8149897-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/8f054e5ba19053365563577f339343bb635591381b1d8c950624bd9390309c71-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/20f8471b079eaa94d0f09b7627c94e64f541b85f660d3f20b14fd2fa1e3b1f92-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/6312b1569a40d74174f0c31fcfb8cc9836e0c2ab6c0ade144ab74f009ae0560d-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/eee12d1995aa0aa24757dcb10e1c8829ef72f685aa3baad74bf001d9f8cd7e54-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/9f734c501f50afaaee0d9ea0fe3c42f3af68eaaff1c9c5563295bbe1ac2a3110-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/ad1934398b309e369cbaa83f21a88a672ae9025460a3c93ec94439574620e1de-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/aae3da9131792c0103f9b24b35abebadb30b47d92441c5927546036066e5614b-Picture10.png)>

### 代码：

```Python []
class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0
        while n:
            res += n & 1
            n >>= 1
        return res
```

```Java []
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
```

```C++ []
class Solution {
public:
    int hammingWeight(uint32_t n) {
        unsigned int res = 0; // c++ 使用无符号数
        while (n != 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(\log n)$ ：** 此算法循环内部仅有 **移位、与、加** 等基本运算，占用 $O(1)$ ；逐位判断需循环 $log_2 n$ 次，其中 $\log_2 n$ 代表数字 $n$ 最高位 $1$ 的所在位数（例如 $\log_2 4 = 2$, $\log_2 16 = 4$）。
- **空间复杂度 $O(1)$ ：** 变量 $res$ 使用常数大小额外空间。

## 方法二：巧用 $n \& (n - 1)$

**$(n - 1)$ 作用：** 二进制数字 $n$ 最右边的 $1$ 变成 $0$ ，此 $1$ 右边的 $0$ 都变成 $1$ 。

**$n \& (n - 1)$ 作用：** 二进制数字 $n$ 最右边的 $1$ 变成 $0$ ，其余不变。

![Picture1.png](https://pic.leetcode-cn.com/f23d9ef4fcfd65d7fbe29e477cbf36110b2f34558020e8cff09a1e13c0275c43-Picture1.png){:width=400}

### 算法流程：

1. 初始化数量统计变量 $res$ 。
2. 循环消去最右边的 $1$ ：当 $n = 0$ 时跳出。
   1. **`res += 1` ：** 统计变量加 $1$ 。
   2. **`n &= n - 1` ：** 消去数字 $n$ 最右边的 $1$ 。
3. 返回统计数量 $res$ 。

<![Picture11.png](https://pic.leetcode-cn.com/d16a9a6cfdba918c655679373632afc8ddeaf9b64912aa1fbf7b57371736ccaa-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/a6c05d83742bdf0cc50f9e4f1cc05833b3fca1b33abad88cf82c30459964bfa1-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/19f7add30dac42e0785de28909579b0f961122cbfd673a44230b3a1c4fe89f80-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/016ca059d0eb893b9a5f1c0b3ff013ffbd42424f8cd0cc1f9a76624dcbd87c41-Picture14.png)>

### 代码：

```Python []
class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0
        while n:
            res += 1
            n &= n - 1
        return res
```

```Java []
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}
```

```C++ []
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(M)$ ：** $n \& (n - 1)$ 操作仅有减法和与运算，占用 $O(1)$ ；设 $M$ 为二进制数字 $n$ 中 $1$ 的个数，则需循环 $M$ 次（每轮消去一个 $1$ ），占用 $O(M)$ 。
- **空间复杂度 $O(1)$ ：** 变量 $res$ 使用常数大小额外空间。
