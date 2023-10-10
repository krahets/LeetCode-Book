此题与 [剑指 Offer 14- I. 剪绳子](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/) 主体等价，唯一不同在于本题目涉及 **大数越界情况下的求余问题** 。建议先做上一道题，在此基础上再研究此题目的大数求余方法。

## 解题思路：

- 设将长度为 $n$ 的绳子切为 $a$ 段：

$$
n = n_1 + n_2 + ... + n_a
$$

- 本题等价于求解：

$$
\max(n_1 \times n_2 \times ... \times n_a)
$$

> 以下数学推导总体分为两步：① 当所有绳段长度相等时，乘积最大。② 最优的绳段长度为 $3$ 。

### 数学推导：

- 以下公式为“算术几何均值不等式” ，等号当且仅当 $n_1 = n_2 = ... = n_a$ 时成立。

$$
\frac{n_1 + n_2 + ... + n_a}{a} \geq \sqrt[a]{n_1 n_2 ... n_a}
$$

> **推论一：** 将绳子 **以相等的长度等分为多段** ，得到的乘积最大。

- 设将绳子按照 $x$ 长度等分为 $a$ 段，即 $n = ax$ ，则乘积为 $x^a$ 。观察以下公式，由于 $n$ 为常数，因此当 $x^{\frac{1}{x}}$ 取最大值时， 乘积达到最大值。

$$
x^a = x^{\frac{n}{x}} = (x^{\frac{1}{x}})^n
$$

- 根据分析，可将问题转化为求 $y = x^{\frac{1}{x}}$ 的极大值，因此对 $x$ 求导数。

$$
\begin{aligned}
 \ln y & = \frac{1}{x} \ln x & \text{取对数} \\
 \frac{1}{y} \dot {y} & = \frac{1}{x^2} - \frac{1}{x^2} \ln x & \text{对 $x$ 求导} \\
 & = \frac{1 - \ln x}{x^2} \\
 \dot {y} & = \frac{1 - \ln x}{x^2} x^{\frac{1}{x}} & \text{整理得}
\end{aligned}
$$

- 令 $\dot {y} = 0$ ，则 $1 - \ln x = 0$ ，易得驻点为 $x_0 = e \approx 2.7$ ；根据以下公式，可知 $x_0$ 为极大值点。

$$
\dot {y}
\begin{cases}
 > 0 & , x \in [- \infty, e) \\
 < 0 & , x \in (e, \infty] \\
\end{cases}
$$

- 由于切分长度 $x$ 必须为整数，最接近 $e$ 的整数为 $2$ 或 $3$ 。如下式所示，代入 $x = 2$ 和 $x = 3$ ，得出 $x = 3$ 时，乘积达到最大。

$$
y(3) = 3^{1/3} \approx 1.44 \\
y(2) = 2^{1/2} \approx 1.41
$$

- 口算对比方法：给两数字同时取 $6$ 次方，再对比。

$$
[y(3)]^6 = (3^{1/3})^6 = 9 \\
[y(2)]^6 = (2^{1/2})^6 = 8
$$

> **推论二：** 尽可能将绳子以长度 $3$ 等分为多段时，乘积最大。

### 切分规则：

1. **最优：** $3$ 。把绳子尽可能切为多个长度为 $3$ 的片段，留下的最后一段绳子的长度可能为 $0,1,2$ 三种情况。
2. **次优：** $2$ 。若最后一段绳子长度为 $2$ ；则保留，不再拆为 $1+1$ 。
3. **最差：** $1$ 。若最后一段绳子长度为 $1$ ；则应把一份 $3 + 1$ 替换为 $2 + 2$，因为 $2 \times 2 > 3 \times 1$。

### 算法流程：

1. 当 $n \leq 3$ 时，按照规则应不切分，但由于题目要求必须剪成 $m>1$ 段，因此必须剪出一段长度为 $1$ 的绳子，即返回 $n - 1$ 。
2. 当 $n>3$ 时，求 $n$ 除以 $3$ 的 整数部分 $a$ 和 余数部分 $b$ （即 $n = 3a + b$ ），并分为以下三种情况（设求余操作符号为 "$\odot$" ）：
    - 当 $b = 0$ 时，直接返回 $3^a \odot 1000000007$；
    - 当 $b = 1$ 时，要将一个 $1 + 3$ 转换为 $2+2$，因此返回 $(3^{a-1} \times 4)\odot 1000000007$；
    - 当 $b = 2$ 时，返回 $(3^a \times 2) \odot 1000000007$。

