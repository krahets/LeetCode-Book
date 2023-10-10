## 方法一：双指针

### 算法解析：

- 倒序遍历字符串 $message$ ，记录单词左右索引边界 $i$ , $j$ ；
- 每确定一个单词的边界，则将其添加至单词列表 $res$ ；
- 最终，将单词列表拼接为字符串，并返回即可。

> 下图中的 `s` 对应本题的 `message` 。

<![Picture3.png](https://pic.leetcode-cn.com/1600795186-ODVGAC-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1600795186-KByGhl-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1600795186-pMSOXg-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1600795186-EllOEO-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1600795186-QrOavH-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1600795186-YlpmuP-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1600795186-PITxbA-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1600795186-fVKJYO-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/1600795186-fMtNcl-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/1600795186-GmppFo-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/1600795186-PXYpnz-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/1600795186-GezFXt-Picture14.png),![Picture15.png](https://pic.leetcode-cn.com/1600795186-XiNAjG-Picture15.png),![Picture16.png](https://pic.leetcode-cn.com/1600795186-ySOfTy-Picture16.png),![Picture17.png](https://pic.leetcode-cn.com/1600795186-DGmFEv-Picture17.png),![Picture18.png](https://pic.leetcode-cn.com/1600795186-rjhJhL-Picture18.png),![Picture19.png](https://pic.leetcode-cn.com/1600795186-CeiDKq-Picture19.png),![Picture20.png](https://pic.leetcode-cn.com/1600795251-iKyEDa-Picture20.png)>

### 代码：

```Python []
class Solution:
    def reverseMessage(self, message: str) -> str:
        message = message.strip()                      # 删除首尾空格
        i = j = len(message) - 1
        res = []
        while i >= 0:
            while i >= 0 and message[i] != ' ': i -= 1 # 搜索首个空格
            res.append(message[i + 1: j + 1])          # 添加单词
            while i >= 0 and message[i] == ' ': i -= 1 # 跳过单词间空格
            j = i                                      # j 指向下个单词的尾字符
        return ' '.join(res)                           # 拼接并返回
```

```Java []
class Solution {
    public String reverseMessage(String message) {
        message = message.trim();                               // 删除首尾空格
        int j = message.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && message.charAt(i) != ' ') i--;     // 搜索首个空格
            res.append(message.substring(i + 1, j + 1) + " ");  // 添加单词
            while (i >= 0 && message.charAt(i) == ' ') i--;     // 跳过单词间空格
            j = i;                                              // j 指向下个单词的尾字符
        }
        return res.toString().trim();                           // 转化为字符串并返回
    }
}
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 其中 $N$ 为字符串 $message$ 的长度，线性遍历字符串。
- **空间复杂度 $O(N)$ ：** 新建的 list(Python) 或 StringBuilder(Java) 中的字符串总长度 $\leq N$ ，占用 $O(N)$ 大小的额外空间。

## 方法二：分割 + 倒序

利用 “字符串分割”、“列表倒序” 的内置函数 *（面试时不建议使用）* ，可简便地实现本题的字符串翻转要求。

### 算法解析：

- **Python ：** 由于 $split()$ 方法将单词间的 “多个空格看作一个空格” （参考自 [split()和split(' ')的区别](https://www.cnblogs.com/python-coder/p/10073329.html) ），因此不会出现多余的 “空单词” 。因此，直接利用 $reverse()$ 方法翻转单词列表 $strs$ ，拼接为字符串并返回即可。

![Picture1.png](https://pic.leetcode-cn.com/1600795186-pzCvCm-Picture1.png){:align=center width=500}

- **Java ：** 以空格为分割符完成字符串分割后，若两单词间有 $x > 1$ 个空格，则在单词列表 $strs$ 中，此两单词间会多出 $x - 1$ 个 “空单词” （即 `""` ）。解决方法：倒序遍历单词列表，并将单词逐个添加至 StringBuilder ，遇到空单词时跳过。

![Picture2.png](https://pic.leetcode-cn.com/1600795186-RmKJXL-Picture2.png){:align=center width=500}

### 代码：

```Python []
class Solution:
    def reverseMessage(self, message: str) -> str:
        message = message.strip()   # 删除首尾空格
        strs = message.split()      # 分割字符串
        strs.reverse()              # 翻转单词列表
        return ' '.join(strs)       # 拼接为字符串并返回
```

```Java []
class Solution {
    public String reverseMessage(String message) {
        String[] strs = message.trim().split(" ");    // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {  // 倒序遍历单词列表
            if(strs[i].equals("")) continue;          // 遇到空单词则跳过
            res.append(strs[i] + " ");                // 将单词拼接至 StringBuilder
        }
        return res.toString().trim();                 // 转化为字符串，删除尾部空格，并返回
    }
}
```

Python 可一行实现：

```Python []
class Solution:
    def reverseMessage(self, message: str) -> str:
        return ' '.join(message.strip().split()[::-1])
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 总体为线性时间复杂度，各函数时间复杂度和参考资料链接如下。
  - [`split()` 方法：](https://softwareengineering.stackexchange.com/questions/331909/whats-the-complexity-of-javas-string-split-function) 为 $O(N)$ ；
  - [`trim()` 和 `strip()` 方法：](https://stackoverflow.com/questions/51110114/is-string-trim-faster-than-string-replace) 最差情况下（当字符串全为空格时），为 $O(N)$ ；
  - [`join()` 方法：](https://stackoverflow.com/questions/37133547/time-complexity-of-string-concatenation-in-python) 为 $O(N)$ ；
  - [`reverse()` 方法：](https://stackoverflow.com/questions/37606159/what-is-the-time-complexity-of-python-list-reverse) 为 $O(N)$ ；
- **空间复杂度 $O(N)$ ：** 单词列表 $strs$ 占用线性大小的额外空间。
