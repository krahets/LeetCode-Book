## 解题思路

1. 遍历字符串 `s` ，使用哈希表统计 “各字符数量是否 $> 1$ ”。
2. 再遍历字符串 `s` ，在哈希表中找到首个 “数量为 $1$ 的字符”，并返回。

![Picture1.png](https://pic.leetcode-cn.com/ed093aabc9195caff6d088454eaebe3cad875e8ca4a643c004ef25e4e5e9e174-Picture1.png){:width=450}

### 算法流程：

1. **初始化：** 字典 (Python)、HashMap(Java)、map(C++)，记为 `dic` 。
2. **字符统计：** 遍历字符串 `s` 中的每个字符 `c` 。
   1. 若 `dic` 中 **不包含** 键(key) `c` ：则向 `dic` 中添加键值对 `(c, True)` ，代表字符 `c` 的数量为 $1$ 。
   2. 若 `dic` 中 **包含** 键(key) `c` ：则修改键 `c` 的键值对为 `(c, False)` ，代表字符 `c` 的数量 $> 1$ 。
3. **查找数量为 $1$ 的字符：** 遍历字符串 `s` 中的每个字符 `c` 。
   1. 若 `dic`中键 `c` 对应的值为 `True` ：，则返回其索引。
   2. 否则，返回 `-1` ，代表不存在数量为 $1$ 的字符。

<![Picture2.png](https://pic.leetcode-cn.com/776cae7063c810e0f86031d44099b199c5f55f81f4d58ffbad19f1d798d31550-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/5b6324b396d06abe0511f81fa67a1eb795bad6a37e94e9ef6bde8557967ab8bc-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/240c928b3110664fbdd9c86aa44e4a6a34e29ceb55531b2640a802a00bf4a46f-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/7cb3b93272e8e7f770a32ce0c39271dc4b50804cc6e4dbe9541d2b9d64e96db8-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/5c68b55d5a5abae9223db9f380bcd199b5da5c8f9248e4809298b685f218d29a-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/aea83f7d093a5662867d34a8fc8da26ada4bbe7b64868d697645848167f6f3eb-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/32cf6ba91b799bf1f625fa39796f73a60dfad041589e82d0ed3545d08393f3bb-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/10bc69cab88ba6f5071b8b67c370d1e1dfa0db2e341268191c41e1e9c9820d52-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/4b44c787abeed308cbfc5c92cb72922d63cd7806b4524c961e025aac8bf59fbf-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/f0e078920fee1d2486d489fbaa10c75a3da3c2f3703d810509cfc8581b118274-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/98825f51afdf7c59df3bbb9a9370406d82cd1425eb5eaa508335cd727a82983d-Picture12.png)>

### 代码：

Python 代码中的 `not c in dic` 整体为一个布尔值； `c in dic` 为判断字典中是否含有键 `c` 。

```Python []
class Solution:
    def firstUniqChar(self, s: str) -> int:
        dic = {}
        for c in s:
            dic[c] = not c in dic
        for i, c in enumerate(s):
            if dic[c]: return i
        return -1
```

```Java []
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(int i = 0; i < sc.length; i++)
            if(dic.get(sc[i])) return i;
        return -1;
    }
}
```

```C++ []
class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char, bool> dic;
        for(char c : s)
            dic[c] = dic.find(c) == dic.end();
        for(int i = 0; i < s.size(); i++)
            if(dic[s[i]]) return i;
        return -1;
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** $N$ 为字符串 `s` 的长度；需遍历 `s` 两轮，使用 $O(N)$ ；HashMap 查找操作的复杂度为 $O(1)$ 。
- **空间复杂度 $O(1)$ ：** 由于题目指出 `s`  只包含小写字母，因此最多有 26 个不同字符，HashMap 存储需占用 $O(26) = O(1)$ 的额外空间。