![Picture1.png](https://pic.leetcode-cn.com/1f9adeaa7b9fff0ab19c9d29e3a8f98749011d22dc162d67bdbe223f1a38119f-Picture1.png){:width=600}

### 大数求余解法：

**大数越界：** 当 $a$ 增大时，最后返回的 $3^a$ 大小以指数级别增长，可能超出 `int32` 甚至 `int64` 的取值范围，导致返回值错误。
**大数求余问题：** 在仅使用 `int32` 类型存储的前提下，正确计算 $x^a$ 对 $p$ 求余（即 $x^a \odot p$ ）的值。
**解决方案：** *循环求余* 、 *快速幂求余* ，其中后者的时间复杂度更低，两种方法均基于以下求余运算规则推出：

$$
(xy) \odot p = [(x \odot p)(y \odot p)] \odot p
$$

### 1. 循环求余：

- 根据求余运算性质推出（∵ 本题中 $x<p$，∴ $x \odot p = x$ ）：

$$
x^a \odot p = [(x ^{a-1} \odot p)(x \odot p)] \odot p=[(x ^{a-1} \odot p)x] \odot p
$$

- **解析：** 利用此公式，可通过循环操作依次求 $x^1, x^2, ..., x^{a-1}, x^a$ 对 $p$ 的余数，保证每轮中间值 `rem` 都在 `int32` 取值范围中。封装方法代码如下所示。
- **时间复杂度 $O(N)$ ：** 其中 $N=a$ ，即循环的线性复杂度。

```Python []
# 求 (x^a) % p —— 循环求余法
def remainder(x, a, p):
    rem = 1
    for _ in range(a):
        rem = (rem * x) % p
    return rem
```

### 2. 快速幂求余：

- 根据求余运算性质可推出：

$$
x^a \odot p = (x^2)^{a/2} \odot p = (x^2 \odot p)^{a / 2} \odot p
$$

- 当 $a$ 为奇数时 $a/2$ 不是整数，因此分为以下两种情况（ ''$//$'' 代表向下取整的除法）：

$$
{x^a \odot p = }
\begin{cases}
(x^2 \odot p)^{a // 2} \odot p &  \text{, $a$ 为偶数} \\
{[(x \odot p)(x ^{a-1} \odot p)] \odot p = [x(x^2 \odot p)^{a//2}] \odot p} & \text{, $a$ 为奇数} \\
\end{cases}
$$

- **解析：** 利用以上公式，可通过循环操作每次把指数 $a$ 问题降低至指数 $a//2$ 问题，只需循环 $\log_2(N)$ 次，因此可将复杂度降低至对数级别。封装方法代码如下所示。

```Python []
# 求 (x^a) % p —— 快速幂求余
def remainder(x, a, p):
    rem = 1
    while a > 0:
        if a % 2: rem = (rem * x) % p
        x = x ** 2 % p
        a //= 2
    return rem
```

- **帮助理解：** 根据下表， 初始状态 $rem=1$, $x=3$, $a=19$, $p=1000000007$ ，最后会将 $rem \times (x^a \odot p)$ 化为 $rem \times (x^0 \odot p) = rem \times 1$ 的形式，即 $rem$ 为余数答案。

| $n$ |                 $rem \times (x^a \odot p)$ | $rem_n=rem_{n-1} \times x_{n-1} \odot p$ |        $x_n=x_{n-1}^2 \odot p$ | $a_n=a_{n-1}//2$ |
| --- | -----------------------------------------: | ---------------------------------------: | -----------------------------: | :--------------: |
| $1$ |                $1 \times (3^{19} \odot p)$ |                                      $1$ |                            $3$ |       $19$       |
| $2$ |                 $3 \times (9^{9} \odot p)$ |                      $3=1\times3\odot p$ |                $9=3^2 \odot p$ |    $9=19//2$     |
| $3$ |               $27 \times (81^{4} \odot p)$ |                $27 = 3 \times 9 \odot p$ |                $81=9^2\odot p$ |     $4=9//2$     |
| $4$ |             $27 \times (6561^{2} \odot p)$ |                                     $27$ |            $6561=81^2 \odot p$ |     $2=4//2$     |
| $5$ |         $27 \times (43046721^{1} \odot p)$ |                                     $27$ |      $43046721=6561^2 \odot p$ |     $1=2//2$     |
| $6$ | $162261460 \times (175880701^{0} \odot p)$ |   $162261460=27 \times 43046721 \odot p$ | $175880701=43046721^2 \odot p$ |     $0=1//2$     |

### 复杂度分析：

> 以下为 **二分求余法** 的复杂度。

- **时间复杂度 $O(\log_2 N)$ ：** 其中 $N=a$ ，二分法为对数级别复杂度，每轮仅有求整、求余、次方运算。
  - [求整和求余运算](https://stackoverflow.com/questions/35189851/time-complexity-of-modulo-operator-in-python)：资料提到不超过机器数的整数可以看作是 $O(1)$ ；
  - [幂运算](https://stackoverflow.com/questions/32418731/java-math-powa-b-time-complexity)：查阅资料，提到浮点取幂为 $O(1)$ 。
- **空间复杂度 $O(1)$ ：** 变量 `a, b, p, x, rem` 使用常数大小额外空间。

### 代码：

**Python 代码：** 由于语言特性，理论上 Python 中的变量取值范围由系统内存大小决定（无限大），因此在 Python 中其实不用考虑大数越界问题。
**Java/C++ 代码：** 根据二分法计算原理，至少要保证变量 `x` 和 `rem` 可以正确存储 $1000000007^2$ ，而 $2^{64} > 1000000007^2 > 2^{32}$ ，因此我们选取 `long` 类型。

```Python []
class Solution:
    def cuttingRope(self, n: int) -> int:
        if n <= 3: return n - 1
        a, b, p, x, rem = n // 3 - 1, n % 3, 1000000007, 3 , 1
        while a > 0:
            if a % 2: rem = (rem * x) % p
            x = x ** 2 % p
            a //= 2
        if b == 0: return (rem * 3) % p # = 3^(a+1) % p
        if b == 1: return (rem * 4) % p # = 3^a * 4 % p
        return (rem * 6) % p # = 3^(a+1) * 2  % p
```

```Java []
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }
}
```

```C++ []
class Solution {
public:
    int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }
};
```

```Python []
# 由于语言特性，Python 可以不考虑大数越界问题
class Solution:
    def cuttingRope(self, n: int) -> int:
        if n <= 3: return n - 1
        a, b, p = n // 3, n % 3, 1000000007
        if b == 0: return 3 ** a % p
        if b == 1: return 3 ** (a - 1) * 4 % p
        return 3 ** a * 2 % p
```
