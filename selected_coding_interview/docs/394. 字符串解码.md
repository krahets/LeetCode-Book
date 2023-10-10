#### 解法一：辅助栈法

- 本题难点在于括号内嵌套括号，需要**从内向外**生成与拼接字符串，这与栈的**先入后出**特性对应。
- **算法流程：**
    1. 构建辅助栈 `stack`， 遍历字符串 `s` 中每个字符 `c`；
        - 当 `c` 为数字时，将数字字符转化为数字 `multi`，用于后续倍数计算；
        - 当 `c` 为字母时，在 `res` 尾部添加 `c`；
        - 当 `c` 为 `[` 时，将当前 `multi` 和 `res` 入栈，并分别置空置 $0$：
            - 记录此 `[` 前的临时结果 `res` 至栈，用于发现对应 `]` 后的拼接操作；
            - 记录此 `[` 前的倍数 `multi` 至栈，用于发现对应 `]` 后，获取 `multi × [...]` 字符串。
            - 进入到新 `[` 后，`res` 和 `multi` 重新记录。
        - 当 `c` 为 `]` 时，`stack` 出栈，拼接字符串 `res = last_res + cur_multi * res`，其中:
            - `last_res`是上个 `[` 到当前 `[` 的字符串，例如 `"3[a2[c]]"` 中的 `a`；
            - `cur_multi`是当前 `[` 到 `]` 内字符串的重复倍数，例如 `"3[a2[c]]"` 中的 `2`。
    2. 返回字符串 `res`。

- **复杂度分析：**
    - 时间复杂度 $O(N)$，一次遍历 `s`；
    - 空间复杂度 $O(N)$，辅助栈在极端情况下需要线性空间，例如 `2[2[2[a]]]`。

<![Picture1.png](https://pic.leetcode-cn.com/8c8d2fcc8ffcaa88b2f178e21e368c17d68298af0212daedddb1a431c4c0977e-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/c352fdf64535d0f167bff6978891cb28a179f430671dc2e657784cae07a7297a-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/8328efe852d10a148a255f038029f6e89342b3ed249da97b18913c8eb999e693-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/16007271dd7a9ec6cf21af3e53303a081f0e5b370107df3d35522f263c0f6382-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/e3d8b9b5113b8df61db539083d6b882bade19cea99dd9ea153f8cb13c66ec035-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/b803ce94a9bb8cc47812cf9c2a8d05598db28f2fd8aa2450ce3c788eb2640683-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/3eed0fe6407c8d767be54aa49b0a722c14d843fd50b236af5074e71a2f640ca6-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/b94aefc640cbf53682697e9114513c73e90dc12dcaf4d57b35d8c8a1e6fcad1e-Picture8.png)>

```Python []
class Solution:
    def decodeString(self, s: str) -> str:
        stack, res, multi = [], "", 0
        for c in s:
            if c == '[':
                stack.append([multi, res])
                res, multi = "", 0
            elif c == ']':
                cur_multi, last_res = stack.pop()
                res = last_res + cur_multi * res
            elif '0' <= c <= '9':
                multi = multi * 10 + int(c)            
            else:
                res += c
        return res
```

```Java []
class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }
}
```

---

#### 解法二：递归法

- 总体思路与辅助栈法一致，不同点在于将 `[` 和 `]` 分别作为递归的开启与终止条件：
    - 当 `s[i] == ']'` 时，返回当前括号内记录的 `res` 字符串与 `]` 的索引 `i` （更新上层递归指针位置）；
    - 当 `s[i] == '['` 时，开启新一层递归，记录此 `[...]` 内字符串 `tmp` 和递归后的最新索引 `i`，并执行 `res + multi * tmp` 拼接字符串。
    - 遍历完毕后返回 `res`。

- **复杂度分析：**
    - 时间复杂度 $O(N)$，递归会更新索引，因此实际上还是一次遍历 `s`；
    - 空间复杂度 $O(N)$，极端情况下递归深度将会达到线性级别。

```Python []
class Solution:
    def decodeString(self, s: str) -> str:
        def dfs(s, i):
            res, multi = "", 0
            while i < len(s):
                if '0' <= s[i] <= '9':
                    multi = multi * 10 + int(s[i])
                elif s[i] == '[':
                    i, tmp = dfs(s, i + 1)
                    res += multi * tmp
                    multi = 0
                elif s[i] == ']':
                    return i, res
                else:
                    res += s[i]
                i += 1
            return res
        return dfs(s,0)
```

```Java []
class Solution {
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }
    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') 
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i))); 
            else if(s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while(multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            }
            else if(s.charAt(i) == ']') 
                return new String[] { String.valueOf(i), res.toString() };
            else 
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[] { res.toString() };
    } 
}
```
