## 解题思路：

根据题意，有以下四种字符需要考虑：

1. **首部空格：** 删除之即可。
2. **符号位：** 三种情况，即 ''$+$'' , ''$-$'' , ''无符号"  ；新建一个变量保存符号位，返回前判断正负即可。
3. **非数字字符：** 遇到首个非数字的字符时，应立即返回。
4. **数字字符：**
   1. **字符转数字：** “此数字的 ASCII 码” 与 “ $0$ 的 ASCII 码” 相减即可。
   2. **数字拼接：** 若从左向右遍历数字，设当前位字符为 $c$ ，当前位数字为 $x$ ，数字结果为 $res$ ，则数字拼接公式为：

$$
res = 10 \times res + x \\
x = ascii(c) - ascii('0')
$$

![Picture1.png](https://pic.leetcode-cn.com/1600793383-jCgsGU-Picture1.png){:width=450}

**数字越界处理：**

> 题目要求返回的数值范围应在 $[-2^{31}, 2^{31} - 1]$ ，因此需要考虑数字越界问题。而由于题目指出 `环境只能存储 32 位大小的有符号整数` ，因此判断数字越界时，要始终保持 $res$ 在 int 类型的取值范围内。

在每轮数字拼接前，判断 $res$ **在此轮拼接后是否超过 $2147483647$** ，若超过则加上符号位直接返回。
设数字拼接边界 $bndry = 2147483647 // 10 = 214748364$ ，则以下两种情况越界：

$$
\begin{cases}
 res > bndry & 情况一：执行拼接 10 \times res \geq 2147483650 越界 \\
 res = bndry, x > 7 & 情况二：拼接后是 2147483648 或 2147483649 越界 \\
\end{cases}
$$

![Picture2.png](https://pic.leetcode-cn.com/1600793383-JZRYip-Picture2.png){:width=450}

下图展示了一个转化示例。

<![Picture3.png](https://pic.leetcode-cn.com/1600793383-Lcevlh-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1600793383-tvCmJR-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1600793383-gfdFaU-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1600793383-hBxeGd-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1600793383-EWntxO-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1600793383-jUXVjN-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1600793383-FShoDM-Picture9.png)>

## 代码：

```Python []
class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()                      # 删除首尾空格
        if not s: return 0                   # 字符串为空则直接返回
        res, i, sign = 0, 1, 1
        int_max, int_min, bndry = 2 ** 31 - 1, -2 ** 31, 2 ** 31 // 10
        if s[0] == '-': sign = -1            # 保存负号
        elif s[0] != '+': i = 0              # 若无符号位，则需从 i = 0 开始数字拼接
        for c in s[i:]:
            if not '0' <= c <= '9' : break     # 遇到非数字的字符则跳出
            if res > bndry or res == bndry and c > '7': return int_max if sign == 1 else int_min # 数字越界处理
            res = 10 * res + ord(c) - ord('0') # 数字拼接
        return sign * res
```

```Java []
class Solution {
    public int myAtoi(String s) {
        char[] c = s.trim().toCharArray();
        if (c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') sign = -1;
        else if (c[0] != '+') i = 0;
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;
            if (res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
}
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 其中 $N$ 为字符串长度，线性遍历字符串占用 $O(N)$ 时间。
- **空间复杂度 $O(N)$ ：** 删除首尾空格后需建立新字符串，最差情况下占用 $O(N)$ 额外空间。

若不使用 `trim() / strip()` 删除首部空格，而采取遍历跳过空格的方式，则可以将空间复杂度降低至 $O(1)$ ，代码如下：

```Python []
class Solution:
    def myAtoi(self, s: str) -> int:
        res, i, sign, length = 0, 0, 1, len(s)
        int_max, int_min, bndry = 2 ** 31 - 1, -2 ** 31, 2 ** 31 // 10
        if not s: return 0         # 空字符串，提前返回
        while s[i] == ' ':
            i += 1
            if i == length: return 0 # 字符串全为空格，提前返回
        if s[i] == '-': sign = -1
        if s[i] in '+-': i += 1
        for j in range(i, length):
            if not '0' <= s[j] <= '9' : break
            if res > bndry or res == bndry and s[j] > '7':
                return int_max if sign == 1 else int_min
            res = 10 * res + ord(s[j]) - ord('0')
        return sign * res
```

```Java []
class Solution {
    public int myAtoi(String s) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = s.length();
        if(length == 0) return 0;
        while(s.charAt(i) == ' ')
            if(++i == length) return 0;
        if(s.charAt(i) == '-') sign = -1;
        if(s.charAt(i) == '-' || s.charAt(i) == '+') i++;
        for(int j = i; j < length; j++) {
            if(s.charAt(j) < '0' || s.charAt(j) > '9') break;
            if(res > bndry || res == bndry && s.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s.charAt(j) - '0');
        }
        return sign * res;
    }
}
```

```C++ []
class Solution {
public:
    int myAtoi(string s) {
        int res = 0, bndry = INT_MAX / 10;
        int i = 0, sign = 1, length = s.size();
        if(length == 0) return 0;
        while(s[i] == ' ')
            if(++i == length) return 0;
        if(s[i] == '-') sign = -1;
        if(s[i] == '-' || s[i] == '+') i++;
        for(int j = i; j < length; j++) {
            if(s[j] < '0' || s[j] > '9') break;
            if(res > bndry || res == bndry && s[j] > '7')
                return sign == 1 ? INT_MAX : INT_MIN;
            res = res * 10 + (s[j] - '0');
        }
        return sign * res;
    }
};
```
