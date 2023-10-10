#### 解题思路：

- **算法流程：** 设定 `i`，`j` 两指针分别指向 `num1`，`num2` 尾部，模拟人工加法；
    - **计算进位：** 计算 `carry = tmp // 10`，代表当前位相加是否产生进位；
    - **添加当前位：** 计算 `tmp = n1 + n2 + carry`，并将当前位 `tmp % 10` 添加至 `res` 头部；
    - **索引溢出处理：** 当指针 `i`或`j` 走过数字首部后，给 `n1`，`n2` 赋值为 $0$，相当于给 `num1`，`num2` 中长度较短的数字前面填 $0$，以便后续计算。
    - 当遍历完 `num1`，`num2` 后跳出循环，并根据 `carry` 值决定是否在头部添加进位 $1$，最终返回 `res` 即可。

- **复杂度分析：**
    - 时间复杂度 $O(max(M,N))$：其中 $M$，$N$ 为 $2$ 数字长度，按位遍历一遍数字（以较长的数字为准）；
    - 空间复杂度 $O(1)$：指针与变量使用常数大小空间。

<![Picture1.png](https://pic.leetcode-cn.com/ae367453af71c81803a1e9beee90495a19a406eacbb33f532acdf241f5297fed-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/113d975b781eae7a19258478e65e0017cfba5328af70eadd6d69e608ea7b7c94-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/b665de7e41201cedafc678c65f26eebbf6bcba2e051e6bf365a60b06d64ebd4f-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/f4423cda696c16e92de8804a72114154e3aa9b65a183dae5ccdbcbd7fb0c9aa4-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/a46f2e9cfae9875686d8b7a90b1966345ff1c85a064fccb2723f6657470910ab-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/e9e655ac9f21da0c59822e1ccb2782ad29f123964ead0b91ca9dfe2f4407fb97-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/23ffeeedcf0c11dece507bfd801c4af14f7888c2474cb08e4278a3bf27528541-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/921c2d55581204b62c7af8fcbadf2716656bb4b454b2641973f9a1286999a89b-Picture8.png)>

#### 代码：

```Python []
class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        res = ""
        i, j, carry = len(num1) - 1, len(num2) - 1, 0
        while i >= 0 or j >= 0:
            n1 = int(num1[i]) if i >= 0 else 0
            n2 = int(num2[j]) if j >= 0 else 0
            tmp = n1 + n2 + carry
            carry = tmp // 10
            res = str(tmp % 10) + res
            i, j = i - 1, j - 1
        return "1" + res if carry else res
```

```Java []
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }
}
```
