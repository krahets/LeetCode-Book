## 解题思路:

输入一个字符串 $s$ ，做如下操作：

1. 选择任意位置，将字符串切分为两个子字符串 $s = L \ R$ ；
2. 将 $R$ 移动至 $L$ 前面得到 $goal = R \ L$ ；

此时，称 $goal$ 为 $s$ 的一个「旋转字符串」。 

![ccw-01-09.001-004.gif](https://pic.leetcode-cn.com/1638612131-zkecdf-ccw-01-09.001-004.gif)

如下图所示，根据旋转字符串特点，若构造一个拼接字符串 $goal \ goal$ ，则有 $goal \ goal = R \ L \ R \ L = R \ s \ L$ ，即拼接字符串 $goal \ goal$ 中**包含**原字符串 $s$ 。因此，$goal$ 为 $s$ 的旋转字符串的「充要条件」为：

- 字符串 $s$ , $goal$ 的长度相等；
- 拼接字符串 $goal \ goal$ 中**包含**原字符串 $s$ ；

![ccw-01-09.005.png](https://pic.leetcode-cn.com/1638612131-tGESRo-ccw-01-09.005.png)

## 代码:

```Python []
class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        return len(s) == len(goal) and s in (goal + goal)
```

```Java []
class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (goal + goal).contains(s);
    }
}
```

```C++ []
class Solution {
public:
    bool rotateString(string s, string goal) {
        return s.length() == goal.length() && (goal + goal).find(s) != -1;
    }
};
```

### 复杂度分析:

**时间复杂度：** 设字符串 $s$ , $goal$ 的长度都为 $N$ 。

- 「暴力匹配」需要分别以 $goal$ 前 $N$ 个字符为起始点，遍历匹配 $s$ ，总体时间复杂度为 $O(N^2)$ 。
- 「子串匹配 KMP 算法」的时间复杂度为 $O(N)$ 。
- 「Boyer–Moore string-search algorithm」时间复杂度为 $O(N)$ 。

> 本文直接调用编程语言的库函数，时间复杂度由库函数的具体实现方法确定。

**空间复杂度 $O(N)$ ：** 构造拼接字符串 $goal \ goal$ 使用 $O(N)$ 大小的额外空间。
