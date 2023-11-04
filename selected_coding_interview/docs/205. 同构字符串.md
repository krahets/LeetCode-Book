## 解题思路

首先复习一下数学中映射的相关概念定义。设集合 `s` , `t` 中的某字符为 `x` , `y` ，

- 单射：对于任意 `x` ，都有唯一的 `y` 与之对应。
- 满射：对于任意 `y` ，至少存在一个 `x` 与之对应。
- 双射：既是单射又是满射，又称为一一对应。

![Slide1.png](https://pic.leetcode-cn.com/1656945936-BsSBMu-Slide1.png){:width=600}

接下来，抽象理解题目给定条件，

- “每个出现的字符都应当映射到另一个字符”。代表字符集合 `s` , `t` 之间是「满射」。
- “相同字符只能映射到同一个字符上，不同字符不能映射到同一个字符上”。代表字符集合 `s` , `t` 之间是「单射」。

因此， `s` 和 `t` 之间是「双射」，满足**一一对应**。考虑遍历字符串，使用哈希表 `s2t` , `t2s` 分别记录 $s \rightarrow t$ , $t \rightarrow s$ 的映射，当发现任意「一对多」的关系时返回 false 即可。

> 首页为动态图，其余为静态图。

<![figures.gif](https://pic.leetcode-cn.com/1656946175-rhEujv-figures.gif),![Slide2.png](https://pic.leetcode-cn.com/1656945956-GWOmgW-Slide2.png),![Slide3.png](https://pic.leetcode-cn.com/1656945956-KAShFK-Slide3.png),![Slide4.png](https://pic.leetcode-cn.com/1656945956-riGkIs-Slide4.png),![Slide5.png](https://pic.leetcode-cn.com/1656945956-uzdVpp-Slide5.png),![Slide6.png](https://pic.leetcode-cn.com/1656945956-WrrFGR-Slide6.png),![Slide7.png](https://pic.leetcode-cn.com/1656945956-olRMWK-Slide7.png),![Slide8.png](https://pic.leetcode-cn.com/1656945956-GITAQd-Slide8.png),![Slide9.png](https://pic.leetcode-cn.com/1656945956-XZZnsW-Slide9.png)>

## 代码

```Python []
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s2t, t2s = {}, {}
        for a, b in zip(s, t):
            # 对于已有映射 a -> s2t[a]，若和当前字符映射 a -> b 不匹配，
            # 说明有一对多的映射关系，则返回 false ；
            # 对于映射 b -> a 也同理
            if a in s2t and s2t[a] != b or \
               b in t2s and t2s[b] != a:
                return False
            s2t[a], t2s[b] = b, a
        return True
```

```Java []
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            // 对于已有映射 a -> s2t[a]，若和当前字符映射 a -> b 不匹配，
            // 说明有一对多的映射关系，则返回 false ；
            // 对于映射 b -> a 也同理
            if (s2t.containsKey(a) && s2t.get(a) != b || 
                t2s.containsKey(b) && t2s.get(b) != a)
                return false;
            s2t.put(a, b);
            t2s.put(b, a);
        }
        return true;
    }
}
```

```C++ []
class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> t2s, s2t;
        for (int i = 0; i < s.size(); i++) {
            char a = s[i], b = t[i];
            // 对于已有映射 a -> s2t[a]，若和当前字符映射 a -> b 不匹配，
            // 说明有一对多的映射关系，则返回 false ；
            // 对于映射 b -> a 也同理
            if (s2t.find(a) != s2t.end() && s2t[a] != b || 
                t2s.find(b) != t2s.end() && t2s[b] != a)
                return false;
            s2t[a] = b;
            t2s[b] = a;
        }
        return true;
    }
};
```

## 复杂度分析

- **时间复杂度 $O(N)$ ：** 其中 $N$ 为字符串 `s` , `t` 的长度。遍历字符串 `s` , `t` 使用线性时间，hashmap 查询操作使用 $O(1)$ 时间。
- **空间复杂度 $O(1)$ ：** 题目说明 `s` 和 `t` 由任意有效的 ASCII 字符组成。由于 ASCII 字符共 128 个，因此 hashmap `s2t` , `t2s` 使用 $O(128) = O(1)$ 空间。
