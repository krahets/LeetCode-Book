## 方法一：遍历添加

在 Python 和 Java 等语言中，字符串都被设计成「不可变」的类型，即无法直接修改字符串的某一位字符，需要新建一个字符串实现。

### 算法流程：

1. 初始化一个 `list` (Python) 或 `StringBuilder` (Java) ，记为 `res` ；
2. 遍历列表 `path` 中的每个字符 `c` ：
    - 当 `c` 为空格时：向 `res` 后添加空格 " " ；
    - 当 `c` 不为空格时：向 `res` 后添加字符 `c` ；
3. 将列表 `res` 转化为字符串并返回。

> 下图中的 `s` 对应本题的 `path` 。

<![Picture1.png](https://pic.leetcode-cn.com/1599931882-pLqBGE-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/1599931882-qBgBNr-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/1599931882-pzDKEt-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1599931882-IEnADl-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1599931882-LvchKo-Picture5.png)>

## 代码：

```Python []
class Solution:
    def pathEncryption(self, path: str) -> str:
        res = []
        for c in path:
            if c == '.': res.append(' ')
            else: res.append(c)
        return "".join(res)
```

```Java []
class Solution {
    public String pathEncryption(String path) {
        StringBuilder res = new StringBuilder();
        for(Character c : path.toCharArray())
        {
            if(c == '.') res.append(' ');
            else res.append(c);
        }
        return res.toString();
    }
}
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 遍历使用 $O(N)$ ，每轮添加（修改）字符操作使用 $O(1)$ ；
- **空间复杂度 $O(N)$ ：** Python 新建的 list 和 Java 新建的 StringBuilder 都使用了线性大小的额外空间。
