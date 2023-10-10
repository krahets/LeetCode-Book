#### 解题思路：

如下图所示，考虑数字的二进制形式，对于出现三次的数字，各 **二进制位** 出现的次数都是 $3$ 的倍数。
因此，统计所有数字的各二进制位中 $1$ 的出现次数，并对 $3$ 求余，结果则为只出现一次的数字。

![Picture1.png](https://pic.leetcode-cn.com/28f2379be5beccb877c8f1586d8673a256594e0fc45422b03773b8d4c8418825-Picture1.png){:width=450}

#### 方法一：有限状态自动机

各二进制位的 **位运算规则相同** ，因此只需考虑一位即可。如下图所示，对于所有数字中的某二进制位 $1$ 的个数，存在 3 种状态，即对 3 余数为 $0, 1, 2$ 。

- 若输入二进制位 $1$ ，则状态按照以下顺序转换；
- 若输入二进制位 $0$ ，则状态不变。

$$
0 \rightarrow 1 \rightarrow 2 \rightarrow 0 \rightarrow \cdots
$$

![Picture2.png](https://pic.leetcode-cn.com/ab00d4d1ad961a3cd4fc1840e34866992571162096000325e7ce10ff75fda770-Picture2.png){:width=400}

如下图所示，由于二进制只能表示 $0, 1$ ，因此需要使用两个二进制位来表示 $3$ 个状态。设此两位分别为 $two$ , $one$ ，则状态转换变为：

$$
00 \rightarrow 01 \rightarrow 10 \rightarrow 00 \rightarrow \cdots
$$

![Picture3.png](https://pic.leetcode-cn.com/0a7ea5bca055b095673620d8bb4c98ef6c610a22f999294ed11ae35d43621e93-Picture3.png){:width=400}

接下来，需要通过 **状态转换表** 导出 **状态转换的计算公式** 。首先回忆一下位运算特点，对于任意二进制位 $x$ ，有：

- 异或运算：`x ^ 0 = x`​ ， `x ^ 1 = ~x`
- 与运算：`x & 0 = 0` ， `x & 1 = x`

**计算 $one$ 方法：**

设当前状态为 $two$ $one$ ，此时输入二进制位 $n$ 。如下图所示，通过对状态表的情况拆分，可推出 $one$ 的计算方法为：

```python
if two == 0:
  if n == 0:
    one = one
  if n == 1:
    one = ~one
if two == 1:
    one = 0
```

引入 **异或运算** ，可将以上拆分简化为：

```python
if two == 0:
    one = one ^ n
if two == 1:
    one = 0
```

引入 **与运算** ，可继续简化为：

```python
one = one ^ n & ~two
```

![Picture4.png](https://pic.leetcode-cn.com/f75d89219ad93c69757b187c64784b4c7a57dce7911884fe82f14073d654d32f-Picture4.png){:width=550}

**计算 $two$ 方法：**

由于是先计算 $one$ ，因此应在新 $one$ 的基础上计算 $two$ 。
如下图所示，修改为新 $one$ 后，得到了新的状态图。观察发现，可以使用同样的方法计算 $two$ ，即：

```python
two = two ^ n & ~one
```

![Picture5.png](https://pic.leetcode-cn.com/6ba76dba1ac98ee2bb982e011fdffd1df9a6963f157b2780461dbce453f0ded3-Picture5.png){:width=450}

**返回值：**

以上是对数字的二进制中 “一位” 的分析，而 `int` 类型的其他 31 位具有相同的运算规则，因此可将以上公式直接套用在 32 位数上。

遍历完所有数字后，各二进制位都处于状态 $00$ 和状态 $01$ （取决于 “只出现一次的数字” 的各二进制位是 $1$ 还是 $0$ ），而此两状态是由 $one$ 来记录的（此两状态下 $twos$ 恒为 $0$ ），因此返回 $ones$ 即可。

##### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 其中 $N$ 位数组 $nums$ 的长度；遍历数组占用 $O(N)$ ，每轮中的常数个位运算操作占用 $O(32 \times3 \times 2) = O(1)$ 。
- **空间复杂度 $O(1)$ ：** 变量 $ones$ , $twos$ 使用常数大小的额外空间。

<![Picture6.png](https://pic.leetcode-cn.com/045023f05080e0844f05b8ee5b68885e1b9e41926d3e4ab054c68e6dceacfc0a-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/fd0ab6b3cd20c18729321957f6b4bedbf6480fd6862c01de1c5d598c82a26d2b-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/46b0974b13206beda512dd037df10772fae1c7375a97a7a05abb4a736dc0ebb3-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/4cfe4cf13367851efdb9dee5fceed969326cc3478be0769c8f60294ef5d2866d-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/fa2e7ecb991d5183e2f53ca7741150ae18badb087b01bff4a32caaec245fec79-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/6a6b8561c913c45d7be3428ff8553a2188890fee0687a1a113a7c2bea12b95a9-Picture11.png)>

##### 代码：

```Python []
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        ones, twos = 0, 0
        for num in nums:
            ones = ones ^ num & ~twos
            twos = twos ^ num & ~ones
        return ones
```

```Java []
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
```

#### 方法二：遍历统计

> 此方法相对容易理解，但效率较低，总体推荐方法一。

使用 **与运算** ，可获取二进制数字 $num$ 的最右一位 $n_1$ ：

$$
n_1 = num \& i
$$

配合 **无符号右移操作** ，可获取 $num$ 所有位的值（即 $n_1$ ~ $n_{32}$ ）：

$$
num = num >>> 1
$$

建立一个长度为 32 的数组 $counts$ ，通过以上方法可记录所有数字的各二进制位的 $1$ 的出现次数。

```java
int[] counts = new int[32];
for(int i = 0; i < nums.length; i++) {
    for(int j = 0; j < 32; j++) {
        counts[j] += nums[i] & 1; // 更新第 j 位
        nums[i] >>>= 1; // 第 j 位 --> 第 j + 1 位
    }
}
```

将 $counts$ 各元素对 $3$ 求余，则结果为 “只出现一次的数字” 的各二进制位。

```java
for(int i = 0; i < 32; i++) {
    counts[i] %= 3; // 得到 只出现一次的数字 的第 (31 - i) 位 
}
```

利用 **左移操作** 和 **或运算** ，可将 $counts$ 数组中各二进位的值恢复到数字 $res$ 上（循环区间是 $i \in [0, 31]$ ）。

```java
for(int i = 0; i < counts.length; i++) {
    res <<= 1; // 左移 1 位
    res |= counts[31 - i]; // 恢复第 i 位的值到 res
}
```

最终返回 $res$ 即可。

> 由于 Python 的存储负数的特殊性，需要先将 $0$ - $32$ 位取反（即 `res ^ 0xffffffff` ），再将所有位取反（即 `~` ）。
> 两个组合操作实质上是将数字 $32$ 以上位取反， $0$ - $32$ 位不变。

##### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 其中 $N$ 位数组 $nums$ 的长度；遍历数组占用 $O(N)$ ，每轮中的常数个位运算操作占用 $O(1)$ 。
- **空间复杂度 $O(1)$ ：** 数组 $counts$ 长度恒为 $32$ ，占用常数大小的额外空间。

##### 代码：

实际上，只需要修改求余数值 $m$ ，即可实现解决 **除了一个数字以外，其余数字都出现 $m$ 次** 的通用问题。

```Python []
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        counts = [0] * 32
        for num in nums:
            for j in range(32):
                counts[j] += num & 1
                num >>= 1
        res, m = 0, 3
        for i in range(32):
            res <<= 1
            res |= counts[31 - i] % m
        return res if counts[31] % m == 0 else ~(res ^ 0xffffffff)
```

```Java []
class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
```
