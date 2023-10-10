#### 解题思路：
 
- **算法原理** 
    - 栈先入后出特点恰好与本题括号排序特点一致，即若遇到左括号入栈，遇到右括号时将对应栈顶左括号出栈，则遍历完所有括号后 `stack` 仍然为空；
    - 建立哈希表 `dic` 构建左右括号对应关系：$key$ 左括号，$value$ 右括号；这样查询 $2$ 个括号是否对应只需 $O(1)$ 时间复杂度；建立栈 `stack`，遍历字符串 `s` 并按照算法流程一一判断。
- **算法流程**
    1. 如果 `c` 是左括号，则入栈 $push$；
    2. 否则通过哈希表判断括号对应关系，若 `stack` 栈顶出栈括号 `stack.pop()` 与当前遍历括号 `c` 不对应，则提前返回 $false$。
- **提前返回** $false$
    - **提前返回优点：** 在迭代过程中，提前发现不符合的括号并且返回，提升算法效率。
    - **解决边界问题：**
        - **栈** `stack` **为空：** 此时 `stack.pop()` 操作会报错；因此，我们采用一个取巧方法，给 `stack` 赋初值 $?$ ，并在哈希表 `dic` 中建立 $key: '?'，value:'?'$ 的对应关系予以配合。此时当 `stack` 为空且 `c` 为右括号时，可以正常提前返回 $false$；
        - **字符串** `s` **以左括号结尾：** 此情况下可以正常遍历完整个 `s`，但 `stack` 中遗留未出栈的左括号；因此，最后需返回 `len(stack) == 1`，以判断是否是有效的括号组合。
- **复杂度分析**
    - 时间复杂度 $O(N)$：正确的括号组合需要遍历 $1$ 遍 `s`；
    - 空间复杂度 $O(N)$：哈希表和栈使用线性的空间大小。

<![Picture1.png](https://pic.leetcode-cn.com/91ed1b06b593e0b7a2ddb967cf20077ad3c815826dfa602bf20c9214ec3cb466-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/829aae155c20fed4ce43a1bba2077bb46979a08e842b98f1f97f183a1016afee-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/5456814fa5b10a5e859996daaf2f6b56287af368134d8b04dce820612f2c4608-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/e782bcb808af96146e730f32feffabc7e224df847d9ff541d25171994748f243-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/bc514b643a0769c23b6a4ce86f8bb8207cee71c4b5aa41350f269b52b317256f-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1e5dd507b6a41a3e5ce1d9fc50f9c78a4cd8845ae6a8ec1c5146190abd97dfe4-Picture6.png)>

#### 代码：

```Python []
class Solution:
    def isValid(self, s: str) -> bool:
        dic = {'{': '}',  '[': ']', '(': ')', '?': '?'}
        stack = ['?']
        for c in s:
            if c in dic: stack.append(c)
            elif dic[stack.pop()] != c: return False 
        return len(stack) == 1
```

```Java []
class Solution {
    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};
    public boolean isValid(String s) {
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }
}
```
